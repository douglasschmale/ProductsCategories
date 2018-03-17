<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a New Product</title>
</head>
<body>
<h1>Create a New Product</h1>
	<form:form action="/product/new" method="POST" modelAttribute="product">
	<form:label path="name">Name:
		<form:errors path="name"></form:errors>
		<form:input type="text" path="name"></form:input>
	</form:label>
	<br>
	<form:label path="description">Description:
		<form:errors path="description"></form:errors>
		<form:input type="text" path="description"></form:input>
	</form:label>	
	<br>
	<form:label path="price">Price:
		<form:errors path="price"></form:errors>
		<form:input type="number" path="price"></form:input>
	</form:label>	
	<br>
	<input type="submit" value="Create Product">
	</form:form><br>
	
	<h3>Other Products:</h3>
	
	<c:forEach items = "${products}" var="pro">
		<a href="/product/${pro.id}">${pro.name }</a><br>
	</c:forEach>
</body>
</html>
