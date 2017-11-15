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
		<h2>Welcome, ${currentUser.username}.</h2>
		<c:if test="${currentUser.permissionLevel >= 2}">
			<a href="/ring_creator">Forge a Ring</a>
			<a href="/fool_creator">Manipulate the Mortals</a>
		</c:if>

		Rings of Power: 
		<form method="POST" action="/bindring">
			<select name="ring">
				<c:forEach var="ring" items="${rings}">
					<option value="${ring.id}">${ring.name}</option>
				</c:forEach>
			</select>
			<input type="submit" value="Bind">
		</form>
	</body>
</html>