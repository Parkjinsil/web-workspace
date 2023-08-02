<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Config CallBack Method...</h3>
	<p><%= request.getParameter("userName") %>님은 <%= request.getParameter("count") %>번재 입장하신 고개입니다...</p>

</body>
</html>