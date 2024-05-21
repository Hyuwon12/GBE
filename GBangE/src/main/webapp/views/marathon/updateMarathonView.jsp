<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<head>
<meta charset="UTF-8">
<style>
.Detaildiv{
	box-sizing: border-box;
}
.marathonDetail th{
	width:120px;
	text-align:center;
	
}
.marathonDetail th,td{
	height:50px;
}
.head {
	width:40%;
	height:50px;
	text-align:center;
}
.head h1{
	margin-top:20px;
	margin-bottom:20px;
	font-size:40px;
}
.marathonDetail input{
	align:center;
	width:500px;
	height:40px;
	padding-left: 20px;
}
.btndiv{
	margin-left: 300px;
}
</style>
</head>
<body>
<%@include file="/views/common/menubar.jsp"%>
<div class="head">
	<h1>대회정보 변경</h1>
</div>
<br>
<div class="Detaildiv form-floating mb-3">
	<form action="update.ma" method="post">
	<input type="hidden" name="marathonNo" value="${mar.marathonNo }">
    <table class="marathonDetail table">
    <tr>
    	<th>행사명</th>
    	<td><input type="text" class="form-control" name="marathonName" value="${mar.marathonName }"></td>
    </tr>
    <tr>
    	<th>지역</th>
    	<td><input type="text" class="form-control" name="region" value="${mar.region }"></td>
    </tr>
    <tr>
    	<th>코스 정보</th>
    	<td><input type="text" class="form-control" name="marathonCourse" value="${mar.marathonCourse }"></td>
    </tr>
    <tr>
    	<th>마라톤 장소</th>
    	<td><input type="text" class="form-control" name="location" value="${mar.location }"></td>
    </tr>
    <tr>
    	<th>출발일</th>
    	<td><input type="text" class="form-control" name="marathonDate" value="${mar.marathonDate }"></td>
    </tr>
    <tr>
    	<th>접수기간</th>
    	<td><input type="text" class="form-control" name="applicationDate" value="${mar.applicationDate }"></td>
    </tr>
	<tr>
    	<th>주최자</th>
    	<td><input type="text" class="form-control" name="organizer" value="${mar.organizer }"></td>
    </tr>
    <tr>
    	<th>주최단체</th>
    	<td><input type="text" class="form-control" name="organizerHost" value="${mar.organizerHost }"></td>
    </tr>
    <tr>
    	<th>번호</th>
    	<td><input type="text" class="form-control" name="organizerPhone" value="${mar.organizerPhone }"></td>
    </tr>
    <tr>
    	<th>대회 주소</th>
    	<td><input type="text" class="form-control" name="marathonSite" value="${mar.marathonSite }"></td>
    </tr>
    <tr>
    	<th style="height:250px">상세 정보</th>
    	<td>
    	<textarea class="form-control" name="otherIntroduction" style="width:500px; height:350px">
    	${mar.otherIntroduction }
    	</textarea>
    	</td>    	
    </tr>    
    </table>
    <div class="btndiv">
    <button type="button" id="checkBtn" class="btn btn-outline-primary">저장</button>
    <button type="submit" id="submitBtn" class="btn btn-dark" disabled>제출</button>
    <button type="reset" id="resetBtn" class="btn btn-outline-primary">취소</button>
    </div>
    </form>            
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>
</body>
	<script type="text/javascript">
	$(function(){
		$("#checkBtn").click(function(){
			if(confirm('변경사항을 저장하시겠습니까?')){
				$("#submitBtn").attr("disabled",false);	
			}	
		});
		$("#resetBtn").click(function(){
			$("#submitBtn").attr("disabled",true);	
		});		
	});
	</script>
</html>
