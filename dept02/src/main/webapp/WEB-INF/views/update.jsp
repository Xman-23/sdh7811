<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>�μ� ����</h2>
<hr>
<form action="update.do" method="post">
	�μ���ȣ : ${d.dno }<br>
	<input type="hidden" name="dno" value="${d.dno }">
	�μ��̸� : <input type="text" name="dname" value="${d.dname }"><br>
	�μ���ġ : <input type="text" name="dloc" value="${d.dloc }"> <br>
	<input type="submit" value="����">
	&nbsp;
	<input type="reset" value="���">
</form>

</body>
</html>