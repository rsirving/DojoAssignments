<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
	</head>

	<body>
		<table class="table">
		<c:forEach items="${boots}" var="boot" >
			<tr>    
			<td><c:out value="${boot.title}"/></td>
			<td><c:out value="${boot.description}"/></td>
			<td><c:out value="${boot.language}"/></td>
			<td><c:out value="${boot.numberOfPages}"/></td>
			<td><a href="/books/delete/${boot.id}">Delete</a></td>			
			</tr>
		</c:forEach>
		</table>
	</body>
</html>