package Servlet;
//管理员查询演出计划

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import domain.Schedule;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ScheduleService;
import ServiceImpl.ScheduleServiceImpl;
import Util.TestUtil;

public class ScheduleSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		  try { 
			  request.setCharacterEncoding("utf-8");
			  response.setContentType("text/json;charset=utf-8");
			      
		  String playname=request.getParameter("playname");
		  ScheduleService service=new ScheduleServiceImpl();
		  HashMap<String,Object> resultMap = new HashMap<String,Object>();
		  
		  //根据剧目名称查询playid (剧目名称和id一一对应)
		  int playid=service.findPlayID(playname);
		 
		  if(playid == 0) {
			  resultMap.put("flag", "0");
			  resultMap.put("errmsg","暂无演出计划");
			  TestUtil.test(response,resultMap);
		  }
		  
		   //根据playid查询该剧目的所有的演出计划
		  List<Schedule> list=new ArrayList<Schedule>();
		  list=service.findAll(playid);
		 
		  if(list == null && list.size() == 0)
		  {
			  //向前台返回 五
			  resultMap.put("flag", "0");
			  resultMap.put("errmsg","暂无演出计划");
			 
		  }
		  else
		  {
			  for(Schedule schedule:list) 
			  {
				  schedule.setPlayname(playname);
				  
				  int studioid = schedule.getStudioid();
				  //根据演出厅id查找演出厅名字
				  schedule.setStudioname(service.findStudioName(studioid)); 
			  }
			    resultMap.put("flag","1");
			    resultMap.put("data",list);
	     } 
		  TestUtil.test(response,resultMap);

		  
		  
			
	} catch (SQLException e) {
			e.printStackTrace();
		}
		  
		  
		  
		  
		
	}

}
