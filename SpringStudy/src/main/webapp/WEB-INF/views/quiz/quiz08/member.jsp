<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>member 페이지</h1>

	<h2>서버에서 화면에 보여줄 Member 데이터를 이미 필터링해서 전달</h2>
	<c:forEach var="m" items="${viewMemberList}">
		<p>${m.id}${m.pw}${m.name}${m.type}</p>
	</c:forEach>

	<%-- 	${viewMemberList} --%>

	<hr>

	<h2>서버에서 전체 리스트 넘기고, view에서 jstl 활용하여 구분하여 출력</h2>

	<c:choose>
		<c:when test="${auth == 'basic' }">
			<c:forEach var="m" items="${memberList}">
				<c:if test="${m.type == 'basic'}">
					<p>${m.id}${m.pw}${m.name}${m.type}</p>
				</c:if>
			</c:forEach>
		</c:when>
		<c:when test="${auth == 'manager' }">
			<c:forEach var="m" items="${memberList}">
				<c:if test="${m.type == 'manager'}">
					<p>${m.id}${m.pw}${m.name}${m.type}</p>
				</c:if>
			</c:forEach>
		</c:when>
		<%-- 		<c:when test="${auth == 'admin' }"> --%>
		<%-- 		</c:when> --%>
		<c:otherwise>
			<c:forEach var="m" items="${memberList}">
				<p>${m.id}${m.pw}${m.name}${m.type}</p>
			</c:forEach>
		</c:otherwise>
	</c:choose>

	<hr>
	<h2>로직 개선 버전</h2>

	<c:if test="${auth == 'basic' || auth == 'manager'}">
		<c:forEach var="m" items="${memberList}">
			<c:if test="${m.type == auth}">
				<p>${m.id}${m.pw}${m.name}${m.type}</p>
			</c:if>
		</c:forEach>
	</c:if>

	<%-- 	<c:if test="${auth != 'basic' && auth != 'manager'}"> --%>
	<c:if test="${auth == 'admin'}">
		<c:forEach var="m" items="${memberList}">
			<p>${m.id}${m.pw}${m.name}${m.type}</p>
		</c:forEach>
	</c:if>

	<hr>
	<h2>로직 개선 버전2</h2>
	
	<c:forEach var="m" items="${memberList}">
		<c:if test="${m.type == auth || auth == 'admin'}">  
			<p>${m.id}${m.pw}${m.name}${m.type}</p>
		</c:if>
		
<%-- 		<c:if test="${auth == 'admin'}">  --%>
<%-- 			<p>${m.id}${m.pw}${m.name}${m.type}</p> --%>
<%-- 		</c:if> --%>
	</c:forEach>


</body>
</html>
















