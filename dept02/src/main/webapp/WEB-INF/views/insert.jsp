<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>부서 등록</h2>
	<hr>
	<form action="insert.do" method="post">
		부서번호 : <input type="text" name="dno"><br>
		부서이름 : <input type="text" name="dname"><br>
		부서위치 : <input type="text" name="dloc"><br>
		<input type="submit" value="등록">
		<input type="reset" value="다시 작성">
	
	</form>
</body>
</html>