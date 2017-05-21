package web.app.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.SecurityContext;

@WebFilter(value = "/api/*")
public class WebAppMainFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;		
		String url = httpRequest.getRequestURL().toString();
		String token = httpRequest.getHeader("Authentication");
		System.out.println("Path" + url);
		System.out.println("Authentication Header " + token);
		chain.doFilter(request, response);		
	}

}
