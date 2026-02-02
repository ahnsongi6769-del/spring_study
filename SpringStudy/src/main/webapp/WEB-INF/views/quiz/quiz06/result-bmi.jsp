<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> BMI 결과</h1>
	<div>
		<p>이름 : ${bmiForm.name} </p>
		<p>키 : ${bmiForm.height} </p>
		<p>몸무게 : ${bmiForm.weight} </p>
		<p> BMI : ${bmiForm.bmi} </p>		
	</div>
</body>
</html>