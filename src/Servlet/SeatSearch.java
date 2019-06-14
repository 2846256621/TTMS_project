package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.SeatService;
import ServiceImpl.SeatServiceImpl;
import domain.Seat;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
//管理员查询所有的座位  根据演出厅id获取的是座位的所有状态  是一个二维数组

public class SeatSearch extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			    response.setContentType("text/json; charset=UTF-8");
			     //1.接收演出厅id
		        int studioid=Integer.parseInt(request.getParameter("studioid"));
		            System.out.println(studioid);
		            
		        //2.获取演出厅的座位和行数和列数
		           SeatService service= new SeatServiceImpl();	   
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
