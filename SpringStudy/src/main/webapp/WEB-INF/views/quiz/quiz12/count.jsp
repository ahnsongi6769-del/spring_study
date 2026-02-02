<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>quiz12 Count</h1>
	
	
	<c:choose>
		<%--<c:when test="${loginId == '' || loginId == null}"> --%>
		
		<c:when test="${empty loginId}"> 
		<p>로그인 해주세요</p>
		</c:when>
		<c:otherwise>
			<p>로그인 ID : ${loginId} 님 환영합니다.</p>
		</c:otherwise>
	
	</c:choose>
	
	
	

	<p>접속횟수 : ${count} </p>
	
	<a href = "/quiz12/logout"> 로그아웃</a>

</body>
</html>