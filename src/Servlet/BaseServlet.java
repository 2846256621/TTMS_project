package Servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;


public class BaseServlet {
	public   Map<String, Object> retMap = new HashMap<String, Object>();

	{
		retMap.put("ret", 1);
	}
	/**
	 * @param request
	 * @param response
	 */
	/**
	 * @param request
	 * @param response
	 */
	/**
	 * @param request
	 * @param response
	 */
	public void writeJson(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=UTF-8");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		
		String retre2 = null;
		try {
			JSONObject jsonobject=new JSONObject();
			
			retre2=jsonobject.fromObject(retMap).toString();
	
		
			response.getWriter().print(retre2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}


}
