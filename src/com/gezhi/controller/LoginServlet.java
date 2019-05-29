package com.gezhi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gezhi.pojo.User;
import com.gezhi.pojo.UserInfo;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		// 接受前端请求
		String name = req.getParameter("uName");// ""
		String pwd = req.getParameter("uPwd");
		// 1:连接数据库
		// 获得驱动
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/tb40";
			conn = DriverManager.getConnection(url, "root", "admin");
			StringBuilder sb=new StringBuilder();
			sb.append("select u.user_id,u.user_name,u.user_type,info.info_nickname ");
			sb.append(" from users u  ");
			sb.append(" left join user_info info ");
			sb.append(" on u.user_id=info.user_id ");
			sb.append(" where u.user_name=? and u.user_pwd=? " );
			PreparedStatement ptmt = conn.prepareStatement(sb.toString());
			ptmt.setString(1, name);
			ptmt.setString(2, pwd);
			ResultSet rs= ptmt.executeQuery();
			User user=null;
			while(rs.next()){
				int userId=rs.getInt("user_id");
				String userName=rs.getString("user_name");
				int userType=rs.getInt("user_type");
				user=new User(userId,userName,userType);
				UserInfo info=new UserInfo();
				info.setNickName(rs.getString("info_nickname"));
				user.setUserInfo(info);
			}
			if(user!=null){
				if(user.getUserType()==0){
					//禁止登录
					out.print("0");
				}else{
					//登录成功
					out.print("1");
					//保存用户状态
					HttpSession session=req.getSession();
					//session.setMaxInactiveInterval(2*60*60);
					session.setAttribute("user", user);
				}
			}else{
				//帐户名/密码错误
				out.print("3");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("找不到驱动|sql有异常");
		} finally {
			// 关闭数据库
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					// 记录就可以
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
