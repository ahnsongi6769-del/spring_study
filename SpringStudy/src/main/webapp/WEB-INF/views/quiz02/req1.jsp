<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/quiz02/req1 GET 요청</h1>
		<div>
		<form action = " /quiz02/req2" method="post"> 
			id: <input type ="text" name= "id"> <br>
			name:<input type ="text" name= "name"> <br>
			price :<input type ="text" name= "price"> <br>
			<button type = "submit"> 전송 </button>
		</form>
	</div>
</body>
</html>