<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판 글쓰기 페이지</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
.board_wrap {
	margin: 30px;
}

.board_write {
	border-top: 2px solid #000;
}

.board_write .title, .board_write .info {
	padding: 15px;
	font-size: 0;
}

.board_write .info {
	border-top: 1px dashed #ddd;
	border-bottom: 1px solid #000;
}

.board_write .cont {
	border-bottom: 2px solid #000;
}

/*textarea*/
.board_write .cont textarea {
	display: block;
	width: 100%;
	height: 300px;
	padding: 15px;
	box-sizing: border-box;
	border: 0;
	resize: vertical;
}

/*title, info 설정*/
.board_write .title dt, .board_write .title dd, .board_write .info dt,
	.board_write .info dd {
	display: inline-block;
	vertical-align: middle;
	font-size: 1.4rem;
}

.board_write .title dt, .board_write .info dt {
	width: 100px;
}

.board_write .title dd {
	width: calc(100% - 100px);
}

.board_write .info dl {
	display: inline-block;
	width: 50%;
	vertical-align: middle;
}

.board_write .title input[type="text"] {
	width: 80%;
}

.board_write input[type="text"], .board_write input[type="password"] {
	padding: 10px;
	box-sizing: border-box;
}

.bt_wrap {
	margin-top: 30px;
	text-align: center;
	font-size: 0;
}

.bt_wrap a {
	display: inline-block;
	min-width: 100px;
	margin-left: 10px;
	padding: 10px;
	border-radius: 2px;
	font-size: 1.4rem;
	text-decoration: none;
}
</style>
</head>

<body>
<%@include file="/views/common/menubar.jsp"%>
	<div class="board_wrap">
		<div class="board_title">
			<h1>대회참여인증 게시판</h1>
			<p>대회참여인증 페이지입니다.</p>
		</div>
		<form action="/gbange/insert.fe" method="post" id="enroll-form" enctype="multipart/form-data">
		<input type="hidden" value="${loginUser.memberNo}" name="memberNo">
			<div class="board_write_wrap">
				<div class="board_write">
					<div class="title">
						<dl>
							<dt>제목</dt>
							<dd>
								<input type="text" placeholder="제목 입력" required name="title">
							</dd>
							<dt>카테고리</dt>
							<dd>
								<select name="category">
							<c:forEach items="${cList}" var="c">
								<option value="${c.categoryNo }">${c.categoryName }</option>							
							</c:forEach>
						</select>
							</dd>
							<dt>대회명</dt>
							<dd>
							<select name="competition">
							<c:forEach var="mar" items="${marathonArr}">
							<option value = "${mar.marathonNo}">${mar.marathonName}</option>
							</c:forEach>
							</select>
							</dd>
						<dt>첨부파일</dt>
						<dd>
							<input type="file" id="uploadFile" name="uploadFile" class="btn btn-outline-secondary">
							<div style="display: none; color: red" id="hidden-file">
							
						</div>
						</dd>
							
							
						</dl>
						
						
					</div>
					<div class="info">
					</div>
					<div class="cont">
						<textarea placeholder="내용 입력" name="content" required></textarea>
					</div>
				</div>
				<br>
				<div class="bt_wrap">
					<button type="submit" class="btn btn-success" onclick="return btn();">등록</button>  
					<button type="button" onclick="cancle()" class="btn btn-outline-secondary">취소</button>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
	
		function btn(){
			var upload = $("#uploadFile");
			var hidden = $("#hidden-file");
			
			if(upload.val() == ""){
				 $("#hidden-file").html("첨부파일이 없으면 인증이 안 되세요;").show();
				return false;
			}
			
		}
	
		function cancle(){
			location.href="${contextPath}/list.fe?currentPage=1"
		}
			
		
	</script>
</body>
</html>