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
		<title>Dashboard</title>
		<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
	</head>

	<body>
		<a href="/songs/new">New Song</a>
		<a href="/search/topTen">Top Ten</a>
		<form method="POST" action="/search">
			<input id="searchText" type="text" placeholder="Artist Name" name="search">
			<input type="submit" value="Search">
		</form>

		<table>
			<thead>
				<th>Title</th>
				<th>Artist</th>
				<th>Rating</th>
				<th>Actions</th>
			</thead>
			<c:forEach items="${songs}" var="song">
				<tr>
					<td><a href="/songs/${song.id}">${song.title}</a></td>
					<td>${song.artist}</td>
					<td>${song.rating}</td>
					<td><a href="/songs/edit/${song.id}">Edit</a> <a href="/songs/delete/${song.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>