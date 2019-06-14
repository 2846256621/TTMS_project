package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.SeatService;
import ServiceImpl.SeatServiceImpl;
import Util.TestUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//修改座位状态        查询该座位的状态并修改成相反状态   
public class SeatModify extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		//1.接收要修改座位的行号和列号  ( "json数组")
		int studioid=Integer.parseInt(request.getParameter("studioid"));
		String[]  modify_seat=request.getParameterValues("modify_seat[]");
		
		
		SeatService service=new SeatServiceImpl();
		
		//2.解析出每一个座位的行号和列号   修改座位状态  
		JSONArray jsonArray=JSONArray.fromObject(modify_seat);
		JSONObject jsonObject;
		
		for(int i=0;i<jsonArray.size();i++)
		{
			jsonObject=jsonArray.getJSONObject(i);
		
			int row=(int) jsonObject.get("seatrow");
			int col=(int) jsonObject.get("seatcol");
	
			int status=service.search(studioid,row,col);              //查找对应演出厅的对应座位的状态
			if(status==1 || status==2)
			{
				    status=3;     //将好座位(待售和已售)变成坏座位
				    service.update(studioid,row,col,status);       //修改座位状态
			}
			else if(status==3)
			{
				    status=1;    //将坏座位变成好座位
				    service.update(studioid,row,col,status);     //不能将修改语句放在if语句之后  因为还有状态0
			} 
		
	     }
		     TestUtil.test(response);
		}
		 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
