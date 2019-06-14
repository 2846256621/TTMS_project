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
import domain.Play;
//管理员增加剧目

public class PlayAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
	      try {
	    	  
	      request.setCharacterEncoding("utf-8");
	      response.setContentType("text/json;charset=utf-8");
	      //1.接收数据
	      String playname=request.getParameter("playname");
	      String director=request.getParameter("director");
	      String actor=request.getParameter("actor");
	      String playtype=request.getParameter("playtype");
	      String country=request.getParameter("country");
	      String language=request.getParameter("language");
	      String  length=request.getParameter("duration");
	      String introduction=request.getParameter("introduction");
	      
	      int duration=Integer.parseInt(length);
	      //2.封装数据存储在数据库中
	      Play play=new Play(playname,director,actor,playtype,country,language,duration,introduction);
	      PlayService service=new PlayServiceImpl();
		  int playid=service.insert(play);
		  
		   TestUtil.test(response);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	      
	      
		
	}

}
