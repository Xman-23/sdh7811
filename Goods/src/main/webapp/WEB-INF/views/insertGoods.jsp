<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h2>상품 등록</h2>
	<form action="insertGoods" method="post" enctype="multipart/form-data">
	
	상품 번호 : <input type="number" name="no"><br>
	상품 이름 : <input type="text" name="item"><br>
	상품 수량 : <input type="number" name="qty"><br>
	상품 가격 : <input type="number" name="price"><br>
	상품 사진 : <input type="file" name="uploadFile"><br>
	
	<input type="submit" value="등록">
	&nbsp;&nbsp;
	<input type="reset"   value="취소">
	
	
	</form>

</body>
</html>