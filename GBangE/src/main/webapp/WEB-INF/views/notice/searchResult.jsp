<%@page import="com.kh.member.model.vo.Member"%>
<%@page import="com.kh.notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    ArrayList<Notice> list = (ArrayList<Notice>) request.getAttribute("searchList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>검색 결과</title>

<style>
/* 기본 설정 */
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

/* 제목, 부제목 설정 */
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

/* 리스트 블록 설정 */
.board_list {
    width: 100%;
    border-top: 2px solid #000;
}

.board_list > div {
    border-bottom: 1px solid #ddd;
    text-align: center;
}

.board_list > div.top {
    border-bottom: 1px solid #999;
}

.board_list > div:last-child {
    border-bottom: 2px solid #000;
}

.board_list > div > div {
    display: inline-block;
    vertical-align: middle;
    padding: 15px 0;
    font-size: 1.4rem;
}

.board_list > div.top > div {
    font-weight: 600;
}

/* 공백 영역 설정 */
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

/* 페이지 설정 */
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
    border-left: 0;
    line-height: 100%;
}

.board_page a.btn {
    padding-top: 7px;
    font-size: 1.2rem;
    letter-spacing: -3px;
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
<%@include file="/views/common/menubar.jsp"%>
<div class="board_wrap">
    <div class="board_title">
        <h1>검색 결과</h1>
        <p>검색된 결과: <%= list.size() %>개</p>
    </div>
    <div class="board_list">
        <div class="top">
            <div class="num">글 번호</div>
            <div class="title">제목</div>
            <div class="writer">작성자</div>
            <div class="count">조회</div>
            <div class="date">작성일</div>
        </div>
        <% if (list == null || list.isEmpty()) { %>
            <div>
                <div colspan="5">조회된 공지사항이 없습니다.</div>
            </div>
        <% } else { %>
            <% for (Notice n : list) { %>
                <div class="list-area">
                    <div class="num"><%= n.getNoticeId() %></div>
                    <div class="title"><%= n.getNoticeTitle() %></div>
                    <div class="writer"><%= n.getMemberName() %></div>
                    <div class="count"><%= n.getCount() %></div>
                    <div class="date"><%= n.getCreateDate() %></div>
                </div>
            <% } %>
        <% } %>
    </div>
    <div class="board_page">
        <!-- 페이지 링크는 여기에 들어갑니다 --> 
    </div>
    <div class="search_form" style="text-align: center; margin-bottom: 20px;">
        <form action="${contextPath}/search.no" method="get">
            <select name="searchType" style="font-size: 1.6rem; padding: 10px; margin: 5px;">
                <option value="title">제목</option>
                <option value="content">내용</option>
                <option value="titleContent">제목+내용</option>
            </select>
            <input type="text" name="keyword" placeholder="검색어를 입력하세요" style="font-size: 1.6rem; padding: 10px; margin: 5px;">
            <button type="submit" style="font-size: 1.6rem; padding: 10px; margin: 5px;">검색</button>
           
        </form>
        <%if((loginUser != null) && loginUser.getMemberId().equals("admin")){ %>
        <div class="bt_wrap">
        	<br>
            <a href="${contextPath}/insert.no" class="on">글쓰기</a> 
        </div>
        <%} %>
    </div>
    
    <script>
    
    $(".list-area").click(function(){
       ;
        var nno = $(this).children().eq(0).text();
        location.href='<%=request.getContextPath()%>/detail.no?nno='+nno;
    });
</script>
</div>
</body>
</html>
