<%@page import="java.util.ArrayList"%>
<%@page import="servlet.model.vo.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체 회원 목록</h1>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>주소</th>
		</tr>
		<c:forEach items="${list}" var="infor">
		<tr>
			<td>${infor.id}</td>
			<td>${infor.name}</td>
			<td>${infor.address}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>