package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;

import Service.TicketService;
import ServiceImpl.TicketServiceImpl;
import Util.TestUtil;
import domain.Ticket;
import domain.User_Seat;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
//  用户 ：买多个票-------->存储一个订单



public class MovieTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int utid=0;       //全局变量

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		     try {
		    	 
		    	 request.setCharacterEncoding("utf-8");
			     response.setContentType("text/json;charset=utf-8");

		      //1.获取订单的所有信息
		     int  playid=Integer.parseInt(request.getParameter("playid"));
	         int  studioid=Integer.parseInt(request.getParameter("studioid"));
	         int userid=Integer.parseInt(request.getParameter("userid"));
	         int scheduleid=Integer.parseInt(request.getParameter("scheduleid"));     
	         int allprice=Integer.parseInt(request.getParameter("allprice"));
	         String ordertime=request.getParameter("ordertime");
	         
	         String[] seat=request.getParameterValues("seat[]");
	        
	         
	          //2.找到要存储的订单信息   
	         TicketService service=new TicketServiceImpl();
	         
	         JSONArray jsonArray=JSONArray.fromObject(seat);
	         JSONObject jsonobject=null;
	         
	         //向关联表中插入数据   一个订单一个关联表
	         int[] arr=new int[jsonArray.size()];
	         for(int i=0;i<jsonArray.size();i++)
	         {
	        	  jsonobject=jsonArray.getJSONObject(i);
	        	  int row=jsonobject.getInt("seatrow");
	        	  int col=jsonobject.getInt("seatcol");  
	        	  //根据行号和列号找到座位id  
	        	 arr[i]=service.findSeatid(row, col,studioid); 
	        	 service.update(studioid, arr[i]);
	        	  
	         } 
	         //将数组转成字符串
	          String seatid="";
               for(int i=0;i<arr.length;i++)
               {
            	   seatid+=arr[i];
            	   if(i != arr.length-1) {
            		   seatid +=",";
            	   }
               }
	         
	         //存在seat-user表中  
	          User_Seat us=new User_Seat(userid,seatid,studioid);
	          int utid=service.add(us);
	         
	          
	          //在seat_user表中查询utid存入数据库中
	         // int utid=service.findUtid(userid);
	          
	          
	          int order_status=1;         //订单        
	          //3.封装订单存入数据库                     
	         Ticket order=new Ticket(playid,utid,userid,studioid,scheduleid,allprice,ordertime,order_status );
              service.insert(order);
             
            HashMap<String,Object> resultMap = new HashMap<String,Object>();
            resultMap.put("flag", "1");
           Date date = new Date();
           SimpleDateFormat  sdf = new SimpleDateFormat  ("yyyy-MM-dd HH:mm:ss");
           String aa = sdf.format(date);
            aa = aa.replace("-", "");
            aa = aa.replace("", "");
            aa = aa.replace(":", "");
        	StringBuffer sb = new StringBuffer();
        
            sb.append(aa);
            resultMap.put("orderid",sb.toString());
            resultMap.put("allprice",allprice);
            resultMap.put("orderName","小时光订单");
             
         
	          
             TestUtil.test(response,resultMap);
             
	   } catch (SQLException e) {
				e.printStackTrace();
			}
	         
	      
	         
	         
	         
	}

}
