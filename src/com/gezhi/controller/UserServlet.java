package com.gezhi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		String url=req.getRequestURI();
		System.out.println(url);//   /myweb01/users/?
		String path=url.substring(url.lastIndexOf("/")+1, url.length());
		System.out.println(path);
		if("update".equals(path)){
			//用户修改
			out.println("update user++++");
		}else if("delete".equals(path)){
			//删除用户
			out.println("delete user++++");
		}else if("getPhone".equals(path)){
			//获取用户电话
			out.println("getPhone user++++");
		}else if("findAllUser".equals(path)){
			// 只负责与前端打交道
		}
		
	}
	
}
