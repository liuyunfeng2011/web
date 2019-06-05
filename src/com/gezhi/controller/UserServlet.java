package com.gezhi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gezhi.dao.UserDao;
import com.gezhi.pojo.User;

public class UserServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper=new ObjectMapper();
		UserDao dao=new UserDao();
		PrintWriter out=resp.getWriter();
		String url=req.getRequestURI();
		String path=url.substring(url.lastIndexOf("/")+1, url.length());
		if("update".equals(path)){
			//用户修改
			out.println("update user++++");
		}else if("delete".equals(path)){
			//删除用户
			out.println("delete user++++");
		}else if("getPhone".equals(path)){
			//获取用户电话
			out.println("getPhone user++++");
		}else if("getPageCount".equals(path)){
			int pageCount=0;
			try {
				pageCount=dao.getPageCount();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print("-100");
			}
			out.print(pageCount);
		}else if("findUserByPage".equals(path)){
			try {
				int pageNow=Integer.parseInt(req.getParameter("pageNow"));
				List<User> users=dao.findUserByPage(pageNow);
//				int pageCount=3;
//				Map<String, Object> map=new HashMap<>();
//				map.put("pageCount", pageCount);
//				map.put("users", users);
				String userList= mapper.writeValueAsString(users);
				out.print(userList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print("-100");
			}
		}else if("delUser".equals(path)){
			String uId=req.getParameter("userId");
			if(uId==null||uId.length()==0){
				//参数缺失
			}
			int userId=Integer.parseInt(uId);
			try {
				dao.delUser(userId);
				//执行完成
				out.print("1");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//执行异常
				out.print("-100");
			}
		}
		
	}
	
}
