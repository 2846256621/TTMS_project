package Util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

 
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
	    HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
	    HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
	    httpResponse.addHeader("Access-Control-Allow-Origin", httpRequest.getHeader("Origin"));
	    httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, accessToken ,operatorId ,memberId ,sessionId,version,userId,token,clientInfo,cookie");
	    httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	    httpResponse.addHeader("Access-Control-Allow-Credentials", "true");//解决js请求跨域session问题
	    httpResponse.addHeader("Access-Control-Expose-Headers", "is_authc");
	    filterChain.doFilter(servletRequest, servletResponse);
	}

	    public void init(FilterConfig filterConfig) {
	    }
	 
	    public void destroy() {}


}
