<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css"
	type="text/css" />
<script src="static/js/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$("#btnWrite").bind("click", function(){
			$.ajax({
				url : "write",
				dataType : "json",
				method : "POST",
				contentType : 'application/json; charset=UTF-8',
				data : JSON.stringify({
					"name" : $("#txtName").val(),
					"email" : $("#txtEmail").val(),
					"title" : $("#txtTitle").val(),
					"contents" : $("#txtContents").val()
				}),
				success : function(data){
					if(data.code) {
						alert("Insert Success");
						location.href = "/board";
					} else alert("Insert Failure\nPlease Try again.");
				},
				error : function(err){
					console.log("Error 발생 : " + err);
				}
			});
		});
		$("#btnCancel").bind("click", function(){
			history.back();
		});
	});
</script>
</head>
<body>
	<h1 class="text-center">게시판 글 쓰기</h1>
	<form class="form-horizontal">
		<div class="form-group">
			<label for="txtName" class="col-sm-3 control-label">작성자</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="txtName"
					placeholder="Writer">
			</div>
		</div>
		<div class="form-group">
			<label for="txtEmail" class="col-sm-3 control-label">Email</label>
			<div class="col-sm-6">
				<input type="email" class="form-control" id="txtEmail"
					placeholder="Email">
			</div>
		</div>
		<div class="form-group">
			<label for="txtTitle" class="col-sm-3 control-label">제목</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="txtTitle"
					placeholder="Title">
			</div>
		</div>
		<div class="form-group">
			<label for="txtContents" class="col-sm-3 control-label">내용</label>
			<div class="col-sm-6">
				<textarea class="form-control" rows="5" id="txtContents" placeholder="Contents"></textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="text-center">
				<button type="button" class="btn btn-primary" id="btnWrite">글 쓰기</button>
				<button type="button" class="btn btn-success" id="btnCancel">취소</button>
			</div>
		</div>
	</form>
</body>
</html>