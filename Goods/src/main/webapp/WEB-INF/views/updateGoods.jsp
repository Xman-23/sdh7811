<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h2>상품 수정</h2>
	<form action="updateGoods" method="post" enctype="multipart/form-data">
	상품 번호 : ${g.no } <br>
	<input type="hidden" name="no" value="${g.no }">
	상품 이름 : <input type="text" name="item" value="${g.item }"><br>
	상품 수량 : <input type="number" name="qty" value="${g.qty }"><br>
	상품 가격 : <input type="number" name="price" value="${g.price }"><br>
	<input type="hidden" name="fname" value="${g.fname }"><br>
	<img  src="images/${g.fname }" width="50" height="50" >
	첨부 파일 : ${g.fname }<br>
	사진 : <input type="file" name="uploadFile"><br>
	<input type="submit" value="등록">
	&nbsp;&nbsp;
	<input type="reset"   value="취소">
	
	
	</form>

</body>
</html>