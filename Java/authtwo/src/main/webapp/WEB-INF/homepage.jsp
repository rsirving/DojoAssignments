<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
    <h1>Welcome <c:out value="${currentUser.firstname}"></c:out>!</h1>
    
    <ul>
        <li>First Name: <c:out value="${currentUser.firstname}"></c:out></li>
        <li>Last Name: <c:out value="${currentUser.lastname}"></c:out></li>
        <li>Email: <c:out value="${currentUser.username}"></c:out></li>
        <li>Sign-up Date: <fmt:formatDate dateStyle="long" value="${currentUser.createdAt}"/></li>
        <li>Last Sign-In: <fmt:formatDate dateStyle="long" value="${currentUser.updatedAt}"/></li>
    </ul>
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
</body>
</html>