<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        .content {
            background-color:rgb(247, 245, 245);
            width:80%;
            margin:auto;
        }
        .innerOuter {
            border:1px solid lightgray;
            width:80%;
            margin:auto;
            padding:5% 10%;
            background-color:white;
        }

        table * {margin:5px;}
        table {width:100%;}
    </style>
</head>
<body>
        
    <%@include file="../common/header.jsp" %>

    <div class="content">
        <br><br>
        <div class="innerOuter">
            <h2>게시글 상세보기</h2>
            <br>
            <a class="btn btn-secondary" style="float:right;" href="JavaScript:history.back(-1)">목록으로</a>
            <br><br>

            <table id="contentArea" align="center" class="table">
                <tr>
                    <th width="100">제목</th>
                    <td colspan="3">${b.boardTitle }</td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>${b.boardWriter }</td>
                    <th>작성일</th>
                    <td>${b.createDate}</td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <c:choose>
                    <c:when test="${empty b.originName}">
                    	<td colspan="3">
                        	첨부파일이 존재하지 않습니다.
                    	</td>
                    </c:when>
                    <c:otherwise>
	                    <td colspan="3">
	                        <a href="${b.changeName }" download="${b.originName }">${b.originName }</a>
	                    </td>
                    </c:otherwise>
                    </c:choose>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3"></td>
                </tr>
                <tr>
                    <td colspan="4"><p style="height:150px;">${b.boardContent }</p></td>
                </tr>
            </table>
            <br>

            <div align="center">
                <c:if test="${b.boardWriter eq loginUser.userId }">
                <a class="btn btn-primary" href="">수정하기</a>
                <a class="btn btn-danger" href="">삭제하기</a>
                </c:if>
            </div>
            <br><br>
            <table id="replyArea" class="table" align="center">
                <thead>
                    <tr>
                        <th colspan="2">
                            <textarea class="form-control" name="replyContent" id="content" cols="55" rows="2" style="resize:none; width:100%;"></textarea>
                        </th>
                        <c:if test="${!empty loginUser.userId }">
                        	<th style="vertical-align:middle"><button class="btn btn-secondary" onclick="insertReply();">등록하기</button></th>
                        </c:if>                        
                    </tr>
                    <tr>
                        <td colspan="3">댓글(<span id="rcount">${rcount }</span>)</td>
                    </tr>
                </thead>
                <tbody>
                	<c:choose>
                		<c:when test="${empty replyList}">
                			<td colspan="3">댓글이 존재하지 않습니다.</td> 
                		</c:when>
                		<c:otherwise>
                			<c:forEach var="r" items="${replyList }">
								<tr>
			                        <th>${r.replyWriter }</th>
			                        <td>${r.replyContent}</td>
			                        <td>${r.createDate}</td>
			                    </tr>                			
                			</c:forEach>	
                		</c:otherwise>
                	</c:choose>                    
                </tbody>
            </table>
        </div>
        <br><br>
    </div>
    <script type="text/javascript">
    function insertReply(){
    	var boardNo = "${b.boardNo}";
    	var userId = "${loginUser.userId}";
    	var replyContent = $("#content").val();
    	$.ajax({
    		url:"insert.re",
    		data:{
    			"refBno":boardNo,
    			"replyWriter":userId,
    			"replyContent":replyContent
    		},
    		success:function(){
    			$("#content").html("");
    			alert("댓글 작성 성공");
    			refreshReply();
    		},
    		error:function(){
    			console.log("error");
    		}
    	});
    }
    function refreshReply(){
    	
    }
    </script>
    <jsp:include page="../common/footer.jsp" />
    
</body>
</html>