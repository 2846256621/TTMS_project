package Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class TestUtil {
	/*
	 * 判断某一个字符串是否为空
	 */
	public static boolean  isEmpty(CharSequence s) {
		return s==null || s.length()==0;
	}
	
	
	public static  void test(HttpServletResponse response) throws IOException {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain; charset=UTF-8");
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			
			HashMap<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("flag","1");
			//resultMap.put("data", new ArrayList<String>());
			Object jsonobject=JSONObject.fromObject(resultMap);
			response.getWriter().print(jsonobject);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			response.getWriter().flush();
			response.getWriter().close();
		}
	}
	
	public static  void test(HttpServletResponse response,HashMap<String,Object> resultMap) throws IOException {
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain; charset=UTF-8");
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			
	
			//resultMap.put("data", new ArrayList<String>());
			Object jsonobject=JSONObject.fromObject(resultMap);
			response.getWriter().print(jsonobject);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			response.getWriter().flush();
			response.getWriter().close();
		}
	}
	
	
	

	}


