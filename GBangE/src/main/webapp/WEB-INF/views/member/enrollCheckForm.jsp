<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
<link rel="stylesheet" href="views/member/css/enrollCheck-style.css">
</head>

<body>

  	<%@include file="/views/common/menubar.jsp"%>
  	
  <form action="/gbange/insert.me">
	
    <div class="enroll-form">
        <div class="header" align="center">
            <h1 style="font-size:60px; font-weight:700">회원가입</h1>
        </div>
      <br><br><br><br><br>
      
      <input type="checkbox" class="check" id="check-all">
      <label for="check-all"><font style="font-size: 20px;"><u>전체 동의하기</u></font></label>
      
      <br><br><br><br>
      <h2 style="font-weight:700">서비스 이용약관</h2>
      <br>
      <p class="agree">
      제 1 장 총칙

      제 1 조 (목적)
      본 약관은 통계청이 운영하는 나라통계시스템 운영홈페이지(이하 "당 사이트")에서 제공하는 모든 서비스(이하 "서비스")의 이용조건 및 절차, 이용자와 당 사이트의 권리, 의무, 책임사항과 기타 필요한 사항을 규정함을 목적으로 합니다.

      제 2 조 (약관의 효력과 변경)
      ① 당 사이트는 이용자가 본 약관 내용에 동의하는 것을 조건으로 이용자에게 서비스를 제공하며, 당 사이트의 서비스 제공 행위 및 이용자의 서비스 사용 행위에는 본 약관을 우선적으로 적용하겠습니다.
      ② 당 사이트는 본 약관을 사전 고지 없이 변경할 수 있으며, 변경된 약관은 당 사이트 내에 공지함으로써 이용자가 직접 확인하도록 할 것입니다. 이용자가 변경된 약관에 동의하지 아니하는 경우 본인의 회원등록을 취소(회원탈퇴)할 수 있으며, 계속 사용할 경우에는 약관 변경에 대한 암묵적 동의로 간주됩니다. 변경된 약관은 공지와 동시에 그 효력을 발휘합니다.

      제 3 조 (약관 외 준칙)
      본 약관에 명시되지 않은 사항은 전기통신기본법, 전기통신사업법, 정보통신망 이용촉진 및 정보보호 등에 관한 법률 및 기타 관련 법령의 규정에 의합니다.

      제 4 조 (용어의 정의)
      ① 본 약관에서 사용하는 용어의 정의는 다음과 같습니다.
      1. 이용자 : 본 약관에 따라 당 사이트가 제공하는 서비스를 받는 자
      2. 가 입 : 당 사이트가 제공하는 신청서 양식에 해당 정보를 기입하고, 본 약관에 동의하여 서비스 이용계약을 완료시키는 행위
      3. 회 원 : 당 사이트에 필요한 개인 정보를 제공하여 회원 등록을 한 자로서, 당 사이트의 정보 및 서비스를 이용할 수 있는 자
      4. 아이디 : 이용고객의 식별과 이용자가 서비스 이용을 위하여 이용자가 정한 문자와 숫자의 조합
      5. 비밀번호 : 아이디에 대한 본인 여부를 확인하기 위하여 사용되는 문자, 숫자, 특수문자 등의 조합
      6. 탈퇴 : 서비스 또는 회원이 이용계약을 종료하는 행위
      ② 본 약관에서 정의하지 않은 용어는 개별서비스에 대한 별도 약관 및 이용규정에서 정의합니다.
      </p>
      <br>
      <input type="checkbox" class="check" name="chk" id="check1">
      <label for="check1"><font> 서비스 이용약관의 내용에 동의합니다.</font></label>

      <br><br><br><br>
      
      <h2 style="font-weight:700">개인정보 처리 방침안내</h2>
      <br>
      <p class="agree">
      1. 개인정보의 수집항목 및 수집방법 
      통계청 나라통계사이트에서는 기본적인 회원 서비스 제공을 위한 필수정보로 실명인증정보와 가입정보로 구분하여 다음의 정보를 수집하고 있습니다. 필수정보를 입력해주셔야 회원 서비스 이용이 가능합니다.
      가. 수집하는 개인정보의 항목 
      * 수집하는 필수항목
      - 실명인증정보 : 이름, 휴대전화번호, 본인 인증 또는 I-PIN(개인식별번호), GPKI
      - 가입정보 : 아이디, 비밀번호, 성명, 이메일, 전화번호, 휴대전화번호, 기관명
      * 선택항목
      - 주소, 기관의 부서명
          
      [컴퓨터에 의해 자동으로 수집되는 정보]
      인터넷 서비스 이용과정에서 아래 개인정보 항목이 자동으로 생성되어 수집될 수 있습니다. 
      - IP주소, 서비스 이용기록, 방문기록 등
      
      나. 개인정보 수집방법
      홈페이지 회원가입을 통한 수집 
        
      2. 개인정보의 수집/이용 목적 및 보유/이용 기간
      통계청 나라통계사이트에서는 정보주체의 회원 가입일로부터 서비스를 제공하는 기간 동안에 한하여 통계청 나라통계사이트 서비스를 이용하기 위한 최소한의 개인정보를 보유 및 이용 하게 됩니다. 회원가입 등을 통해 개인정보의 수집·이용, 제공 등에 대해 동의하신 내용은 언제든지 철회하실 수 있습니다. 회원 탈퇴를 요청하거나 수집/이용목적을 달성하거나 보유/이용기간이 종료한 경우, 사업 폐지 등의 사유발생시 개인 정보를 지체 없이 파기합니다.
        
      * 실명인증정보
      - 개인정보 수집항목 : 이름, 휴대폰 본인 인증 또는 I-PIN(개인식별번호), GPKI
      - 개인정보의 수집·이용목적   : 홈페이지 이용에 따른 본인 식별/인증절차에 이용
      - 개인정보의 보유 및 이용기간 : I-PIN / GPKI는 별도로 저장하지 않으며 실명인증용으로만 이용
        
      * 가입정보
      - 개인정보 수집항목 : 아이디, 비밀번호, 성명, 이메일, 전화번호, 휴대전환번호, 기관명
      - 개인정보의 수집·이용목적 : 홈페이지 서비스 이용 및 회원관리, 불량회원의 부정 이용방지, 민원신청 및 처리 등
      - 개인정보의 보유 및 이용기간 : 2년 또는 회원탈퇴시
        
      정보주체는 개인정보의 수집·이용목적에 대한 동의를 거부할 수 있으며, 동의 거부시 통계청 나라통계사이트에 회원가입이 되지 않으며, 통계청 나라통계사이트에서 제공하는 서비스를 이용할 수 없습니다.
        
      3. 수집한 개인정보 제3자 제공
      통계청 나라통계사이트에서는 정보주체의 동의, 법률의 특별한 규정 등 개인정보 보호법 제17조 및 제18조에 해당하는 경우에만 개인정보를 제3자에게 제공합니다.
      
            
      4. 개인정보 처리업무 안내
      통계청 나라통계사이트에서는 개인정보의 취급위탁은 하지 않고 있으며, 원활한 서비스 제공을 위해 아래의 기관을 통한 실명인증 및 공공 I-PIN, GPKI 인증을 하고 있습니다. 
        
      * 수탁업체
      - 행정자치부
      · 위탁업무 내용 : 공공 I-PIN, GPKI 인증
      · 개인정보 보유 및 이용 기간 : 행정자치부에서는 이미 보유하고 있는 개인정보이기 때문에 별도로 저장하지 않음
      </p>
      <br>
      <input type="checkbox" class="check" name="chk" id="check2">
      <label for="check2"><font> 개인정보 이용약관의 내용에 동의합니다.</font></label>
      
      <br><br><br><br><br><br>
      

      <button type="submit" id="enroll-btn" class="btn" disabled>회원가입</button>
      <br><br><br><br><br><br>

    </div>
  </form>

  <script>  
      //전체동의 버튼 눌렀을때 모든 버튼 활성화/비활성화
			$("#check-all").click(function() {
				if($("#check-all").is(":checked")){
          $("input[name=chk]").prop("checked", true);
        }   
				else{
          $("input[name=chk]").prop("checked", false);
        } 
			});
			
			$("input[name=chk]").click(function() {
				var total = $("input[name=chk]").length;
				var checked = $("input[name=chk]:checked").length;
				
				if(total != checked){
          $("#check-all").prop("checked", false);
        }else{
          $("#check-all").prop("checked", true); 
        } 
			});

      //회원가입 버튼 활성화
      $(".check").click(function(){
      if($("#check-all").prop('checked') == true){
        $("#enroll-btn").css({"backgroundColor":"#fff","cursor":"pointer","color":"#000", "border":"1px solid #aacdff"}).prop("disabled",false);
      }else{
        $("#enroll-btn").css({"backgroundColor":"#8990a0","cursor":"auto","color":"#ffffff"}).prop("disabled",true);
      }
    })

	</script>

</body>
</html>