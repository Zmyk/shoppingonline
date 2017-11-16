<%@page import="com.shoppingonline.entity.GoodsType"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>添加商品</title>
</head>
<a style="margin-left: 100px" href="adloginServlet">返回主页</a>
<a style="margin-left: 900px" href="adUnLoginservlet">注销</a>
<body>
	<center>
		<div style="margin-top: 100px">
			<form action="adaddGoodsServlet" method="post">
				<table border="1">
					<caption>添加商品</caption>
					<tr>
						<td>商品名称：</td>
						<td><input type="text" name="goodsname" /></td>
					</tr>
					<tr>
						<td>商品价格：</td>
						<td><input type="text" name="price" /></td>
					</tr>
					<tr>
						<td>商品数量：</td>
						<td><input type="text" name="goodsnum" /></td>
					</tr>
					<tr>
						<td>商品类型：</td>
						<td><select id="type" name="type">
								<%
									ArrayList<GoodsType> goodsTypeList = (ArrayList<GoodsType>) request.getAttribute("goodsTypeList");
									for (int i = 0; i < goodsTypeList.size(); i++) {
								%>
								<option value="<%=goodsTypeList.get(i).getType()%>"
									name="<%=goodsTypeList.get(i).getType()%>"><%=goodsTypeList.get(i).getType()%></option>
								<%
									}
								%>
						</select></td>
					</tr>
					<tr>
						<td><input type="submit" value="提交" /></td>
					</tr>
				</table>
			</form>
		</div>
	</center>
</body>
</html>