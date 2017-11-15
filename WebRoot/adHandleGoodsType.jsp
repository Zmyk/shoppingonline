<%@page import="java.util.ArrayList"%>
<%@page import="com.shopping.entity.GoodsType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类型管理</title>
</head>
<a style="margin-left: 100px" href="adloginServlet">返回主页</a>
<a style="margin-left: 900px" href="adUnLoginservlet">注销</a>
<body>
<center>
<div>
<table border="1">
<caption>当前已有商品类型</caption>
<tr><td>类型ID</td><td>类型名称</td><td>操作</td></tr>
<%
	ArrayList<GoodsType> goodsTypeList = (ArrayList<GoodsType>)request.getAttribute("goodsTypeList");
	for(int i =0;i<goodsTypeList.size();i++){
%>
<tr><td><%=goodsTypeList.get(i).getTypeID() %></td><td><%=goodsTypeList.get(i).getType() %></td><td><a href="adDeleteGoodsTypeServlet?typeid=<%=goodsTypeList.get(i).getTypeID() %>">删除</a></td></tr>
<%
	}
%>
</table>
</div>
<div style="margin-top: 70px">
<h1>新增商品类型</h1>
<form action="adAddNewGoodsTypeServlet" method="post">
请输入类型名称：<input type="text" name="typeName"><input type="submit" value="添加" >
</form>
</div>
</center>

</body>
</html>