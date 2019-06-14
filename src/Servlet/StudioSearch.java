package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//查询演出厅   完成两件事 1.演出厅管理直接进去就是查询全部的演出厅信息    2. 根据演出厅的名称进行迷糊查询

import Service.StudioService;
import ServiceImpl.StudioServiceImpl;
import Util.TestUtil;
import domain.Studio;
import net.sf.json.JSONArray;

public class StudioSearch extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			    request.setCharacterEncoding("utf-8");
			    response.setContentType("text/json;charset=utf-8");
				String name = request.getParameter("studioname");
			    List<Studio> list = null;
			    StudioService service = new StudioServiceImpl();
				HashMap<String,Object> resultMap = new HashMap<String,Object>();
		        if(name!=null && name.length()>0)
		        {
				       list=service.find(name);

				       if(list.size()==0)
					   {
						   resultMap.put("flag","0");
					   }
					   else
					   {
						   resultMap.put("flag","1");
						   resultMap.put("data",list);
					   }
		        }
		        else {
					list = service.findAll();
					resultMap.put("flag","1");
					resultMap.put("data",list);
				}

				TestUtil.test(response,resultMap);

		        } catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
