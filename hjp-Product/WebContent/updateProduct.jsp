<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
</head>
<body>
	<form action="addProductServlet" method="get" name="stuInfo">
		<input name="type" type="hidden" value="update"/>
		商品编号：<input type="text" name="pno" value="${p.pno }" <c:if test="${type=='view' }">readOnly</c:if> /><br/><br/>
		商品名称：<input type="text" name="pname" value="${p.pname }" <c:if test="${type=='view' }">readOnly</c:if> /><br/><br/>
		商品价格：<input type="text" name="price" value="${p.price }" <c:if test="${type=='view' }">readOnly</c:if> /><br/><br/>
		商品分类：<select name="category" <c:if test="${type=='view' }">disabled</c:if> >
				<option value="家电" <c:if test="${p.category=='家电'}">selected</c:if>>家电</option>
				<option value="服装" <c:if test="${p.category=='服装'}">selected</c:if>>服装</option>
				<option value="食品" <c:if test="${p.category=='食品'}">selected</c:if>>食品</option>
				<option value="护肤" <c:if test="${p.category=='护肤'}">selected</c:if>>护肤</option>
			 </select><br/><br/>
		库存量：<input type="text" name="num" value="${p.num }" <c:if test="${type=='view' }">readOnly</c:if> /><br/><br/>
		 <c:if test="${type!='view' }"><input type="submit" value="修改"/></c:if>
		 <c:if test="${type=='view' }"><a href="SelectProductServlet">返回</a></c:if>  
	</form>
</body>
</html>