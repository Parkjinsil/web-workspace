<%@page import="servlet.model.vo.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
	<h1>로그아웃</h1>
	
	<% 
		MemberDTO dto = (MemberDTO) session.getAttribute("dto");
	if(dto!=null){
		session.invalidate();
	%>
		<body onload="return logout()">
				<script>
					function logout(){
						alert('Logout!');
						location.href="../index.jsp";
					}
				</script>
		</body>	
	<% } %>
</html>