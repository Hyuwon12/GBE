<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
/*기본 설정*/
* {
	margin: 0;
	padding: 0;
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
	font-size: 1.0rem;
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
	border: 1px solid #000;
	border-radius: 2px;
	font-size: 1.0rem;
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
	font-size: 1.0rem;
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

.content-area{
	display: none;
}
.question {
	font-size: 1.0rem;
	width:800px;
	height:250px;
	border-bottom: 3px solid #999;
}
.answer{
	width:800px;
	height:50px;
}
.answerDiv {
	margin-top:40px;
}
.answer>div {
	border-bottom: 1px solid #ddd;
	text-align: center;
}

.answer>div.top {
	border-bottom: 1px solid #999;
}
.answer>div {
	display: inline-block;
	vertical-align: middle;
	padding: 15px 0;
	font-size: 1.0rem;
}

.answer>div.top>div {
	font-weight: 600;
}

.answer .num {
	width: 10%;
}

.answer .title {
	width: 60%;
	text-align: left;
}

.answer .top .title {
	text-align: center;
}

.answer .writer {
	width: 10%;
}

.answer .date {
	width: 20%;
}
.answerContent{
	margin-top:30px;
	height: 100px;
	border-bottom: 1px solid #999;
}
div.deleteBtn {
    margin-left: 5px;
    margin-bottom: 20px;
    height: 52px;
    
}
</style>
</head>
<body>
<%@include file="/WEB-INF/views/common/menubar.jsp"%>
    <div class="board_wrap">
        <div class="board_title">
            <h1>지방이 QnA</h1>
            <br>
            <p>지방이 QnA 페이지입니다.</p>
        </div>
        <div class="board_list_wrap">
            <div class="board_list">
                <div class="top">
                    <div class="num">NO.</div>
                    <div class="title">Q.</div>
                    <div class="writer">작성자</div>
                    <div class="date">작성일</div>
                </div>
                <c:choose>
                <c:when test="${empty questionArr}">
                    <div>
                        <div colspan="5">등록된 글이 없습니다.</div>
                    </div>
                </c:when>
                <c:otherwise>
                <c:forEach var="q" items="${questionArr}">
                <div class="list-area">
                    <div class="num">${q.questionId}</div>
                    <div class="title">${q.questionTitle }</div>
                    <div class="writer">${q.memberName }</div>
					<div class="date">${q.createDate }</div>
				</div>
				<div class="content-area">
					<div class="question">${q.questionContent }</div>					
					<div class="answer-wrap">
					</div>					
					<br>
					<div class="answerDiv">
						<textarea style="width:800px; height:200px;"></textarea>
						<br>
						<c:if test="${! empty loginUser.memberNo }">
						<button type="button" class="btn btn-lg btn-dark" style="font-size:1.0rem;">답변 작성하기</button>
						</c:if>
					</div>
				</div>
				</c:forEach>
				</c:otherwise>
                </c:choose>
                </div>
            </div>
            <c:if test="${!empty loginUser.memberNo }">
            <div class="bt_wrap">			
				<a href="${contextPath}/insert.qu?memberNo=${loginUser.memberNo}" class="on">글쓰기</a>
			</div>
			</c:if>
         </div>
<script>
    $(function(){
        $("div.list-area").click(function(){        
        	$(".content-area .answer-wrap").html("");
        	var memNo = "${loginUser.memberNo}";
        	var questionId = $(this).find('.num').text();
        	$.ajax({
        		url:"list.an",
        		data:{
        			"refQno":questionId,        			
        		},
        		success:function(answerArr){
        			for(let i=0; i<answerArr.length; i++){
        				let tmp="";
        					tmp += "<div class='answer'>";
        					tmp += "<div class='title'>"+answerArr[i].answerTitle+"</div>";
                        	tmp += "<div class='writer'>"+answerArr[i].memberName+"</div>";
                        	tmp += "<div class='date'>"+answerArr[i].createDate+"</div>";
                        	if(memNo == answerArr[i].memberNo){
                        		tmp += "<div class='deleteBtn'><button type='button' class='btn btn-lg btn-dark' style='font-size: 0.9rem;' onclick='deleteAnswer("+answerArr[i].answerId+");'>삭제</button></div>";	
                        	}                        	
                        	tmp += "</div>";
                        	tmp += "<div class='answerContent'>"+answerArr[i].answerContent+"</div>";
    					$(".content-area .answer-wrap").append(tmp);
    					
        			}        			
        		},
        		error:function(){	
        			console.log("error");
        		}
        	});
            if($(this).next().css("display")=="none"){
                $(this).next().slideDown();
                $(this).next().siblings("div.content-area").slideUp();
            }else{
                $(this).next().slideUp();
            }
        });
        $(".answerDiv .btn").click(function() {
        	var questionId = $(this).closest('.content-area').prev('.list-area').find('.num').text();
        	var answerContent = $(this).closest('.answerDiv').find('textarea').val()            
        	var answerTitle = "RE: "+$(this).closest('.content-area').prev('.list-area').find('.title').text();        	
        	$.ajax({
        		url:"insert.an",
        		data:{
        			"refQno":questionId,
        			"memberNo":"${loginUser.memberNo}",
        			"answerContent":answerContent,
        			"answerTitle":answerTitle,
        		},
        		success:function(answerArr){
        			alert("등록완료");
					$('textarea').val('');
        			test(questionId);        			
        		},
        		error:function(){
        			console.log("error");
        		}
        	});
        });
    });
    function test(questionId){
    	$(".content-area .answer-wrap").html("");
    	var memNo = "${loginUser.memberNo}";
    	$.ajax({
    		url:"list.an",
    		data:{
    			"questionId":questionId,        			
    		},
    		success:function(answerArr){
    			for(let i=0; i<answerArr.length; i++){
    				let tmp="";
    					tmp += "<div class='answer'>";
    					tmp += "<div class='title'>"+answerArr[i].answerTitle+"</div>";
                    	tmp += "<div class='writer'>"+answerArr[i].memberName+"</div>";
                    	tmp += "<div class='date'>"+answerArr[i].createDate+"</div>";
                    	if(memNo == answerArr[i].memberNo){
                    		tmp += "<div class='deleteBtn'><button type='button' class='btn btn-lg btn-dark' style='font-size: 0.9rem;' onclick='deleteAnswer("+answerArr[i].answerId+");'>삭제</button></div>";	
                    	}
                    	tmp += "</div>";
                    	tmp += "<div class='answerContent'>"+answerArr[i].answerContent+"</div>";                    	
					$(".content-area .answer-wrap").append(tmp);
    			}        			
    		},
    		error:function(){
    			console.log("error");
    		}
    	});
    }
    function deleteAnswer(e){
		$.ajax({
			url:"delete.an",
			data:{
				"answerId":e
			},
			success:function(refQno){
				alert("삭제완료");
				test(refQno);					
			},
			error:function(){
				console.log("error");
			}
		});
    }
</script>	
</body>
</html>