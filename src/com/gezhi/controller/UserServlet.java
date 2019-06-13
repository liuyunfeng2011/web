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
			//用户修改
			out.println("update user++++");
		}else if("delete".equals(path)){
			//删除用户
			out.println("delete user++++");
		}else if("autoLogin".equals(path)){
//			//判断自动登录
//			 Cookie cookies[]= req.getCookies();
//			 for(Cookie cookie:cookies){
//					System.out.println(cookie.getName());
//					System.out.println(cookie.getValue());
//					if(cookie.getName().equals("uName")){
//						String name=cookie.getValue();
//						//1用户登录过 2用户选择了记住 我
//						//让用户登录 并且跳转到主页
//						//保存用户状态
//						HttpSession session=req.getSession();
//						//session.setMaxInactiveInterval(2*60*60);
//						//用户名 通过用户名查询用户
//						try {
//							User user= dao.getUserByUserName(name);
//							if(user!=null){
//								if(user.getUserType()!=0){
//									session.setAttribute("user", user);
//									out.print("1");
//								}else{
//									//禁用
//									out.print("2");
//								}
//								
//							}else{
//								//账号异常 重新登录
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
			
			//批量删除用户
				//1:接受参数
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
			//获取用户电话
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
				//参数缺失
			}
			int userId=Integer.parseInt(uId);
			try {
				dao.delUser(userId);
				//执行完成
				out.print("1");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//执行异常
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
			//浏览器地址栏 默认编码 iso-8859-1   gbk
			String uName=new String(name.getBytes("iso-8859-1"),"gbk");
			System.out.println(uName);
		}
		else if("test".equals(path)){
			//重定向   当前地址url重定向到一个新的地方
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
			// 工厂类实例 提供解析
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 解析器
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			fileUpload.setHeaderEncoding("utf-8");
			try {
				List<FileItem> items = fileUpload.parseRequest(req);
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
							ServletContext sctx = getServletContext();
							String path2 = sctx.getRealPath("/upload");  //
							System.out.println(path2);
							// 获得文件名
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








