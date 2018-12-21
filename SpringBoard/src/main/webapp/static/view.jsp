<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="board" value="${data}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 확인</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css"
	type="text/css" />
<script src="static/js/jquery.min.js"></script>
<script>
	var idx = null;
	$(document).ready(function() {
		idx = ${board.idx};
		$("#txtIdx").val("${board.idx}");
		$("#txtWritedate").val("${board.writedate}");
		$("#txtName").val("${board.name}");
		$("#txtEmail").val("${board.email}");
		$("#txtReadnum").val("${board.readnum}");
		$("#txtTitle").val("${board.title}");
		$("#txtContents").val("${board.contents}");
		
		$("#btnCancel").bind("click", function(){
			location.href = "/board/";
		});
		
		$("#btnUpdate").click(function(){
			$.ajax({
				url : "/board/" + idx,
				method : "PUT",
				data : JSON.stringify({
					"email" : $("#txtEmail").val(),
					"title" : $("#txtTitle").val(),
					"contents" : $("#txtContents").val()
				}),
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				success : function (data){
					if(data.code){
						alert("Update Success");    location.href = "/board/";
					}else{
						alert("Update Failure");
					}
				},
				error : function(err){
					console.log("Error 발생 : " + err);
				}
			});	
		});
		
		$("#btnDelete").bind("click", function(){
			$.ajax({
				url : "/board/" + idx,
				method : "DELETE",
				success : function(data){
					if(data.code){
						alert("Delete Success");
						location.href = "/board/";
					}
				},
				error : function(err){
					console.log("Error 발생 : " + err);
				}
			});
		});
	});
</script>
</head>
<body>
	<h1 class="text-center">게시판 글 확인</h1>
	<form class="form-horizontal">
		<div class="form-group">
			<label  class="col-sm-3 control-label">글번호</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="txtIdx" readonly>
			</div>
			<label  class="col-sm-2 control-label">조회수</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="txtReadnum" readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">작성날짜</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="txtWritedate" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="txtName" class="col-sm-3 control-label">작성자</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="txtName"
					placeholder="Writer" readonly>
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
				<textarea class="form-control" rows="5" id="txtContents"
					placeholder="Contents"></textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="text-center">
				<button type="button" class="btn btn-primary" id="btnUpdate">
					<span class="glyphicon glyphicon-signal" aria-hidden="true"></span> 수정하기
				</button>
				<button type="button" class="btn btn-danger" id="btnDelete">
					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 삭제하기
				</button>
				<button type="button" class="btn btn-warning" id="btnAnswer">
					<span class="glyphicon glyphicon-object-align-bottom" aria-hidden="true"></span> 답변하기
				</button>
				<button type="button" class="btn btn-success" id="btnCancel">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 목록으로
				</button>
			</div>
		</div>
	</form>
</body>
</html>