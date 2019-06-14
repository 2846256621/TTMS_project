package Servlet;
//管理员删除演出计划


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ScheduleService;
import ServiceImpl.ScheduleServiceImpl;
import Util.TestUtil;


public class ScheduleDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		  try {
		    //1.根据scheduleid删除演出计划
		     int scheduleid=Integer.parseInt(request.getParameter("scheduleid"));
		   
		      ScheduleService service=new ScheduleServiceImpl();
				service.delete(scheduleid);
				
				TestUtil.test(response);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
