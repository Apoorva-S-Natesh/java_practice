<%@ page import="java.time.LocalTime" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% LocalTime time = LocalTime.now(); %>
	<h5>Current Time: <%= time %></h5>
	<h3> Welcome ${username} </h3>
</body>
</html>