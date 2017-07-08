<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改数据</title>
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<body>
	<form action="updateUser" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="u_id" readonly="readonly"
					value="${user.u_id }" /></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="u_name" value="${user.u_name}" /></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;码：</td>
				<td><input type="password" name="u_password"
					value="${user.u_password}" /></td>
			</tr>
		</table>
		<input name="op" value="updateUser" type="hidden" /> 
		<input type=submit value="修改" /> 
		<input type=reset value="重置" /> 
		<a href="insert.jsp">新增</a> 
		<a href="index.jsp">返回首页</a>
	</form>
</body>
</body>
</html>