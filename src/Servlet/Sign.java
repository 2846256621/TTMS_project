package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserService;
import ServiceImpl.UserServiceImpl;

//用户注册
public class Sign extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		         try {
		        	 
		        	 request.setCharacterEncoding("utf-8");
		        	 
					   //1.接收用户名和密码
		              String username=request.getParameter("username");
		              String password=request.getParameter("password");
		           System.out.println(username+password);
		         
		              //2.插入到数据库中
		               UserService service=new UserServiceImpl();
				      
					  //3.判断是否注册成功
					   response.setContentType("text/json;charset=utf-8");
					   int flag=service.login(username, password);             //查询是否注册了该用户   
					   if(flag==0)
					   {
						   service.insert(username, password);       //没有注册该用户就返回0   然后进行注册
						   response.getWriter().write("true");
					   }
					   else
					        response.getWriter().write("false");     //否则直接返回false
					  
		         
		        } catch (SQLException e) {
					e.printStackTrace();
				}
		         
	}

}
