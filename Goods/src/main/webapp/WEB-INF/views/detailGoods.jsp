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
	//��ǰ ��ȣ (no) �� �ٴ缭
	{
		re=confirm("������ ���� �ұ��?");
		//�ڹ� ��ũ��Ʈ�� ����� confirm �� ����Ͽ�
		if(re == true)
		{
			location.href = "deleteGoods?no="+no;
			//href �� location ��ü�� �����ִ� ������Ƽ�� ���� �������� ������ ������ ���� �ֽ��ϴ�.
			//���� ���� ������ �� �ִ� ������Ƽ�̱� ������ �ٸ� �������� �̵��ϴµ��� ���ǰ� �ֽ��ϴ�.
		}
	}
</script>
</head>
<body>
<h2>��ǰ �� ���</h2>
<hr>

	��ǰ ��ȣ : ${g.no }<br>
	��ǰ �̸� : ${g.item }<br>
	��ǰ ���� : ${g.qty }<br>
	��ǰ ���� : ${g.price }<br>
	��ǰ �̹��� : <br>
	<c:if test="${img == 'yes' }">
		<img src="images/${g.fname }">
	</c:if>
	<br>
	<hr>
	<a href="updateGoods?no=${g.no }">�����ϱ�</a>
	<a href="#" onclick="checkDelete(${g.no})">�����ϱ�</a>
	<!-- # = �ٷ� ���� �ʰ� onclick=(�̺�Ʈ �̸�) , �Լ� �̸�  -->
	

</body>
</html>