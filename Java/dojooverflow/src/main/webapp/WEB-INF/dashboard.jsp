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
		<title>Overflow</title>
		<link href="https://fonts.googleapis.com/css?family=Roboto|Poiret+One" rel="stylesheet">
		<link href="/css/style.css" rel="stylesheet">
	</head>

	<body>
		<div class="wrapper">
			<h1>OverFlow</h1>
			<h2>Dashboard</h2>
			<table>
				<thead>
					<th>Question</th>
					<th>Tags</th>
				</thead>
				<tbody>
					<c:forEach items="${questions}" var="question"><tr>
						<td><a href="/questions/${question.id}"><c:out value="${question.body}"/></a></td>
						<td><c:forEach items="${question.tags}" var="tag">
							<button disabled>${tag.name}</button>
						</c:forEach></td></tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<form method="GET" action="/questions/new">
				<input type="submit" value="New Question">
			</form>
			<form class="quicknav" action="/" method="GET">
				<input type="submit" value="Return">
			</form>
		</div>
	</body>
</html>