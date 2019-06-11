package com.gezhi.filter;

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

import com.gezhi.pojo.User;

public class HelloFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest) arg0;
		HttpServletResponse resp=(HttpServletResponse) arg1;
		//url白名单
			//login.html  user/login
//		HttpSession session=req.getSession();
//		User user= (User) session.getAttribute("user");
//		if(user==null){
//			System.out.println("没有登录");
//			chain.doFilter(req, resp);
//			resp.sendRedirect("login.html");
//			
//		}
		
		resp.sendRedirect(req.getContextPath()+"/login.html");
		chain.doFilter(req, resp);
		//过滤器过滤了几次？
			//过滤器链
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

}
