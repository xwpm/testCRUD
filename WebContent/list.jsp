<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<table>
		<tr>
			<td>ID</td>
			<td>用户名</td>
			<td>密码</td>
		</tr>
		<c:forEach items="${list}" var="user">
			<tr>
				<td >${user.u_id}</td>
				<td >${user.u_name}</td>
				<td >${user.u_password}</td>
				<td ><a href="updateUser?u_id=${user.u_id}"> 修改</a></td>
				<td ><a href="deleteUser?u_id=${user.u_id}" >删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="insert.jsp">新增</a>
</body>
</html>