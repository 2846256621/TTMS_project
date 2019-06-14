package Servlet;

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

//修改演出厅      根据演出厅id
public class StudioModify extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	     try {
	    	 request.setCharacterEncoding("utf-8");
	    	 response.setContentType("text/json;charset=utf-8");
	     
	    	 //1.接收新的数据并封装成对象
	        int studioid=Integer.parseInt(request.getParameter("studioid"));  
	        String studioname=request.getParameter("studioname");  
	        int rowcount=Integer.parseInt(request.getParameter("rowcount"));
	        int colcount=Integer.parseInt(request.getParameter("colcount"));
	    
	       Studio studio=new Studio(studioid,studioname,rowcount,colcount);
	        System.out.println(studioname);
	        //2.在数据库进行修改
	       StudioService service= new StudioServiceImpl();
		   service.update(studio);
			
		   TestUtil.test(response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	}

}
