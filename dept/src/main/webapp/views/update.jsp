<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>부서 수정</h2>
<hr>
<form action="update.do" method="post">
	부서번호 : ${d.dno }<br>
	<input type="hidden" name="dno" value="${d.dno }">
	부서이름 : <input type="text" name="dname" value="${d.dname }"><br>
	부서위치 : <input type="text" name="dloc" value="${d.dloc }"><br>
	<input type="submit" value="수정">
	&nbsp;
	<input type="reset" value="취소">
</form>
</body>
</html>