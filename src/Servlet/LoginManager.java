package Servlet;

//用户登录直接判断是否成功登陆  因为数据库中只有一个用户
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ManagerService;
import ServiceImpl.ManagerServiceImpl;
import domain.Manager;
import net.sf.json.JSONObject;


public class  LoginManager  extends  HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	         try { 
	        	     
		      //1.接收数据
	        	request.setCharacterEncoding("utf-8");
	           String  managerName=request.getParameter("managername");
	           String managerpassword=request.getParameter("managerpassword");
	 
	            //2.判断是否成功登陆
	           ManagerService service=new ManagerServiceImpl();
			   Manager user=service.login();
			                                                          
			    //3.响应字符串标志判断是否成功登陆
			   if( user.getManagername().equals(managerName) &&user.getManagerpassword().equals(managerpassword))
				   response.getWriter().write("true");
			   else
				   response.getWriter().write("false");
			 
		       } catch (SQLException e) {
				
				e.printStackTrace();
			}
	           
	           
	          
	           
	          
	}

}
