package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ScheduleService;
import ServiceImpl.ScheduleServiceImpl;
import Util.TestUtil;
import domain.Schedule;


public class ScheduleModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
			
	     request.setCharacterEncoding("utf-8");
	     response.setContentType("text/json;charset=utf-8");
	     //1.接收新的数据
	     int scheduleid=Integer.parseInt(request.getParameter("scheduleid"));
	     String  playname=request.getParameter("playname");
	     String  date=request.getParameter("date");
	     String studioname=request.getParameter("studioname");
	     int price=Integer.parseInt(request.getParameter("price"));
	     String begintime=request.getParameter("begintime");
	     
	     ScheduleService service=new ScheduleServiceImpl();
	     
		 int playid=service.findPlayID(playname);
		 int studioid=service.findStudioID(studioname);
		 
		 
		  Schedule schedule=new Schedule(scheduleid,date,studioid,price,playid,begintime);
		  service.update(schedule);
		  
		  TestUtil.test(response);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	     
	    
		
	}

}
