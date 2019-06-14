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


public class PlayModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  try {
	      request.setCharacterEncoding("utf-8");
	      response.setContentType("text/json;charset=utf-8");
	      //1.接收数据
	      int playid=Integer.parseInt(request.getParameter("playid"));
	      String playname=request.getParameter("playname");
	      String director=request.getParameter("director");
	      String actor=request.getParameter("actor");
	      String playtype=request.getParameter("playtype");
	      String country=request.getParameter("country");
	      String language=request.getParameter("language");
	      int duration=Integer.parseInt(request.getParameter("duration"));
	      String introduction=request.getParameter("introduction");
	      
	      
	      //2.将新数据传进数据库中
	      PlayService service=new PlayServiceImpl();
	      Play play=new Play(playname,director,actor,playtype,country,language,duration,introduction);
		  service.update(playid,play);
			
			//3.响应
			TestUtil.test(response);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	      
	      
	      
	    
	}

}
