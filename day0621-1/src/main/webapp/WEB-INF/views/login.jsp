<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>�α���</h2>
		<hr>
		<form action="login" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			���̵� : <input type="text" name="username"><br>
			��й�ȣ : <input type="password" name="password"><br>
			<input type="submit" value="�α���">
		</form>
</body>
</html>