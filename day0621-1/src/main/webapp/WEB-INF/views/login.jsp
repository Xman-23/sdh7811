<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>로그인</h2>
		<hr>
		<form action="login" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			아이디 : <input type="text" name="username"><br>
			비밀번호 : <input type="password" name="password"><br>
			<input type="submit" value="로그인">
		</form>
</body>
</html>