<%@page import="com.gezhi.pojo.User"%>
<%@page import="java.util.List"%>
<%@page import="com.gezhi.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
<table id="userInfo">
		<tr>
			<td><span>ȫѡ</span><input type="checkbox"  id="checkAll" /> </td>
			<td>id</td>
			<td>����</td>
			<td>�ǳ�</td>
			<td>�绰����</td>
			<td>email</td>
			<td>�Ա�</td>
			<td>��ַ</td>
			<td>����</td>
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
					out.print("��");
				}else if(user.getUserInfo().getGender()==0){
					out.print("Ů");
				}
			%></td>
			<td><%=user.getUserInfo().getAddress() %></td>
			<td><button>ɾ��</button></td>
		</tr>
		<%		
			}
		%>
	</table>
	<button>1</button><button>2</button>
</body>
</html>