<%@page import="com.gezhi.pojo.User"%>
<%@page import="java.util.List"%>
<%@page import="com.gezhi.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
</head>
<body>
<table id="userInfo">
		<tr>
			<td><span>全选</span><input type="checkbox"  id="checkAll" /> </td>
			<td>id</td>
			<td>姓名</td>
			<td>昵称</td>
			<td>电话号码</td>
			<td>email</td>
			<td>性别</td>
			<td>地址</td>
			<td>操作</td>
		</tr>
		<%
			List<User> users=(List<User>) request.getAttribute("users");
			for(User user:users){
				%>
				<tr>
			<td><input type="checkbox" /> </td>
			<td><%=user.getUserId() %></td>
			<td><%=user.getUserName() %></td>
			<td><%=user.getUserInfo().getNickName() %></td>
			<td><%=user.getUserInfo().getPhone() %></td>
			<td><%=user.getUserInfo().getEmail() %></td>
			<td><%
				if(user.getUserInfo().getGender()==1){
					out.print("男");
				}else if(user.getUserInfo().getGender()==0){
					out.print("女");
				}
			%></td>
			<td><%=user.getUserInfo().getAddress() %></td>
			<td><a href="deleteUserById?id=<%=user.getUserId() %>">删除</a></td>
		</tr>
		<%		
			}
		%>
	</table>
	<%int size=5;
	for(int i=0;i<size;i++){
		%>
		<a href="findUserByPage2?pageNow=<%=i+1 %>"><%=i+1 %></a>
		<%
	}
	%>
	
</body>
</html>