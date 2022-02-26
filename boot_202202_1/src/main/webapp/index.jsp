<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sec:authentication property="principal" var="loginUser"/>
	<sec:authorize access="isAuthenticated()">
		<span>${loginUser.id } 님, </span>
		안녕하세요?
		<input type="button" value="log-out" onclick="location.href='${pageContext.request.contextPath}/logout'"/>
	</sec:authorize>
	
	<sec:authorize access="isAnonymous()">
	로그인하기를 통해 로그인 해주세요.
	<input type="button" value="log-in" onclick="location.href='${pageContext.request.contextPath}/member/login'" />
	</sec:authorize>
</body>
</html>