package Servlet;

//用户 ： 查看所有座位
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.SeatService;
//用户查看所有的座位
import ServiceImpl.SeatServiceImpl;
import domain.Seat;
import net.sf.json.JSONObject;

public class MovieSeat extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			  response.setContentType("text/json; charset=UTF-8");     
			   //1.根据演出厅id查询所有座位   
		        int studioid=Integer.parseInt(request.getParameter("studioid"));
		        
		         SeatService service=new SeatServiceImpl();
		         List<Seat> list=service.findAll(studioid);
		        
		            HashMap<String,Object> resultMap = new HashMap<String,Object>();
					resultMap.put("rowcount",service.findRow(studioid));
					resultMap.put("colcount",service.findCol(studioid));
				    resultMap.put("seat", list);
					Object jsonobject=JSONObject.fromObject(resultMap);
					
			       response.getWriter().write(jsonobject.toString());
	          
	           
		   } catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		    
	}

}
