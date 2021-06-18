<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改商品信息</title>
</head>
<body>
	<h1>修改商品信息</h1>
	
	<form action="DoUpdateProductServlet" method="get" name="proInfo">
		商品编号：<input type="text" name="pno" value="${pro.pno }" readonly /><br/><br/>
		商品名称：<input type="text" name="pname" value="${pro.pname } "/><br/><br/>
		商品价格：<input type="text" name="price" value="${pro.price }" /><br/><br/>
		商品分类：<select name="category">
				<option value="家电" <c:if test="${pro.category=='家电' }">selected</c:if> >家电</option>
				<option value="服装" <c:if test="${pro.category=='服装' }">selected</c:if> >服装</option>
				<option value="食品" <c:if test="${pro.category=='食品' }">selected</c:if> >食品</option>
				<option value="护肤" <c:if test="${pro.category=='护肤' }">selected</c:if> >护肤</option>
			 </select><br/><br/>
		库存量：<input type="text" name="num" value="${pro.num }" /><br/><br/>
		
		<input type="submit" value="修改"/>
	</form>
</body>
</html>