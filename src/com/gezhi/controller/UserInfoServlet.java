package com.gezhi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gezhi.pojo.User;

public class UserInfoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		Integer id = 0;
		if (user == null) {
			out.print("4");
		} else {
			id = user.getUserId();
			Connection conn = null;

			String sql = "insert into user_info(info_nickname,info_phone,info_email,info_gender,info_address,user_id) values(?,?,?,?,?,?)";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://127.0.0.1:3306/tb40";
				conn = DriverManager.getConnection(url, "root", "admin");
				PreparedStatement ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, req.getParameter("name"));
				ptmt.setString(2, req.getParameter("phone"));
				ptmt.setString(3, req.getParameter("email"));
				ptmt.setString(4, req.getParameter("gender"));
				ptmt.setString(5, req.getParameter("address"));
				ptmt.setInt(6, id);
				ptmt.executeUpdate();
				out.print("1");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print("0");
			}

		}

	}

}
