package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserService;
import ServiceImpl.UserServiceImpl;
import net.sf.json.JSONObject;

//用户登录
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   try { 
					
			   request.setCharacterEncoding("utf-8");
		          //1.接收数据
		           String username=request.getParameter("username");
		           String password=request.getParameter("password");   
		           
		           
		          //2.判断能否成功登陆
		           UserService service=new UserServiceImpl();
		           int userid;
				   userid = service.login(username, password);
  
		           JSONObject jsonobject=new JSONObject();
		           if(userid==0)
		        	    jsonobject.put("flag", "false");
		           else
		           {
		        	   jsonobject.put("flag", "true");
		        	   jsonobject.put("userid", userid);
		           }
		          response.getWriter().write(jsonobject.toString());
		          //System.out.println("flag="+flag+"userid"+userid);
		     
		          
				} catch (SQLException e) {
					e.printStackTrace();
				}
		           
		               
		
	}

}
