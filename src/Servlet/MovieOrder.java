package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.TicketDao;
import DaoImpl.TicketDaoImpl;
import Service.TicketService;
import ServiceImpl.TicketServiceImpl;
import domain.Ticket;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//用户：查询所有的订单
public class MovieOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			 request.setCharacterEncoding("utf-8");
		     response.setContentType("text/json;charset=utf-8");
		   //1.根据用户id查询所有的订单
		   int userid=Integer.parseInt(request.getParameter("userid"));
		
		   //System.out.println(userid);
		   //2.在订单数据库中进行查询
		   TicketService service=new TicketServiceImpl();
		   TicketDao dao=new TicketDaoImpl();
		   
			List<Ticket> list=service.findAll(userid);
			 
			
			
			JSONArray jsonarray=new JSONArray();           //一个用户有多个订单  就是一个jsonarray
			 for(Ticket ticket:list)
			 {
				 JSONObject jsonobject=new JSONObject();  
				// System.out.println(ticket.getOrderid());
				 //一个jsonobject里面有一个订单的所有信息  
				 jsonobject.put("orderid", ticket.getOrderid()); 
				
				 //一个订单一个orderid
				 String username=dao.findUserName(ticket.getUserid());   
				 jsonobject.put("username", username);
				 String playname=dao.findPlayName(ticket.getPlayid()); 
				 jsonobject.put("playname",playname);   
				 String studioname=dao.findStudioName(ticket.getStudioid());
				 jsonobject.put("studioname", studioname);
				 String date=dao.findDate(ticket.getScheduleid()); 
				 jsonobject.put("date", date);                      
				 String begintime=dao.findBeginTime(ticket.getScheduleid());   
				 jsonobject.put("begintime",begintime); 
				 jsonobject.put("allprice", ticket.getAllprice());
				 int utid=ticket.getUtid();
				 
				 String seat=dao.findSeatID(utid);     //一个订单的所有座位是一个jsonarray数组       
				 JSONArray jsonarray2=new JSONArray();

				 String[] arr=seat.split(",");
				 for(int i=0;i<arr.length;i++)
				 {
					 int seatid=Integer.parseInt(arr[i]);
					 JSONObject jsonobject2=dao.findSeat(seatid);
					 jsonarray2.add(i,jsonobject2);
				 }
				 
				 jsonobject.put("seat",jsonarray2);    //将座位形成的jsonarray加入到一个订单jsonobject里
				 
				 String ordertime=ticket.getOrdertime();                       //一个订单有一个下单时间  
				 jsonobject.put("ordertime", ordertime);                       
				 
				 
				 //把一个订单加入到订单数组里
				 jsonarray.add(jsonobject);
				}
			 
			
			
			//3.响应一个用户的所有订单
			response.getWriter().write(jsonarray.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}             
	}

}
