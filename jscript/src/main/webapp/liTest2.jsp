<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
		var list ="";
		list += "<ul>";
		list += "<li>김치볶음밥</li>";
		list += "<li>김치찌개</li>";
		list += "<li>떡볶이</li>";
		list += "<li>치킨</li>";
		list += "</ul>";
		
		document.getElementById("foodlist").innerHTML = list;
		//문서가 만들기도 전에 동작하므로 foodlist를 찾을 수가 없어요
	
		
</script>

</head>
<body>
	<hr>
	<div id="foodlist"></div>
	<hr>
</body>
</html>