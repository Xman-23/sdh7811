<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h2>��ǰ ���</h2>
	<form action="insertGoods" method="post" enctype="multipart/form-data">
	
	��ǰ ��ȣ : <input type="number" name="no"><br>
	��ǰ �̸� : <input type="text" name="item"><br>
	��ǰ ���� : <input type="number" name="qty"><br>
	��ǰ ���� : <input type="number" name="price"><br>
	��ǰ ���� : <input type="file" name="uploadFile"><br>
	
	<input type="submit" value="���">
	&nbsp;&nbsp;
	<input type="reset"   value="���">
	
	
	</form>

</body>
</html>