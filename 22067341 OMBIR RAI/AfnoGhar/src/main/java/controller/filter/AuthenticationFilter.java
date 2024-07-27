package controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.StringUtils;

public class AuthenticationFilter implements Filter {
public AuthenticationFilter() {
	// TODO Auto-generated constructor stub
}
@Override
public void init(FilterConfig filterConfig) throws ServletException {
	// TODO Auto-generated method stub
	
}


@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
	// TODO Auto-generated method stub
	HttpServletRequest req = (HttpServletRequest) request;
	HttpServletResponse resp = (HttpServletResponse) response;
	
	String uri = req.getRequestURI();
	System.out.println(uri);
	
	if (uri.endsWith(".css") || uri.endsWith(StringUtils.URL_HOME)|| uri.endsWith(StringUtils.SERVLET_URL_SIGNUP)) {
		chain.doFilter(req, resp);
		return;
	}
	
	boolean isLogin = uri.endsWith(StringUtils.PAGE_URL_LOGIN);
	
	boolean isLoginServlet = uri.endsWith(StringUtils.SERVLET_URL_LOGIN);
	
	boolean isLogoutServlet = uri.endsWith(StringUtils.SERVLET_URL_LOGOUT);
	
	boolean isRegisterPage = uri.endsWith(StringUtils.PAGE_URL_SIGNUP);
	
	//);
	
	
	HttpSession session = req.getSession(false);
	
	boolean isLoggedIn = session != null && session.getAttribute(StringUtils.EMAIL)!= null;
	
	if (!isLoggedIn && !(isLogin || isLoginServlet || isRegisterPage /**|| isRegisterServlet**/)) {
		resp.sendRedirect(req.getContextPath()+ StringUtils.PAGE_URL_LOGIN);
	}else if(isLoggedIn && !(!isLogin || isLogoutServlet)) {
		resp.sendRedirect(req.getContextPath()+StringUtils.URL_HOME);
	}/**else if(isLoggedIn || isRegisterPage || isLogin ){
		resp.sendRedirect(req.getContextPath()+StringUtils.URL_INDEX);/
	
	
		
	}**/else if(isLoggedIn && isLoginServlet){
		resp.sendRedirect(req.getContextPath()+StringUtils.PAGE_URL_LOGIN);
	}else {
		chain.doFilter(request, response);
	}
	
}

@Override
public void destroy() {
	// TODO Auto-generated method stub
	
}
}
