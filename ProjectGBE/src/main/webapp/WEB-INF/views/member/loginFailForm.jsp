<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();

	String saveId = "";
	
	if(cookies != null){
		
		for(Cookie c: cookies){
			if(c.getName().equals("userId")){
				saveId = c.getValue();
				break;
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="views/member/css/login-style.css">
</head>
<body>

	<%@include file="/views/common/menubar.jsp"%>	

	<div id="login-container">
		<div id="container">
			<div id="header">
				<p align="center" style="font-size:60px; font-weight:700">로그인</p>
			</div>
		<form action="/gbange/login.me" method="post" id="login-form">
			<input type="text" name="userId" id="loginId" placeholder="아이디"> 
			<input type="password" name="userPwd" id="loginPwd placeholder="비밀번호"> 
			<label for="saveId"><input type="checkbox" id="saveId" name="saveId"> 아이디 저장</label> 
			<br>
			<br>
			<div align="center" style="color:red;">아이디와 비밀번호가 일치하지 않습니다.</div>	
			<br> <input type="submit" id="login-btn" value="Login">
			<div align="center">
				<a href="${contextPath}/findId.me">아이디 찾기</a> / <a href="${contextPath}/findPwd.me">비밀번호 찾기</a> / <a href="${contextPath}/enrollCheck.me">회원가입</a>
			</div>

		</form>
		</div>
	</div>
	
<script>
	$(function(){ 
		
		var saveId = "${cookie.userId.value}";

		if(saveId!=""){
			$("#saveId").attr("checked",true);
			$("#loginId").val(saveId);
		}        		
		
	});
</script>
</body>
</html>
</html>