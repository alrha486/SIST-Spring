<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Board</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="static/css/style.css" type="text/css">
<script src="static/js/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$.ajax({
			url : "/board/" ,
			dataType : "json",
			method : "POST",
			success : function(data){
				var result = data.data;
				$('#count').text(result.length).css({"color" : "blue", "font-weight" : "bold"});
				var str = "";
				for(var i =0; i<result.length; i++){
					str +=  "<tr>";
					str +=  "<td>" + result[i].grp + "</td><td><a href='mailto:'" +result[i].email+ "''>" + result[i].name + "</a></td>"
					str +=  "<td><a href="+ result[i].idx + ">" + result[i].title + "</a></td>"; 
					str +=  "<td>" + result[i].writedate + "</td>"
					str +=  "<td>" + result[i].readnum + "</td>";
				 	str +=  "<tr>";
				}
				$('#records').html(str);
			},
			error : function(err){
				console.log("error발생 =" + err);
			}
		});
	});
</script>
</head>
<body>
	<div class="text-center"><img src="static/images/bulletin-board.jpg"/></div>
	<div>
		<table border="1" class="table table-condensed">
			<tr>
				<td>[<a href="write">새 글쓰기</a>]
				</td>
				<td>[<span id="count"></span>개의 글]
				</td>
			</tr>
		</table>
	</div>
	<div>
		<table border="1" class="table table-hover">
			<colgroup>
				<col width="10%" />
				<col width="10%" />
				<col width="60%" />
				<col width="10%" />
				<col width="10%" />
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody id="records"></tbody>
		</table>
	</div>
	<p></p>
	<div id="paging"></div>
</body>
</html>