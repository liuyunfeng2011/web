package com.gezhi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
			//�û��޸�
			out.println("update user++++");
		}else if("delete".equals(path)){
			//ɾ���û�
			out.println("delete user++++");
		}else if("getPhone".equals(path)){
			//��ȡ�û��绰
			out.println("getPhone user++++");
		}else if("findAllUser".equals(path)){
			try {
				List<User> users=dao.findAllUser();
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
				//����ȱʧ
			}
			int userId=Integer.parseInt(uId);
			try {
				dao.delUser(userId);
				//ִ�����
				out.print("1");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//ִ���쳣
				out.print("-100");
			}
		}
		
	}
	
}
