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

<c:if test="${not empty msg }">
	<script>
		console.log("not empty msg");
		alert("${msg }")
	</script>
</c:if>
	<form action="${pageContext.request.contextPath }/login" method="post">
		로그인 화면
		<br />
		<label for="id">아이디</label>
		<input type="text" name="id" id="" />
		<br />
		<label for="password">비밀번호</label>
		<input type="password" name="password" id="" />
		<br />
		<input type="submit" value="enter" />
		
		<input type="button" value="회원가입하기" onclick="location.href='${pageContext.request.contextPath}/member/enrollMain'" />
	</form>
</body>
</html>