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

	<h2>회원 정보 수정</h2>
	<form action="/UpdateServlet" method="post">
		아이디 : ${dto.id}<br>
		비밀번호 : <input type="password" name="password" required/><br>
		이름 :	<input type="text" name="name" required/><br>
		주소 : 	<input type="text" name="address" required/><br>
		<input type="submit" value="수정"/>
	</form>

</body>
</html>