<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String str="你好"; 
	System.out.println(str);	
	%>
	<%test(); %>
	this is a new stage
	<%!public void test(){
		System.out.println("这是全局变量");
	} %>
	
	<%@include file="include.jsp" %>
	<jsp:include page="dongtai.jsp"></jsp:include>
	
	
	<jsp:forward page="forward.jsp">
	<jsp:param name="str" value="aaa" />
	</jsp:forward>
	
	
	
	
</body>
</html>