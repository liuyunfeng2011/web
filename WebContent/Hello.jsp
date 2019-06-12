<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	#div1{
		width:200px;
		height:200px;
		background-color: red;
	}
</style>
</head>
<body>
<%! int i=10;
	public int getNum(int num1,int num2){
		return num1+num2;
	}
%>
<%=getNum(1,9) %>
<!-- fdskdsa -->
<div id="div1"></div>
		<button>click me</button> 
<script type="text/javascript" src="js/jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$("button").click(function(){
		alert("hello")
	})
</script>
</body>
</html>