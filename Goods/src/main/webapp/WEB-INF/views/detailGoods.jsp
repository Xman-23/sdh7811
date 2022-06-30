<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function checkDelete(no)
	//상품 번호 (no) 를 바당서
	{
		re=confirm("정말로 삭제 할까요?");
		//자바 스크립트에 내재된 confirm 를 사용하여
		if(re == true)
		{
			location.href = "deleteGoods?no="+no;
			//href 는 location 객체에 속해있는 프로퍼티로 현재 접속중인 페이지 정보를 갖고 있습니다.
			//또한 값을 변경할 수 있는 프로퍼티이기 때문에 다른 페이지로 이동하는데도 사용되고 있습니다.
		}
	}
</script>
</head>
<body>
<h2>상품 상세 목록</h2>
<hr>

	상품 번호 : ${g.no }<br>
	상품 이름 : ${g.item }<br>
	상품 수량 : ${g.qty }<br>
	상품 가격 : ${g.price }<br>
	상품 이미지 : <br>
	<c:if test="${img == 'yes' }">
		<img src="images/${g.fname }">
	</c:if>
	<br>
	<hr>
	<a href="updateGoods?no=${g.no }">수정하기</a>
	<a href="#" onclick="checkDelete(${g.no})">삭제하기</a>
	<!-- # = 바로 가지 않고 onclick=(이벤트 이름) , 함수 이름  -->
	

</body>
</html>