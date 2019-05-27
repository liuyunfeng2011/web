package com.gezhi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接受前端请求
		String name=req.getParameter("uName");//""
		String pwd=req.getParameter("uPwd");
//		//jdbc
//		String dbName="zhangsan";
//		String dbPwd="admin";
//		if(name.equals(dbName)&&pwd.equals(dbPwd)){
//			System.out.println("登录成功");
//			resp.sendRedirect("main.html");//重定向到某一个资源
//		}else{
//			System.out.println("用户名/密码错误");
//			resp.sendRedirect("www.baidu.com");//重定向到某一个资源
//		}
		//1:连接数据库
				//获得驱动
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/tb40";
			 conn= DriverManager.getConnection(url,"root","admin");
		//sql语句的操作
			String sql="select user_id,user_name,user_pwd,user_type from users where user_name='zhangsan'";
			//获取
			Statement stmt=conn.createStatement();
			//执行sql
			ResultSet rs=stmt.executeQuery(sql);
			//操作
			while(rs.next()){
				int uId=rs.getInt("user_id");
				String uName=rs.getString("user_name");
				String uPwd=rs.getString("user_pwd");
				String uType=rs.getString("user_type");
				System.out.println(uId+" "+uName+" "+uPwd+" "+uType);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("找不到驱动|sql有异常");
		}finally {
			//关闭数据库
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//记录就可以
				}
			}
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("xiaohui le");//
	}

	
}
