<%@page import="com.shoppingonline.entity.GoodsInfo"%>
<%@page import="com.shoppingonline.entity.Goods"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function getRank() {
		var rank = document.getElementById("rank").options[index].value;
	}
</script>
<a href="adUnLoginservlet" style="margin-left: 1100px;">注销</a>
<br>
<body>
	<div>
		<center>
			<table border="1">
				<caption>商品列表</caption>
				<tr>
					<td>商品名称</td>
					<td>商品类型</td>
					<td>商品数量</td>
					<td>价格</td>
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
					<td><a
						href=" adaddToSpecial_offerGoodsServlet?goodsid=<%=goodsInfoList.get(i).getGood().getGoodsID()%>&rank=0.5">添加到特价商品</a></td>
					<td><a
						href="addeleteServlet?goodsid=<%=goodsInfoList.get(i).getGood().getGoodsID()%>">删除</a></td>
				</tr>

				<%
					}
				%>

			</table>

			<table border="1">
				<caption>特价商品列表</caption>
				<tr>
					<td>商品名称</td>
					<td>商品类型</td>
					<td>商品数量</td>
					<td>原价</td>
					<td>特价</td>
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
						href="adRemoveSpecial_offerGoodsServlet?goodsid=<%=special_offerGoodsInfoList.get(i).getGood().getGoodsID()%>">移除特价商品</a></td>
				</tr>

				<%
					}
				%>
			</table>
		</center>
	</div>
</body>
<div>
<a style="margin-left: 900px; margin-top: 9000px" href="adGetGoodsTypeServlet">添加商品</a>
<a style="margin-left: 900px;margin-top: 50px" href="toHandleGoodsTypeServlet">商品类型管理</a>
</div>
</html>