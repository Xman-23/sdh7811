<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<h2>��ǰ ���</h2>
		<hr>
		
		<table border="1" width="100%">
		<thead>
		<tr>
		<th>��ǰ ��ȣ</th>
		<th>��ǰ �̸�</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="g" items="${list }">
		<tr>
		<td>${g.no }</td>
		<td><a href="detailGoods?no=${g.no }">${g.item }</a></td>
		</tr>
		</c:forEach>
		</tbody>
		
		</table>
		<a href="insertGoods">��ǰ ����ϱ�</a>
		<hr> 
		<c:forEach var="i" begin="1" end="${totalPage }">
		<a href="listGoods?pageNUM=${i }">${i }&nbsp;</a>
		</c:forEach> 	
</body>
</html>