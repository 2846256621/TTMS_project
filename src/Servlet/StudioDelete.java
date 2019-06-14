package Servlet;


//删除演出厅
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.StudioService;
import ServiceImpl.StudioServiceImpl;
import Util.TestUtil;
import domain.Studio;


public class StudioDelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
			response.setContentType("text/json;charset=utf-8");
	     //1.接收演出厅id
		int studioid=Integer.valueOf(request.getParameter("studioid"));
		
		//2.执行删除
		StudioService service=new StudioServiceImpl();
	    service.delete(studioid);
	    TestUtil.test(response);
		  
		//3.跳转页面  查询所有的演出厅信息   由前端操作	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		 
		
	}

}
