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
		//����ǰ������
		String name=req.getParameter("uName");//""
		String pwd=req.getParameter("uPwd");
//		//jdbc
//		String dbName="zhangsan";
//		String dbPwd="admin";
//		if(name.equals(dbName)&&pwd.equals(dbPwd)){
//			System.out.println("��¼�ɹ�");
//			resp.sendRedirect("main.html");//�ض���ĳһ����Դ
//		}else{
//			System.out.println("�û���/�������");
//			resp.sendRedirect("www.baidu.com");//�ض���ĳһ����Դ
//		}
		//1:�������ݿ�
				//�������
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/tb40";
			 conn= DriverManager.getConnection(url,"root","admin");
		//sql���Ĳ���
			String sql="select user_id,user_name,user_pwd,user_type from users where user_name='zhangsan'";
			//��ȡ
			Statement stmt=conn.createStatement();
			//ִ��sql
			ResultSet rs=stmt.executeQuery(sql);
			//����
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
			System.out.println("�Ҳ�������|sql���쳣");
		}finally {
			//�ر����ݿ�
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//��¼�Ϳ���
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
