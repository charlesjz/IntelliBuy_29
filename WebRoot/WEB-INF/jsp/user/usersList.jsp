<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users List</title>
</head>
<body> 
<form action="${pageContext.request.contextPath }/user/queryAllUser.action" method="post">
Query:
<table width="100%" border=1>
<tr>
<td><input type="submit" value="Query"/></td>
</tr>
</table>
Users:
<table width="100%" border=1 style=".input{border:none}">
<tr>
	<td>UserId</td>
	<td>Username</td>
	<td>Birthday</td>
	<td>Sex</td>
	<td>Address</td>
</tr>
<c:forEach items="${usersList }" var="user">
<tr>
	<td>${user.id}</td>
	<td>${user.username}</td>
	<td><input style="border:none" value="${user.birthday}"></td>
	<td><input style="border:none" value="${user.sex}"></td>
	<td><input style="border:none" value="${user.address}"></td>
	<td><a href="${pageContext.request.contextPath }/user/editUser.action?id=${user.id}">ModifyUser</a></td>

</tr>
</c:forEach>
<tr>
    <td></td>
    <td><input type="text" name="username"></td>
    <td><input type="text" name="birthday"></td>
    <td><input type="text" name="sex"></td>
    <td><input type="text" name="address"></td>
    <td><a href="${pageContext.request.contextPath }/user/addUser.action">AddUser</a></td>
</tr>
</table>
</form>
</body>

</html>