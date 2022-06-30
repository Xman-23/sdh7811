<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function pro(dno){
		 re  = confirm("정말 삭제하시겠습니까?");
		 if(re == true ){
			 location.href = "delete.do?dno="+dno;
		 }
	}
</script>
</head>
<body>
	<h2>부서목록</h2>
	<hr>
	<a href="insert.do">등록</a><br>
	<table border="1" width="80%">
		<tr>
			<th>부서번호</th>
			<th>부서명</th>
			<th>부서위치</th>
			<th>Action</th>
		</tr>
		
		<c:forEach var="d" items="${list }">
			<tr>
				<td>${d.dno }</td>
				<td>${d.dname }</td>
				<td>${d.dloc }</td>
				<td>
					<a href="update.do?dno=${d.dno }">수정</a>
					&nbsp;
					<a href="#" onclick="pro(${d.dno})">삭제</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>









