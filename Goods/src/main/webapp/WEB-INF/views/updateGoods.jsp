<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h2>��ǰ ����</h2>
	<form action="updateGoods" method="post" enctype="multipart/form-data">
	��ǰ ��ȣ : ${g.no } <br>
	<input type="hidden" name="no" value="${g.no }">
	��ǰ �̸� : <input type="text" name="item" value="${g.item }"><br>
	��ǰ ���� : <input type="number" name="qty" value="${g.qty }"><br>
	��ǰ ���� : <input type="number" name="price" value="${g.price }"><br>
	<input type="hidden" name="fname" value="${g.fname }"><br>
	<img  src="images/${g.fname }" width="50" height="50" >
	÷�� ���� : ${g.fname }<br>
	���� : <input type="file" name="uploadFile"><br>
	<input type="submit" value="���">
	&nbsp;&nbsp;
	<input type="reset"   value="���">
	
	
	</form>

</body>
</html>