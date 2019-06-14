package Servlet;

//管理员增加演出计划
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ScheduleService;
import ServiceImpl.ScheduleServiceImpl;
import Util.TestUtil;
import domain.Schedule;


public class ScheduleAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	     try { 
	      request.setCharacterEncoding("utf-8");
	     response.setContentType("text/json;charset=utf-8");
	    
	     //1.接收数据
	     String  playname=request.getParameter("playname");
	     String  date=request.getParameter("date");
	     String studioname=request.getParameter("studioname");
	     int price=Integer.parseInt(request.getParameter("price"));
	     String begintime=request.getParameter("begintime");
	     
	     //2.根据playname，studioname找到playid和studioid
	     HashMap<String,Object> resultMap = new HashMap<String,Object>();
	     ScheduleService service=new ScheduleServiceImpl();
		 int playid=service.findPlayID(playname);
		 
		 if(playid==0)
		 {
			 resultMap.put("flag", "0");
			  TestUtil.test(response,resultMap);
		 }
			 
		 int studioid=service.findStudioID(studioname);
		 
		 Schedule schedule=new Schedule(date,studioid, price, playid,begintime);
		 
		 service.insert(schedule);
		 TestUtil.test(response);
		 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	     
	     
	     
	     
	     
	     
	
	}

}
