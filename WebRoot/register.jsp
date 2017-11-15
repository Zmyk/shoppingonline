<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
    <title>新用户注册</title>
</head>
<body><center>
    <form action="registerServlet" method="POST">
       <table>
	   <caption>新用户注册</caption>
		<tr><td>用户名：</td><td><input type="text" name="username"/></td></tr>
		<tr><td>密码：</td><td><input  type="password" name="password"/></td></tr>
		<tr><td>电话：</td><td><input type="text" name="tel"></td></tr>
		<tr><td><input type="submit" value="注册"/></td><td><a href="login.jsp">返回登录</a></td></tr>
	  </table>
    </form>
    
</body>
</html>