package com.gezhi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ���ݿ���ع�����
 * @author Liuyf
 *
 */
public class DbUtil {
	//1����ȡһ��connection �Ѿ����Ӻ���
	//2���ر�connection
	public static Connection getConnection(){
		Connection conn=null;
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/tb40";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "admin");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//д�ⲿ��־
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void closeConnection(Connection conn){
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
