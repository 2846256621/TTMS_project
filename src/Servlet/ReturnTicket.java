package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.TicketService;
import ServiceImpl.TicketServiceImpl;

/*
 * 用户退票   接收orderid然后在order数据库里找到这个订单和utid，根据utid在user_seat表里删除一条记录   然后找到根据seatid找到所有的座位改掉状态
 *    顺序是  1.先改座位状态   2.在删除user_se表中的记录   3.最后删除order表里的订单
 */

        
public class ReturnTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 try {
			 //1.接收orderid
		   int orderid=Integer.parseInt(request.getParameter("orderid"));
		   
		   //2，删除订单 
		    TicketService service=new TicketServiceImpl();
			service.delete(orderid);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
