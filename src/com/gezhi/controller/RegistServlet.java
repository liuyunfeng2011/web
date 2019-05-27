package com.gezhi.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1：参数接受错误  //2:访问路径错误         //sql错误  //返回错误
		String name=req.getParameter("uName");
		String pwd=req.getParameter("uPwd");
		//默认用户是启动状态
		int defaultType=1;
		//1:sql操作
			//1.1获取驱动
		String url = "jdbc:mysql://127.0.0.1:3306/tb40";
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,"root","admin");
			String sql="insert into users(user_name,user_pwd,user_type) values('"+name+"','"+pwd+"',"+defaultType+")";
			Statement stmt=conn.createStatement();
			int result=stmt.executeUpdate(sql);
			System.out.println(result);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	//get 参数在浏览器地址栏显示出来  post 以?拼接在地址拉后边 &
	
}
