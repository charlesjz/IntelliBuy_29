<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="intelliBuy.po.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IntelliBuy - Welcome</title>
</head>
<body>
<%
String name = ((User)request.getAttribute( "User" )).getUsername();
%>
<h1>Welcome, <%= name %></h1>
<h1>Welcome(2), ${User.username}</h1>


<div>
    <a href="addUser.jsp">Add user</a>
    <a href="deleteUser.jsp">Delete user</a>
    <a href="updateUser.jsp">Update user</a>
    <a href="listUsers.jsp">List All users</a>
</div>
</body>
</html>