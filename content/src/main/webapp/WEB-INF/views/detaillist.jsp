<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 상세</h2>
	<hr>
	글번호 : ${b.no }<br>
	글제목 : ${b.title }<br>
	작성자 : ${b.writer }<br>
	글내용 : <br>
	<textarea rows="10" cols="80" readonly="readonly">${b.content }</textarea>
	<br>
	등록일 : ${b.regdate }<br>
	조회수 : ${b.hit }<br>
	
	
	<c:if test="${b.fname !=null and b.fname !='' }">
	첨부파일 : <a href="upload/${b.fname }">${b.fname }</a> <br>
	</c:if>
	
	<c:if test="${img == 'yes' }">
		<img src="upload/${b.fname }">
	</c:if>
	<hr>
	<a href="updateBoard?no=${b.no }">수정하기</a>
	<a href="deleteBoard?no=${b.no }">삭제하기</a>
	<a href="insert?no=${b.no }">답글 작성</a>
</body>
</html>