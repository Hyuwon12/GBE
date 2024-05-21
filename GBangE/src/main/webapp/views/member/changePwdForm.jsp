<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="views/member/css/changePwd-style.css">
</head>
<body>
<%@include file="/views/common/menubar.jsp"%>

<div id="container">
	<div id="container2">
		<div id="header">
			<h1 align="center" style="font-size:48px; font-weight:700">비밀번호 찾기</h1>
		</div>
		<form action="${contextPath}/changePwd.me" method="post">
			<input type="hidden" name="userId" value="${userId }">
			<div class="user-info">
				<div class="user-info-pw">
					<div style="font-weight:700">* 변경할 비밀번호</div>
					<input type="password" name="userPwd" id="userPwd" />
				</div>
				<div id="hidden-pwdArea" style="display: none; margin-top:10px;"></div>

				<div class="user-info-pw-check">
					<div style="font-weight:700">* 비밀번호 확인</div>
					<input type="password" id="checkPwd" />
				</div>
				<div id="hidden-checkPwdArea" style="display: none; margin-top:10px;"></div>
			</div>
			
			<br><br><br><br>
			
			<div class="btn">
					<button type="submit" id="change-btn" onclick="return change();">비밀번호 변경하기</button>
					<button type="button" id="login-btn" onclick="login();">로그인페이지</button>
			</div>
		</form>
	</div>
</div>
<script>
	function change(){
		var pwd = $("#userPwd");
		var checkPwd = $("#checkPwd");
		
		var regPwd = /^[a-zA-Z0-9!@#$%^&*]{4,15}$/;
	
		
		//비밀번호 null값 비교
		if (pwd.val() == "") {
			$("#hidden-pwdArea").html("*비밀번호를 입력하세요.").show();
			$("#hidden-pwdArea").css({
				"color" : "red"
			});
			pwd.focus();
			return false;
		//비밀번호 형식 비교
		} else if (!regPwd.test(pwd.val())) {
			$("#hidden-pwdArea").html("*4~15자 영문 대소문자, 숫자, 특수기호만 입력하세요.")
					.show();
			$("#hidden-pwdArea").css({
				"color" : "red"
			});
			pwd.focus();
			return false;
			//비밀번호 아이디값 비교
		} else if (pwd.val() == "${userId}") {
			$("#hidden-pwdArea").html("*아이디와 동일한 비밀번호를 사용할 수 없습니다.").show();
			$("#hidden-pwdArea").css({
				"color" : "red"
			});
			pwd.focus();
			return false;
		} else {
			$("#hidden-pwdArea").hide();
		}

		//비밀번호 동일여부 체크
		if (checkPwd.val() !== pwd.val()) {
			$("#hidden-checkPwdArea").html("*비밀번호와 동일하지 않습니다.").show();
			$("#hidden-checkPwdArea").css({
				"color" : "red"
			});
			checkPwd.focus();
			return false;
		} else {
			$("#hidden-checkPwdArea").hide();
		}
	}
	
</script>
</body>
</html>