<%@page import="com.shoppingonline.entity.UserTable"%>
<%@page import="com.shoppingonline.entity.GoodsInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>fy商城</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<center>
		<%
			String loginUser;
			if (((UserTable) request.getSession().getAttribute("loginUser")) != null) {
				loginUser = ((UserTable) request.getSession().getAttribute("loginUser")).getUserName();
			} else
				loginUser = "未登录";
		%>
		<div>
		    <div style="text-align: left;">
			当前登录用户：<%=loginUser%><br>
			</div>
			<div style="float:right;display:inline">
				<%
					if (loginUser.equals("未登录")) {
				%>
				<a  href="login.jsp">去登录</a>
				<%
					}
				%>
				
				<%
				{
				%>
					<a  href="UnLoginservlet">注销</a>
				<%
				    }
				%>
			</div>
			<div style="display:inline-table;">
			<table border="1">
				<caption>商品列表</caption>
				<tr>
					<td>商品名称</td>
					<td>商品类型</td>
					<td>商品数量</td>
					<td>价格</td>
					<td>操作</td>
				</tr>
				<%
					ArrayList<GoodsInfo> goodsInfoList = (ArrayList<GoodsInfo>) request.getAttribute("goodsInfoList");
					for (int i = 0; i < goodsInfoList.size(); i++) {
				%>
				<tr>
					<td><%=goodsInfoList.get(i).getGood().getGoodsName()%></td>
					<td><%=goodsInfoList.get(i).getGoodTypeName()%></td>
					<td><%=goodsInfoList.get(i).getGood().getGoodsNum()%></td>
					<td><%=goodsInfoList.get(i).getGood().getPrice()%></td>
					<td><a href="addToShoppingCarServlet?goodsid=<%=goodsInfoList.get(i).getGood().getGoodsID()%>">添加到购物车</a></td>
				</tr>

				<%
					}
				%>
			</table>
			<table border="1">
				<caption>特价商品信息</caption>
				<tr>
					<td>商品名称</td>
					<td>商品类型</td>
					<td>商品数量</td>
					<td>原价</td>
					<td>特价</td>
					<td>操作</td>
				</tr>
				<%
					ArrayList<GoodsInfo> special_offerGoodsInfoList = (ArrayList<GoodsInfo>) request
							.getAttribute("special_offerGoodsInfoList");
					for (int i = 0; i < special_offerGoodsInfoList.size(); i++) {
				%>
				<tr>
					<td><%=special_offerGoodsInfoList.get(i).getGood().getGoodsName()%></td>
					<td><%=special_offerGoodsInfoList.get(i).getGoodTypeName()%></td>
					<td><%=special_offerGoodsInfoList.get(i).getGood().getGoodsNum()%></td>
					<td><%=special_offerGoodsInfoList.get(i).getGood().getPrice()%></td>
					<td><%=special_offerGoodsInfoList.get(i).getGood().getSpecial_price()%></td>
					<td><a
						href="addToShoppingCarServlet?goodsid=<%=special_offerGoodsInfoList.get(i).getGood().getGoodsID()%>">添加到购物车</a></td>
				</tr>

				<%
					}
				%>
			</table>
			</div>
			<div>
				<a style="margin-top: 200px; margin-left: 650px" href="toMyShoppingCarServlet">去我的购物车</a>
			</div>
		</div>
	</center>
</body>
</html>
