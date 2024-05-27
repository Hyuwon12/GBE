<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>'${keyword}' (으)로 검색한 결과</title>

<style>
/*기본 설정*/
* {
	margin: 0;
	padding: 0;
}

html {
	font-size: 10px;
}

a {
	text-decoration: none;
	color: inherit;
}

.board_wrap {
	width: 1000px;
	margin: 100px auto;
}

/*제목, 부제목 설정*/
.board_title {
	margin-bottom: 30px;
}

.board_title h1 {
	font-size: 3rem;
}

.board_title p {
	margin-top: 5px;
	font-size: 1.4rem;
}

/*버튼 설정*/
.bt_wrap {
	margin-top: 30px;
	text-align: center;
	font-size: 0;
}

.bt_wrap a {
	display: inline-block;
	min-width: 80px;
	margin-left: 10px;
	padding: 10px;
	border-radius: 2px;
	font-size: 1.4rem;
}

.bt_wrap a.on {
	background-color: #000;
	color: #fff;
}

.bt_wrap a:nth-child(1) {
	margin-left: 0;
}

/*리스트 블록 설정*/
.board_list {
	width: 100%;
	border-top: 2px solid #000;
}

.board_list>div {
	border-bottom: 1px solid #ddd;
	text-align: center;
}

.board_list>div.top {
	border-bottom: 1px solid #999;
}

.board_list>div:last-child {
	border-bottom: 2px solid #000;
}

.board_list>div>div {
	display: inline-block;
	vertical-align: middle;
	padding: 15px 0;
	font-size: 1.4rem;
}

.board_list>div.top>div {
	font-weight: 600;
}

/*공백 영역 설정*/
.board_list .num {
	width: 10%;
}

.board_list .title {
	width: 60%;
	text-align: left;
}

.board_list .top .title {
	text-align: center;
}

.board_list .writer {
	width: 10%;
}

.board_list .date {
	width: 10%;
}

.board_list .count {
	width: 8%;
}

/*페이지 설정*/
.board_page {
	margin-top: 30px;
	text-align: center;
	font-size: 0;
}

.board_page a {
	display: inline-block;
	width: 30px;
	height: 30px;
	box-sizing: border-box;
	vertical-align: middle;
	border: 1px solid #ddd;
	/* border-left: 0; */
	line-height: 100%;
}

.board_page a.btn {
	padding-top: 7px;
	font-size: 1.2rem;
	letter-spacing: -3px;
	color: black;
}

.board_page a.num {
	padding-top: 6px;
	font-size: 1.4rem;
}

.board_page a.num.selected {
	background-color: #000;
	border-color: #000;
	color: #fff;
}

.board_page a.frist {
	border-left: 1px solid #ddd;
}
</style>
</head>

<body>
<body>
	<%@include file="/views/common/menubar.jsp"%>
	<div class="board_wrap">
		<div class="board_title">
			<h1>러닝일지</h1>
			<p>'${keyword}' (으)로 검색한 결과입니다.</p>
		</div>
		<div class="board_list_wrap">
			<div class="board_list">
				<div class="top">
					<div class="num">글 번호</div>
					<div class="title">제목</div>
					<div class="writer">작성자</div>
					<div class="date">작성일</div>
					<div class="count">조회</div>
				</div>
				<c:choose>
					<c:when test="${empty searchList }">
						<div>
							<div class="num"></div>
							<div class="title">조회된 게시글이 없습니다</div>
							<div class="writer"></div>
							<div class="date"></div>
							<div class="count"></div>
						</div>
					</c:when>
					<c:otherwise>
						<c:forEach var="t" items="${searchList}">
							<div>
								<div class="num">${t.trainingNo }</div>
								<div class="title body">${t.trainingTitle }</div>
								<div class="writer">${t.trainingWriter }</div>
								<div class="date">${t.recordDate }</div>
								<div class="count">${t.count }</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
			<script>
			$(function() {
				$(".body").click(function() {
					var tno = $(this).prev().html();
					location.href="detail.tr?tno="+tno;
				});
				$(".body").mouseenter(function(){
					$(this).css("cursor","pointer");
				});
			});
			</script>
			<div class="board_page">
				<c:choose>
					<c:when test="${pi.currentPage eq 1}">
						<a class="btn first"> &lt;&lt; </a>
						<a class="btn prew"> &lt; </a>
					</c:when>
					<c:otherwise>
						<a href="search.tr?currentPage=${pi.currentPage-1}" class="btn first"> &lt;&lt; </a>
						<a href="search.tr?currentPage=${pi.currentPage-1}" class="btn prew"> &lt; </a>
					</c:otherwise>
				</c:choose>
				<c:forEach var="i" begin="${pi.startPage }" end="${pi.endPage }">
					<a href="search.tr?currentPage=${i}" class="num selected">${i}</a>
				</c:forEach>
				<c:choose>
				<c:when test="${pi.currentPage eq pi.maxPage}">
				<a class="btn next">&gt;</a> <a class="btn last">&gt;&gt;</a>
				</c:when>
				<c:otherwise>
				<a href="search.tr?currentPage=${pi.currentPage+1}"class="btn next">&gt;</a>
				<a href="search.tr?currentPage=${pi.currentPage+1}" class="btn last">&gt;&gt;</a>
				</c:otherwise>
				</c:choose>
			</div>
			<div class="search_form" style="text-align: center; margin-bottom: 20px;">
            <form action="${contextPath}/search.tr" method="get">
                <input type="hidden" name="currentPage" value="1">
                <select name="searchType" style="font-size: 1.6rem; padding: 10px; margin: 5px;">
                    <option value="title">제목</option>
                    <option value="trainingCategory">훈련종류</option>
                    <option value="titleContent">제목+내용</option>
                </select>
                <input type="text" name="keyword" placeholder="검색어를 입력하세요" style="font-size: 1.6rem; padding: 10px; margin: 5px;">
                <button type="submit" style="font-size: 1.6rem; padding: 10px; margin: 5px;">검색</button>
            </form>
		</div>
			<div class="bt_wrap">
				<a href="${contextPath}/insert.tr" class="on">글쓰기</a> 
			</div>
		</div>
	</div>
</body>

</body>
</html>