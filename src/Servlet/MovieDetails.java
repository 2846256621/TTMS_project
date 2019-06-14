package Servlet;

//用户点击剧目 获取剧目信息和演出计划
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import domain.Schedule;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.PlayService;
import Service.ScheduleService;
import ServiceImpl.PlayServiceImpl;
import ServiceImpl.ScheduleServiceImpl;
import domain.Play;
import net.sf.json.JSONObject;


public class MovieDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    
		try { 
		 response.setContentType("text/json;charset=utf-8");
	     int playid=Integer.parseInt(request.getParameter("playid"));
	     //查询一个剧目的所有信息
	     
	     PlayService service=new PlayServiceImpl();
	     ScheduleService service2=new ScheduleServiceImpl();
	     
	     Play play=service.search(playid);
	     
	     //通过playid查询演出计划
	     List<Schedule> list=service2.findAll(playid);
	     
	     for(Schedule schedule:list)
	     {
	    	 
	    	 int studioid = schedule.getStudioid();
			  //根据演出厅id查找演出厅名字
			  schedule.setStudioname(service2.findStudioName(studioid)); 
			  
			  //根据playid查找playname
			  schedule.setPlayname(service.FindPlayName(playid));
		}
	    
	    
	     JSONObject jsonobject=new JSONObject();
	     jsonobject.put("playid", play.getPlayid());
	     jsonobject.put("playname", play.getPlayname());
	     jsonobject.put("director", play.getDirector());
	     jsonobject.put("actor", play.getActor());
	     jsonobject.put("playtype", play.getPlaytype());
	     jsonobject.put("country", play.getCountry());
	     jsonobject.put("language", play.getLanguage());
	     jsonobject.put("duration", play.getDuration());
	     jsonobject.put("introduction", play.getIntroduction());
	     jsonobject.put("picture", play.getPicture());
	     jsonobject.put("schedule",list);
	     
	     response.getWriter().write(jsonobject.toString());
	   } catch (SQLException e) {
		
			e.printStackTrace();
		}
	    
	     
	     
	     
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
