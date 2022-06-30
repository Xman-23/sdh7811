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
		<h2>상품 목록</h2>
		<hr>
		
		<table border="1" width="100%">
		<thead>
		<tr>
		<th>상품 번호</th>
		<th>상품 이름</th>
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
		<a href="insertGoods">상품 등록하기</a>
		<hr> 
		<c:forEach var="i" begin="1" end="${totalPage }">
		<a href="listGoods?pageNUM=${i }">${i }&nbsp;</a>
		</c:forEach> 	
</body>
</html>