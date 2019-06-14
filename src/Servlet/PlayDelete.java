package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.PlayService;
import ServiceImpl.PlayServiceImpl;
import Util.TestUtil;
//管理员删除剧目

public class PlayDelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 try { 
		 response.setContentType("text/json;charset=utf-8");
		//1.根据剧目id删除剧目    
		int playid=Integer.valueOf(request.getParameter("playid"));
		
		//2.在数据库里删除剧目
		 PlayService  service=new PlayServiceImpl();
			service.delete(playid); 
		
		//3.返回1
		TestUtil.test(response);
	   }
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		  
	}

}
