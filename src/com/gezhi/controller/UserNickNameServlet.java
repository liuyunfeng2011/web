package com.gezhi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gezhi.pojo.User;

public class UserNickNameServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append("select u.user_name,u.user_type,info.info_nickname as nickName,info.info_phone from users  u ");
		sb.append(" left join user_info info ");
		sb.append(" on u.user_id=info.user_id ");
		sb.append(" where u.user_id=? ");
		String url = "jdbc:mysql://127.0.0.1:3306/tb40";
		Connection conn = null;
		try {
			String nickName = "";
			HttpSession session = req.getSession();
			User u = (User) session.getAttribute("user");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "admin");
			PreparedStatement ptmt = conn.prepareStatement(sb.toString());
			ptmt.setInt(1, u.getUserId());
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				nickName = rs.getString("nickName");
			}
			out.print(nickName);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
