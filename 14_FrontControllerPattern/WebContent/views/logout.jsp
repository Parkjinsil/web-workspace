<%@page import="servlet.model.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>로그아웃 하셨습니다.</h2>
	<script>
		alert('Logout!');
		location.href="/index.jsp";
	</script>
</body>	
</html>