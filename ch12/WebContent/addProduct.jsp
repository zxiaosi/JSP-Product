<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加商品</title>
</head>
<body>
	<h1>添加商品</h1>
	
	<form action="AddProductServlet" method="get" name="productInfo">
		<input name="type" type="hidden" value="add"/>
		商品编号：<input type="text" name="pno"/><br/><br/>
		商品名称：<input type="text" name="pname"/><br/><br/>
		商品价格：<input type="text" name="price"/><br/><br/>
		商品分类：<select name="category">
				<option value="家电">家电</option>
				<option value="服装">服装</option>
				<option value="食品">食品</option>
				<option value="护肤">护肤</option>
			 </select><br/><br/>
		库存量：<input type="text" name="num"/><br/><br/>
		<input type="submit" value="添加"/>
	</form>
	
</body>
</html>