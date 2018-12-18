<%@ page session="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>회원가입 확인 창</title>
</head>
<body>
	<h1>User Infomation (confirm1.jsp)</h1>

	<ul>
		<li>성명 : ${username}</li>
		<li>나이 : ${userage}</li>
		<li>성별 : ${gender}</li>
		<li>거주지 : ${city}</li>
	</ul>	
</body>
</html>
