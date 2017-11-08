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
		<form:form method="POST" action="/licenses/new" modelAttribute="license">
			<form:label path="person">
				<form:select path="person">
					<form:option value="NONE" label="Select"/>
					<form:options items="${persons}"/>
				</form:select>
			</form:label>
			<form:label path="state">State:
				<form:input path="state"/>
			</form:label>
			<form:label path="expirationDate">
				<form:input type="date" path="expirationDate"/>
			</form:label>
			<input type="submit" value="Submit">
		</form:form>	
	</body>
</html>