package Servlet;


//首页   响应剧目的所有信息
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.PlayService;
import ServiceImpl.PlayServiceImpl;
import domain.Play;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        try {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        
        
        PlayService service=new PlayServiceImpl();
        List<Play> list=new ArrayList<Play>();
        list=service.findAll();
        
        JSONArray jsonarray=JSONArray.fromObject(list);
        
//        for(int i=0;i<jsonarray.size();i++)
//        {
//        	JSONObject jsonobject=(JSONObject) jsonarray.get(i);
//        	System.out.println(jsonobject.getString("playname")+"  "+jsonobject.getString("country"));
//        	
//        }
        
        response.getWriter().write(jsonarray.toString());
        
        } catch (SQLException e) {
			e.printStackTrace();
		}
        
        
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
