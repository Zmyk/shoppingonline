<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
    <title>���û�ע��</title>
</head>
<body><center>
    <form action="registerServlet" method="POST">
       <table>
	   <caption>���û�ע��</caption>
		<tr><td>�û�����</td><td><input type="text" name="username"/></td></tr>
		<tr><td>���룺</td><td><input  type="password" name="password"/></td></tr>
		<tr><td>�绰��</td><td><input type="text" name="tel"></td></tr>
		<tr><td><input type="submit" value="ע��"/></td><td><a href="login.jsp">���ص�¼</a></td></tr>
	  </table>
    </form>
    
</body>
</html>