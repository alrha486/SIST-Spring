<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>과일들</h1>
	<ul>
		<c:forEach items="${fruits}" var="fruit" >
			<li>fruit</li>
		</c:forEach>
	</ul>
</body>
</html>