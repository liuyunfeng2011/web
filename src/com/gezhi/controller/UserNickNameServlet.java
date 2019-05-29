package com.gezhi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gezhi.pojo.User;

public class UserNickNameServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession();
		
		try{
//			User user=(User) session.getAttribute("user");
//			List<String> list=new ArrayList<>();
//			list.add(user.getUserInfo().getNickName());
//			list.add("13344445555");
//	//		out.print(list);
//			out.print(user.getUserInfo().getNickName());
			User user = new User(1, "xiaohei", 1);
			User user2 = new User(2, "zhangsan2", 1);
			User user3 = new User(3, "zhangsan3", 1);
			List<User> list = new ArrayList<>();
			list.add(user);
			list.add(user2);
			list.add(user3);
			ObjectMapper mapper = new ObjectMapper();
			String jsonlist = mapper.writeValueAsString(list);
			System.out.println(jsonlist);//json∏Ò Ω
			out.print(jsonlist);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
