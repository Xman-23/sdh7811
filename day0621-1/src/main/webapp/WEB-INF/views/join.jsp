<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<h2>회원가입</h2>
		<form action="/join" method="post">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		아이디 : <input type="text" name="id">
		비밀빈호 : <input type="password" name="pwd">
		이름 :  <input type="text" name="name">
		<input type="submit" value="가입">
		
		</form>
</body>
</html>