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
		<title>Ninja Gold</title>
		<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
	</head>

	<body>
		<p>Your gold: ${gold}</p>
		<div class="option">
			<h2>FARM</h2>
			<p>Earn 10-20 gold</p>
			<form action='/submit' method='POST'>
				<input type='hidden' name='activity' value="farm">
				<input type='submit' value="Find Gold!">
			</form>
		</div>
		<div class="option">
			<h2>CAVE</h2>
			<p>Earn 5-10 gold</p>
			<form action='/submit' method='POST'>
				<input type='hidden' name='activity' value='cave'>
				<input type='submit' value="Find Gold!">
			</form>
		</div>
		<div class="option">
			<h2>HOUSE</h2>
			<p>Earn 2-5 gold</p>
			<form action='/submit' method='POST'>
				<input type='hidden' name='activity' value='house'>
				<input type='submit' value="Find Gold!">
			</form>
		</div>
		<div class="option">
			<h2>CASINO</h2>
			<p>Earn/Lose 0-50 gold</p>
			<form action='/submit' method='POST'>
				<input type='hidden' name='activity' value='casino'>
				<input type='submit' value="Find Gold!">
			</form>
		</div>
		<div>
			<a href="/reset"><button>Reset</button></a>
		</div>
		<div>
			<h2>Activities</h2>
			<c:forEach items="${activities}" var="activity">
				<p>${activity}</p>
			</c:forEach>

		</div>
	</body>
</html>