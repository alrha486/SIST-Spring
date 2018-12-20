<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>
	<h1>File 업로드 하기</h1>
	<form action="upload" method="post" enctype="multipart/form-data">
		<ul>
			<li>Name : <input type="text" name="name" /></li>
			<li>File : <input type="file" name="file1"></li>
			<li><input type="submit" value="file업로드" ></li>
		</ul>
	</form>
</body>
</html>