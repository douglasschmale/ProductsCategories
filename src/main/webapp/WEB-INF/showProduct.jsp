<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
	<h1>${product.name}</h1>
	
	<h2>Related Categories:</h2>
	
	<ul>
		<c:forEach items = "${product.categories}" var="cat">
			<li><a href="/category/${cat.id}" style="color:black; text-decoration: none">${cat.name }</a>
		</c:forEach>
	</ul>
	
	<form method="POST" action="/product/${product.id}/join">
		<select name="category_id">
			<c:forEach items="${categories}" var = "cat">
				<option value="${cat.id}">${cat.name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add">
	</form> <br>
	<a href="/product/new" style="color:black; text-decoration: none"><h3>Add a new Product</h3></a>
	<h3>Other Products:</h3>
	
	<c:forEach items = "${products}" var="pro">
		<a href="/product/${pro.id}">${pro.name }</a><br>
	</c:forEach>

</body>
</html>