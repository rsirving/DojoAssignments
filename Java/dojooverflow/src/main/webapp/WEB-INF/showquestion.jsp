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
		<h2><c:out value="${question.body}"/></h2>
		<h3>Tags:</h3>
		<c:forEach items="${question.tags}" var="tag">
			<p>${tag.name}</p>
		</c:forEach>

		<form method="post" action="/answer/new/${question.id}">
			<label name="body">Add Answer:
				<textarea name="body" id="body" cols="30" rows="5"></textarea>
			</label><br>
			<input type="submit" value="Submit">
		</form>
		<h3>Answers:</h3>
		<c:forEach items="${answers}" var="answer">
			<p>${answer.body}</p>
		</c:forEach>
	</body>
</html>