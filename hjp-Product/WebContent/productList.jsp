<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品列表</title>
</head>
<body>
<form action="SelectProductServlet">
	商品名称：<input type="text" name="pname" value="${p.pname }">
	商品分类：<select name="category">
				<option value="" >全部</option>
				<option value="家电" <c:if test="${p.category=='家电'}">selected</c:if>>家电</option>
				<option value="服装" <c:if test="${p.category=='服装'}">selected</c:if>>服装</option>
				<option value="食品" <c:if test="${p.category=='食品'}">selected</c:if>>食品</option>
				<option value="护肤" <c:if test="${p.category=='护肤'}">selected</c:if>>护肤</option>
			 </select>
	<input type="submit" value="查询" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="addProduct.jsp">添加商品</a>
</form><br>
<table border="1">
	<caption>已添加商品列表</caption>
	<tr align="center" height="50px;" bgcolor="blue">
		<th width="100px;">商品编号</th>
		<th width="100px;">商品名称</th>
		<th width="100px;">商品价格</th>
		<th width="100px;">商品分类</th>
		<th width="100px;">库存量</th>
		<th width="100px;">操作</th>
	</tr>
	<c:if test="${list!=null }">
		<c:forEach items="${list}" var="p">
			<tr align="center">
				<td>${p.pno}</td>
				<td><a href="updateProductServlet?type=view&pno=${p.pno }">${p.pname}</a></td>
				<td>${p.price}</td>
				<td>${p.category}</td>
				<td>${p.num}</td>
				<td><a href="updateProductServlet?pno=${p.pno}">修改</a>&nbsp;<a href="deleteProductServlet?pno=${p.pno}">删除</a></td>
			</tr>
		</c:forEach>
	</c:if>
		
</table><br/>
</body>
</html>