<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">

	#op
	{
		visibility: hidden;
	}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js">
</script>
<script type="text/javascript">
	$(function() {
		$("#searchColumn").change(	function () {
			let v = $(this).val();
			
			
			if(v == "price") 
			{
				$("#op").css("visibility","visible");
			}else {
				$("#op").css("visibility","hidden")
			}
		});		
		
		$("#btnAjax").click(function () {
			$.ajax({url:"/name",success:function(data)	{
				$("#name").val(data);
			}});	
		});
		
	});

</script>

<title>Insert title here</title>
</head>
<body>
	<h2>도서목록</h2>
	<form action="listBook">
	<select name="searchColumn" id="searchColumn">
		<option value="bookname">도서명</option>
		<option value="price">가격</option>
		<option value="publisher">저자</option>
	</select>
	<select name="op" id="op">
		<option value="=">=</option>
		<option value=">=">>=</option>
		<option value="<="><=</option>
	</select>
		<input type="search" name="keyword">
		<input type="submit" value="검색">
	</form>
	
	<input type="text" id="name">
	<input type="button" value="Ajax통신" id="btnAjax">
	
	<table border="1" width="80%">
		<tr>
			<th><a href="listBook?sortColumn=bookid">도서번호</a></th>
			<th><a href="listBook?sortColumn=bookname">도서명</a></th>
			<th><a href="listBook?sortColumn=price">가격</a></th>
			<th><a href="listBook?sortColumn=publisher">출판사</a></th>
		</tr>
		
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.bookid }</td>
				<td>${b.bookname }</td>
				<td>${b.price }</td>
				<td>${b.publisher }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>