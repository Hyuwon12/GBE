<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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

<title>Insert title here</title>
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
			<h1>공지사항</h1>
			<p>공지사항 수정 페이지입니다.</p>
		</div>
		<form action="${contextPath}/update.no" method="post" id="enroll-form" enctype="multipart/form-data">
		<input type="hidden" name="memberNo" value="${loginUser.memberNo }">
		<input type="hidden" name="noticeId" value="${noticeId}">
		<div class="board_view_wrap">
			<div class="board_write">
				<div class="title">
					<dl>
							<dt>제목</dt>
							<dd>
								<input type="text" name="title" placeholder="제목 입력" required>
							</dd>
						</dl>
					</div>
					<div class="info">
						
						<dl>
							<dt>첨부파일</dt>
						<dd>
							<input type="file" name="uploadFile" class="btn btn-outline-secondary">
						</dd>
						</dl>
					</div>
					<div class="cont">
						<textarea name="content" placeholder="내용 입력"></textarea>
					</div>
     
				</div>
			
			<br>
			<div class="bt_wrap">
    <a href="javascript:document.getElementById('enroll-form').submit();" class="btn btn-success btn-lg">등록</a>
    <a href="${contextPath}/list.no?currentPage=1" class="btn btn-secondary btn-lg">취소</a>
			</div>
			</div>
		</div>
		<script>
    $(document).ready(function() {
        $('#enroll-form').submit(function() {
            return confirm('정말 수정하시겠습니까?');
        });
    });
	</script>
		
		
		</form>
	</div>
</body>
</html>