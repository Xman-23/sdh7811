<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판 등록</h2>
	<hr>
	<form action="updateBoard" method="post" enctype="multipart/form-data">
	<input type="hidden" name="no" value="${b.no }">
	게시판 제목 : <input type="text" name="title" value="${b.title }"><br>
	게시판 저자 : ${b.writer }<br>
	게시판 비밀번호 : <input type="password" name="pwd"><br>
	게시판 내용 
	<br>
	<textarea rows="10" cols="80" name="content">${b.content }</textarea>
	<br>
	<input type="hidden" name="fname" value="${b.fname }">
	첨부파일 : ${b.fname }<br> 
	<!-- <input type="file" name="uploadFile"><br>-->
	사진 : <input type="file" name="uploadFile"><br>
	<input type="submit" value="수정">
	&nbsp;&nbsp;
	<input type="reset" value="취소">
	
	
	</form>
</body>
</html>