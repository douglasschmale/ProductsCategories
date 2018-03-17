<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a Category</title>
</head>
<body>
	<h1>New Category:</h1>
	
	<form:form action="/category/new" method="POST" modelAttribute="category">
	<form:label path="name">
		<form:errors path="name"></form:errors>
		<form:input type="text" path="name"></form:input>
	</form:label>
	
	<input type="submit" value="Create Category">
	</form:form><br>
	
	<h3>Other Categories:</h3>
	<c:forEach items = "${categories}" var="cat">
		<a href="/product/${cat.id}">${cat.name }</a><br>
	</c:forEach>
</body>
</html>