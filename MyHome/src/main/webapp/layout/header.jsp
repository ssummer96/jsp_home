<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div class="header">
			<c:choose>
				<c:when test="${login != null }">
					<a href="/MyHome/member/myPage.jsp">MyPage</a> | 
					<a href="/MyHome/login/logout.jsp">Logout</a> | 
				</c:when>
				<c:otherwise>
					<a href="/MyHome/login/form.jsp">Login</a> | 
					<a href="/MyHome/member/join.jsp">Join</a> | 
				</c:otherwise>
			</c:choose>
			<a href="/MyHome/board/list.jsp">Board</a> | 
			<a href="/MyHome/">Home</a>
		</div>
		<div class="main">