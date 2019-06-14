package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.SeatService;
import Service.StudioService;
import ServiceImpl.SeatServiceImpl;
import ServiceImpl.StudioServiceImpl;
import Util.TestUtil;
import domain.Seat;
import domain.Studio;
import net.sf.json.JSONObject;

//增加演出厅的servlet
public class StudioAdd extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	   try {
	      //1.接收数据并封装对象
		  
 		   request.setCharacterEncoding("utf-8");
 		   response.setContentType("text/json;charset=utf-8");
 		   
		  String studioname=request.getParameter("studioname");
		  int rowcount=Integer.parseInt(request.getParameter("rowcount"));
		  int colcount=Integer.parseInt(request.getParameter("colcount"));

		 
		  Studio studio=new Studio(studioname,rowcount,colcount);
		  
		  //2.添加到数据库
		    StudioService service=new StudioServiceImpl();
			int studioid= service.insert(studio);
			//找到新增的studioid
			SeatService s =new SeatServiceImpl();
			Seat seat=null;
			try {
				//给演出厅中添加座位
			  for(int i=1;i<=rowcount;i++)
			  {
				  for(int j=1;j<=colcount;j++)
				  {
					  seat=new Seat(i,j,1,studioid);
					  s.add(seat);              //增加座位   初始状态都是好座位
				  }
			  }
			}catch (SQLException e) {
				e.printStackTrace();
			}	     
			TestUtil.test(response);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	

}
