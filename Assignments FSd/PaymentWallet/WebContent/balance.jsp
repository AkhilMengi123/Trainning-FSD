<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="bootstrap/bootstrap.html" %>
</head>
<body>
<%@ include file="nav.html" %>
<br><br>
<h3>Your Balance is : <% int balance=(int)session.getAttribute("balance");
out.println(balance); %></h3>
</body>
</html>