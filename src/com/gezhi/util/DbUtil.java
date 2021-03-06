package com.gezhi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库相关工具类
 * 
 * @author Liuyf
 *
 */
public class DbUtil {
	// 1：获取一个connection 已经连接好了
	// 2：关闭connection
	public static Connection getConnection() throws Exception {
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/tb40?useUnicode=true&characterEncoding=UTF-8";
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(url,"root","admin");
		return conn;
	}

	public static void closeConnection(Connection conn) {
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
