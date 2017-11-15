<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<script type="text/javascript">
	function reloadcode(){
		var time = new Date().getTime();
		document.getElementById("checkcodeimage").src="<%=request.getContextPath()%>/ImageServlet?d="+ time;
	}
</script>
<body>
	<center>
		<div style="margin-top: 150px">
			<form action="loginServlet" method="POST">
				<table border="1">
					<caption>欢迎访问我们的JavaEE 网站</caption>
					<tr>
						<td>用户名：</td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td>密 码：</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td>验证码：</td>
						<td><input type="text" id="checkcode" name="checkcode" /></td>
					</tr>
					<tr>
						<td><input type="image" id="checkcodeimage" alt="验证码"
							src="<%=request.getContextPath()%>/ImageServlet" /></td>
						<td><a href="javascript:reloadcode()">看不清楚</a></td>
					</tr>
					<tr>
						<td><a href="register.jsp">新用户注册</a></td>
						<td><input type="submit" value="登录" /></td>
					</tr>
				</table>
			</form>
		</div>
	</center>
</body>
</html>
