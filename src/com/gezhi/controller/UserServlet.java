package com.gezhi.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.omg.IOP.ServiceContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gezhi.dao.UserDao;
import com.gezhi.pojo.User;

public class UserServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		req.setCharacterEncoding("gbk");
		ObjectMapper mapper=new ObjectMapper();
		UserDao dao=new UserDao();
		PrintWriter out=resp.getWriter();
		String url=req.getRequestURI();
		String path=url.substring(url.lastIndexOf("/")+1, url.length());
		if("update".equals(path)){
			//�û��޸�
			out.println("update user++++");
		}else if("delete".equals(path)){
			//ɾ���û�
			out.println("delete user++++");
		}else if("autoLogin".equals(path)){
//			//�ж��Զ���¼
//			 Cookie cookies[]= req.getCookies();
//			 for(Cookie cookie:cookies){
//					System.out.println(cookie.getName());
//					System.out.println(cookie.getValue());
//					if(cookie.getName().equals("uName")){
//						String name=cookie.getValue();
//						//1�û���¼�� 2�û�ѡ���˼�ס ��
//						//���û���¼ ������ת����ҳ
//						//�����û�״̬
//						HttpSession session=req.getSession();
//						//session.setMaxInactiveInterval(2*60*60);
//						//�û��� ͨ���û�����ѯ�û�
//						try {
//							User user= dao.getUserByUserName(name);
//							if(user!=null){
//								if(user.getUserType()!=0){
//									session.setAttribute("user", user);
//									out.print("1");
//								}else{
//									//����
//									out.print("2");
//								}
//								
//							}else{
//								//�˺��쳣 ���µ�¼
//								out.print("3");
//							}
//							
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//							out.print("-1");
//						}
//						
//					}
//				}
		}
		
		else if("delUsers".equals(path)){
			
			//����ɾ���û�
				//1:���ܲ���
			String[] ids=req.getParameterValues("usersId");
			try {
				dao.delUsersById(ids);
				out.print("1");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print("-100");
			}
		}
		else if("getPhone".equals(path)){
			//��ȡ�û��绰
			out.println("getPhone user++++");
		}else if("getPageCount".equals(path)){
			int pageCount=0;
			try {
				pageCount=dao.getPageCount();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print("-100");
			}
			out.print(pageCount);
		}else if("findUserByPage".equals(path)){
			try {
				int pageNow=Integer.parseInt(req.getParameter("pageNow"));
				List<User> users=dao.findUserByPage(pageNow);
//				int pageCount=3;
//				Map<String, Object> map=new HashMap<>();
//				map.put("pageCount", pageCount);
//				map.put("users", users);
				String userList= mapper.writeValueAsString(users);
				out.print(userList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print("-100");
			}
		}else if("delUser".equals(path)){
			String uId=req.getParameter("userId");
			if(uId==null||uId.length()==0){
				//����ȱʧ
			}
			int userId=Integer.parseInt(uId);
			try {
				dao.delUser(userId);
				//ִ�����
				out.print("1");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//ִ���쳣
				out.print("-100");
			}
		}else if("shopCar".equals(path)){
			Cookie cookie=new Cookie("bookId", "1&2&3&4&5");
			cookie.setMaxAge(7*24*60*60);
			resp.addCookie(cookie);
		}
		else if("getCookie".equals(path)){
			Cookie[] cookies= req.getCookies();
			System.out.println(cookies.length);
			
		}
		else if("login2".equals(path)){
			//ajax servlet 
			String name=req.getParameter("uName");
			//�������ַ�� Ĭ�ϱ��� iso-8859-1   gbk
			String uName=new String(name.getBytes("iso-8859-1"),"gbk");
			System.out.println(uName);
		}
		else if("test".equals(path)){
			//�ض���   ��ǰ��ַurl�ض���һ���µĵط�
			req.getRequestDispatcher("findUserByPage").forward(req, resp);
		}
		else if("findUserByPage2".equals(path)){
			try {
				int pageNow=Integer.parseInt(req.getParameter("pageNow"));
				List<User> users=dao.findUserByPage(pageNow);
				req.setAttribute("users", users);
				req.getRequestDispatcher("../userInfo.jsp").forward(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if("upload".equals(path)){
			// ������ʵ�� �ṩ����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// ������
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			fileUpload.setHeaderEncoding("utf-8");
			try {
				List<FileItem> items = fileUpload.parseRequest(req);
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
							ServletContext sctx = getServletContext();
							String path2 = sctx.getRealPath("/upload");  //
							System.out.println(path2);
							// ����ļ���
							String fileName = item.getName();
							File file = new File(path2 + "\\" + fileName);
							item.write(file);
				}
			} catch ( Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}








