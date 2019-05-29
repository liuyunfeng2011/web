package com.gezhi.controller;

import java.io.IOException;
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

public class RegistServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1���������ܴ���  //2:����·������         //sql����  //���ش���
		String name=req.getParameter("uName");
		String pwd=req.getParameter("uPwd");
		//Ĭ���û�������״̬
		int defaultType=1;
		//1:sql����
			//1.1��ȡ����
		String url = "jdbc:mysql://127.0.0.1:3306/tb40";
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,"root","admin");
			String sql="insert into users(user_name,user_pwd,user_type) values('"+name+"','"+pwd+"',"+defaultType+")";
			Statement stmt=conn.createStatement();
			int result=stmt.executeUpdate(sql);
			if(result!=0){
				String sqlForQueryId="select user_id from users where user_name=?";
				PreparedStatement ptmt1 = conn.prepareStatement(sqlForQueryId);
				ptmt1.setString(1, name);
				ResultSet rs= ptmt1.executeQuery();
				int id=0;
				if(rs.next()){
					id=rs.getInt("user_id");
				}
				//users���в����˼�¼
						//ע��ɹ�
				//ͬ������userinfo��Ϣ
				String sql2 = "insert into user_info(info_nickname,info_phone,info_email,info_gender,info_address,user_id) values(?,?,?,?,?,?)";
				PreparedStatement ptmt = conn.prepareStatement(sql2);
				ptmt.setString(1, "gezhi"+name+" "+id);//�������
				ptmt.setString(2,"111111111111");
				ptmt.setString(3, name+"email@email.com");
				ptmt.setString(4, "1");
				ptmt.setString(5, "�й�");
				ptmt.setInt(6, id);
				ptmt.executeUpdate();
			}
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
	//get �������������ַ����ʾ����  post ��?ƴ���ڵ�ַ����� &
	
}
