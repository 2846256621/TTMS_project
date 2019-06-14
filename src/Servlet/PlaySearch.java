package Servlet;
//管理员查询剧目   模糊查询和查询全部剧目
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.PlayService;
//管理员查询剧目   模糊查询和查询全部剧目
import ServiceImpl.PlayServiceImpl;
import Util.TestUtil;
import domain.Play;
import net.sf.json.JSONArray;

public class PlaySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	          
	      try { 
	            //1.接收数据
	            request.setCharacterEncoding("utf-8");
	            response.setContentType("text/json;charset=utf-8");
	            
	            String name=request.getParameter("playname");
	            
	            //2.判断name是否为空  
	            PlayService service=new PlayServiceImpl();
	            List<Play> list = new ArrayList<Play>();
			  	HashMap<String,Object> resultMap = new HashMap<String,Object>();
			  if(name!=null && name.length()>0)
			  {
				  list=service.find(name);


				  if(list.size()==0)
				  {
					  resultMap.put("flag", "0");
					  resultMap.put("errmsg","暂无剧目计划");
				  }

				  else
				  {
					  resultMap .put("flag","1");
					  resultMap.put("data",list);
				  }
			  }
			  else
			  {
				  list=service.findAll();
				  resultMap .put("flag","1");
				  resultMap.put("data",list);
			  }
			  TestUtil.test(response,resultMap);

		  }  catch (SQLException e) {
						e.printStackTrace();
			}
	            
	}

}
