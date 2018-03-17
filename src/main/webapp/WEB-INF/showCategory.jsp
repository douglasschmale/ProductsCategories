<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${category.name}</h1>
	
	<h2>Related Products:</h2>

	<ul>
		<c:forEach items = "${category.products}" var="pro">
			<li><a href="/product/${pro.id}" style="color:black; text-decoration: none">${pro.name}</a>
		</c:forEach>
	</ul>
	
	<form method="POST" action="/category/${category.id}/join">
		<select name="category_id">
			<c:forEach items="${products}" var="p">
				<option value="${p.name}">${p.name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add">
	</form><br>
	<a href="/category/new" style="color:black; text-decoration: none"><h3>Add a new Category</h3></a>
	<h3>Other Categories:</h3>
	<c:forEach items = "${categories}" var="cat">
		<a href="/product/${cat.id}">${cat.name }</a><br>
	</c:forEach>
</body>
</html>