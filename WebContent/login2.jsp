<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.gezhi.pojo.Student"%>
<%@page import="com.gezhi.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Student> stus = new ArrayList<Student>();
		Student s = new Student();
		s.setName("zhangsan");
		s.setAge(18);
		s.setGender(1);
		Student s2 = new Student();
		s2.setName("lisi");
		s2.setAge(18);
		s2.setGender(0);
		Student s3 = new Student();
		s3.setName("wangwu");
		s3.setAge(19);
		s3.setGender(0);
		stus.add(s);
		stus.add(s2);
		stus.add(s3);
		pageContext.setAttribute("stus", stus);
	%>
	<table>
		<tr>
			<td>����</td>
			<td>����</td>
			<td>�Ա�</td>
			<td>����</td>
		</tr>

		<c:forEach items="${stus}" var="stu">
			<tr>
				<td>${stu.name}</td>
				<td>${stu.age}</td>
				<td><c:choose>
						<c:when test="${stu.gender==1}">��</c:when>
						<c:otherwise>Ů</c:otherwise>
					</c:choose></td>
			<td>  <a href="users/delUser?name=${stu.name}">ɾ��</a> </td>
			</tr>
		</c:forEach>
	</table>
	
		<c:set var="test" scope="session" value="10"></c:set>
		<c:remove var="test"/>
		${test}
		<%session.setAttribute("name","zhangsan"); %>
		<a href="<c:url value='/jsp01.jsp'/>">����jsp01</a>
		
		
</html>