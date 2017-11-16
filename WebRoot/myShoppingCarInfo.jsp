<%@page import="com.shoppingonline.entity.MyShoppingCarInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的购物车</title>
</head>
<div>
	<a style="margin-left: 200px;margin-top: 200px" href="loginServlet">返回商品列表</a>
	<a style="margin-left: 600px;margin-top: 200px" href="UnLoginservlet">注销</a>
</div>
<body>
  <center>
	<table border="1">
		<caption>我的购物车</caption>
		<tr><td>共需支付：<%=Integer.valueOf(request.getAttribute("sumpay").toString()) %></td><td><a href="deleteAllShoppingCarServlet">清空购物车</a></td></tr>
		<tr><td>商品名</td><td>商品类型</td><td>数量</td><td>总价格</td><td>操作</td></tr>
	<%
		ArrayList<MyShoppingCarInfo> myShoppingCarInfoList = (ArrayList<MyShoppingCarInfo>) request.getAttribute("myShoppingCarInfoList");
	%>	
	
	<% 
		for(int i=0;i<myShoppingCarInfoList.size();i++){
	%>
		<tr><td><%=myShoppingCarInfoList.get(i).getGoods_goodsName() %></td><td><%=myShoppingCarInfoList.get(i).getGoodstype_type() %></td><td><%=myShoppingCarInfoList.get(i).getSc().getGoodsNum() %></td><td><%=myShoppingCarInfoList.get(i).getSc().getSumPrice() %></td><td><a href="deleteShoppingCarServlet?goodsid=<%=myShoppingCarInfoList.get(i).getSc().getGoodsID()%>">删除</a></td></tr>
	<%
		}
	%>
	    
	</table>
  </center>
</body>

</html>