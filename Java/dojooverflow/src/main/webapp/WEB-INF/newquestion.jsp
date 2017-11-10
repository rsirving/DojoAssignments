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
		<h1>What is your question?</h1>
		<form method="POST" action="/questions/new">
			<label name="body">Question:
				<p style="color: red">${errors1.errors1} ${errors4.errors4}</p>
				<textarea name="body" id="body" rows="5" cols="30"></textarea>
			</label>
			<br>
			<label name="tag">Add Tags:
				<p style="color: red">${errors2.errors2} ${errors3.errors3}</p>
				<input type="text" name="tag"/>
			</label>
			<input type="submit" value="Submit">
		</form>
	</body>
</html>