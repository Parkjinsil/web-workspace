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
    
    <% 
    	MemberDTO dto = (MemberDTO) session.getAttribute("dto"); 
    	if(dto!=null) {
    %>
    <h1>로그인 정보</h1>
    <ul>
        <li>아이디 : ${dto.id}</li>
        <li>이름 : ${dto.name}</li>
        <li>주소 : ${dto.address}</li>
    </ul>
    <a href="/index.jsp">첫 페이지로 이동</a>
    <% } else { %>
		<h3>로그인 실패..! 로그인부터 하고 오세요</h3>
		<a href="login.html">login.html</a>
    <% } %>

</body>
</html>