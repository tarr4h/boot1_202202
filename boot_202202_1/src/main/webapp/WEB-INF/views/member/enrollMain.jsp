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
	<p>회원가입화면</p>
	<form:form method="POST" action="${pageContext.request.contextPath }/member/memberEnroll?${_csrf.parameterName}=${_csrf.token}">
		<table class="enrollTable">
			<tbody>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="id" id="" />
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="password" id="" />
					</td>				
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="name" id="" />					
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>
						<input type="text" name="phone" id="" />
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
						<input type="text" name="address" id="" value=""/>
					</td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="submit" value="제출하기" />
					</th>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>