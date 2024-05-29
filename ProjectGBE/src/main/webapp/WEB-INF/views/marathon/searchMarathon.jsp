<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="utf-8">
   <meta content="width=device-width, initial-scale=1.0" name="viewport">
<style> 
.packages .packages-item .packages-img {
    position: relative;
    overflow: hidden;
    transition: 0.5s;
    border-top-right-radius: 10px;
    border-top-left-radius: 10px;
    z-index: 1;
}

.packages .packages-item .packages-img .packages-info {
    background: rgba(0, 0, 0, .3);
}

.packages .packages-item .packages-img .packages-info small,
.packages .packages-item .packages-img .packages-info small i {
    color: var(--bs-white);
    transition: 0.5s;
}

.packages .packages-item .packages-img::after {
    position: absolute;
    content: "";
    width: 0;
    height: 0;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    border: 0px solid;
    border-radius: 10px !important;
    visibility: hidden;
    transition: 0.7s;
    z-index: 3;
}

.packages .packages-item .packages-img:hover.packages-img::after {
    width: 100%;
    height: 100%;
    border: 300px solid;
    border-color: rgba(19, 53, 123, 0.6) rgba(19, 53, 123, 0.6) rgba(19, 53, 123, 0.6) rgba(19, 53, 123, 0.6);
    visibility: visible;
}

.packages .packages-item .packages-img small,
.packages .packages-item .packages-img small i {
    transition: 0.5s;
}

.packages .packages-item .packages-img:hover small,
.packages .packages-item .packages-img:hover small i {
    color: var(--bs-white) !important;

}

.packages .packages-item .packages-img img {
    transition: 0.5s;
}

.packages .packages-item .packages-img:hover img {
    transform: scale(1.3);
}

.packages .packages-item .packages-img .packages-price {
    position: absolute;
    width: 100px; 
    top: 0; 
    left: 50%; 
    transform: translateX(-50%);
    display: inline-block;
    background: var(--bs-primary);
    color: var(--bs-white);
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 10px; 
    z-index: 5;
}

.packages .packages-carousel {
    position: relative;
}

.packages .packages-carousel .owl-nav .owl-prev {
    position: absolute;
    top: -50px;
    left: 0;
    padding: 5px 30px;
    border: 1px solid var(--bs-primary);
    border-radius: 30px;
    transition: 0.5s;
}

.packages .packages-carousel .owl-nav .owl-next {
    position: absolute;
    top: -50px;
    right: 0;
    padding: 5px 30px;
    border: 1px solid var(--bs-primary);
    border-radius: 30px;
    transition: 0.5s;
}

.packages .packages-carousel .owl-nav .owl-prev i,
.packages .packages-carousel .owl-nav .owl-next i {
    color: var(--bs-primary);
    font-size: 17px;
    transition: 0.5s;
}

.packages .packages-carousel .owl-nav .owl-prev:hover,
.packages .packages-carousel .owl-nav .owl-next:hover {
    background: var(--bs-primary);
}

.packages .packages-carousel .owl-nav .owl-prev:hover i,
.packages .packages-carousel .owl-nav .owl-next:hover i {
    color: var(--bs-white);
}
.modal-body .marathonInfo td{
	height: 40px;
}
.searchArea {
	position:relative;
	align-self:center;
	height:60px;	
}
.searchArea > input{
	box-sizing: border-box;
	position:relative;
	transform:translateX(-200px);
	left:50%;
	width: 450px;
    height: 51px;
    padding: 5px 8px 0px 14px;
    border-radius: 22px;
    border:2px solid #464646;
    padding-left: 50px;
    padding-right: 50px;
    margin: 0 auto;
    
}
.searchArea > span{
	box-sizing: border-box;
	position:absolute;
	margin: auto;
	margin-top:10px;
	
}
.searchText >p span{
	color:red;
	font-weight: 300;
}
   </style>             
</head>
<body>
<%@include file="/WEB-INF/views/common/menubar.jsp"%>
<div class="container-fluid packages py-5">
	<div class="searchArea">			
		<input type="search" name="searchName" id="searchName">
		<span onclick="selectSearch();" cursor="pointer";>
        	<svg xmlns="http://www.w3.org/2000/svg" width="33" height="33" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  			<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/></svg>
		</span>
		<br>
		<div class="searchText" align="center";>
			<p>test</p>			
		</div>
    </div>
    <div class="container py-5">        
        <div class="packages-carousel owl-carousel" data-packages-carousel-autoplay-status="Y">
            <c:choose>
				<c:when test="${empty marathonArr }">
					조회된 마라톤이 없습니다.
					</c:when>
					<c:otherwise>
					<c:forEach var="mar" items="${marathonArr}">
						<div class="packages-item">
                	<div class="packages-img" onclick="window.open('${mar.marathonSite }')">
                    	<c:choose>
                		<c:when test="${mar.imageNo>107 }">
                			<img src="resources/marathon/img/500x400.png" class="img-fluid w-100 rounded-top" style="width:400px;height:300px;">
                		</c:when>
                		<c:otherwise>
                			<img src="resources/marathon/img/${mar.imageNo }.jpg" class="img-fluid w-100 rounded-top" style="width:400px;height:300px;">
                		</c:otherwise>
                		</c:choose>
                    <div class="packages-info d-flex border border-start-0 border-end-0 position-absolute" style="width: 100%; bottom: 0; left: 0; z-index: 5;">
                        <small class="flex-fill text-center border-end py-2"><i class="fa fa-map-marker-alt me-2"></i>${mar.region }</small>
                        <small class="flex-fill text-center border-end py-2"><i class="fa fa-calendar-alt me-2"></i>${fn:substring(mar.marathonDate,0,fn:indexOf(mar.marathonDate,' '))}</small>
                        <small class="flex-fill text-center py-2"><i class="fa fa-user me-2"></i>${mar.organizer }</small>
                    </div>
                	</div>
                	<div class="packages-content bg-light">
	                    <div class="p-4 pb-0">
	                        <h5 class="mb-0" style="height:68px">${mar.marathonName }</h5>
	                        <small class="text-uppercase">대회번호<span>${mar.marathonNo }</span></small>
	                        <p class="mb-4">상세정보</p>
	                        <p class="mb-4" style="height:48px">${fn:substring(mar.otherIntroduction,0,50)}</p>
	                    </div>
	                    <div class="row bg-primary rounded-bottom mx-0">
	                        <div class="col-6 text-start px-0">
	                            <a onclick="checkParticipate(this);" class="btn-hover btn text-white py-2 px-4">참가신청</a>
	                        </div>
	                        <div class="col-6 text-end px-0">
	                            <a href="${contextPath }/detail.ma?marathonNo=${mar.marathonNo }" target="_blank" class="btn-hover btn text-white py-2 px-4">더보기</a>
	                        </div>
	                    </div>
                	</div>
            	</div>
					</c:forEach>	
				</c:otherwise>
			</c:choose>
        </div>
        <br>
        <button type="button" id="carouselplaybtn" class="btn btn-outline-primary" style="float: right; display: none;">시작</button>
        <button type="button" id="carouselstopbtn" class="btn btn-outline-primary" style="float: right;">중지</button>
        <div>           
            <button type="button" id="btn-infor" class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">전체 대회정보</button>
            <!-- modal영역 -->
            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-lg">
                  <div class="modal-content">
                    <div class="modal-header">                    
                      <h5 class="modal-title" id="staticBackdropLabel">전체 대회정보</h5>                      
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                    <table class="marathonclass" style="font-size: 12px">
                    <thead align="center">
						<tr>
							<th width="7%">번호</th>
							<th width="33%">마라톤 이름</th>
							<th width="33%">마라톤 장소</th>
							<th width="8%">지역</th>
							<th width="19%">마라톤 날짜</th>
						</tr>
					</thead>
					<tbody align="center">
                      <c:choose>
						<c:when test="${empty marathonArr }">
						<tr>
							<td colspan="5">조회된 마라톤이 없습니다.</td>
						</tr>
						</c:when>
						<c:otherwise>
						<c:forEach var="mar" items="${marathonArr}">
							<tr class="marathonInfo" onclick='window.open("${contextPath }/detail.ma?marathonNo=${mar.marathonNo }")'>
								<td>${mar.marathonNo}</td>
								<td>${mar.marathonName}</td>
								<td>${mar.location }</td>
								<td>${mar.region }</td>
								<td>${mar.marathonDate }</td>
							</tr>
						</c:forEach>	
					</c:otherwise>
					</c:choose>
					</tbody>
					</table>					
                    </div>
                    <!-- 관리자전용 기능 -->
                    <div class="adminMenu">
                    	<c:if test="${loginUser.memberId eq 'admin'}">
                    <br>
                    <p> * 관리자용 메뉴</p>                   
                    		<button onclick='location.href="${contextPath }/insert.ma"' class="btn btn-outline-primary">대회정보 초기화</button>                    		
                    		<button onclick='checkRestore();' class="btn btn-outline-primary">대회정보 복구</button>
                    	</c:if>
					</div>
					<div class="modal-footer">
                      <button type="button" class="btn btn-outline-primary" data-bs-dismiss="modal">종료</button>
                    </div>
                  </div>
                </div>
            </div>
            <!-- 여기까지 modal -->
        </div>
    </div>
</div>
</body>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" >
<link href="https://fonts.googleapis.com/css2?family=Jost:wght@500;600&family=Roboto&display=swap" rel="stylesheet"> 
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
<link href="resources/marathon/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
<link href="resources/marathon/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/marathon/css/style.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="resources/marathon/lib/waypoints/waypoints.min.js"></script>
<script src="resources/marathon/lib/owlcarousel/owl.carousel.min.js"></script>
<script type="text/javascript">
function checkParticipate(e){
	if('${loginUser.memberNo}'==""){
		if(confirm("로그인이 필요한 서비스입니다. 로그인페이지로 이동하시겠습니까?")){
			location.href="${contextPath}/login.me"
		}
	}else{		
		location.href="${contextPath}/insert.pa?marathonNo="+$(e).closest('.packages-content').find('span').text()+"&memberNo=${loginUser.memberNo}"	
	}
}
function checkRestore(){
	if(confirm("복구 페이지로 이동하시겠어요?")){
		location.href="${contextPath }/restore.ma"
	}
}
function selectSearch(){
	var searchName = $("#searchName").val()
	console.log(searchName);
	location.href="${contextPath }/search.ma?searchName="+searchName;
}
$(function(){;
	$(".searchText").children().html("<span>\"${searchName}\"</span>"+" 검색어로 "+"<span>${contentCount}</span>"+" 개의 대회정보가 검색되었습니다.");
});

(function ($) {
    function Carousel1__onTranslated() {
        $(".packages-carousel").trigger('play.owl.autoplay');
        
        $(".packages-carousel").attr('data-packages-carousel-autoplay-status', 'Y');
    }
    "use strict";
    $(".packages-carousel").owlCarousel({
        autoplay: true,
        autoplayTimeout:2000,        
        center: false,
        dots: true,
        loop: false,
        margin: 25,
        nav : true,
        navText : [
            '<i class="bi bi-arrow-left"></i>',
            '<i class="bi bi-arrow-right"></i>'
        ],
        responsiveClass: true,        
        responsive: {
            items:3,
            autoplayHoverPause:false,
            onTranslated: Carousel1__onTranslated,
        }
    });
 
    $('#carouselplaybtn').on('click',function(){
        $(".packages-carousel").trigger('play.owl.autoplay');
    
        $(".packages-carousel").attr('data-packages-carousel-autoplay-status', 'Y');
        alert("스와이프가 실행되었습니다.");
        $("#carouselstopbtn").css("display","");
        $("#carouselplaybtn").css("display","none");
    });

    $('#carouselstopbtn').on('click',function(){
        $(".packages-carousel").trigger('stop.owl.autoplay');
    
        $(".packages-carousel").attr('data-packages-carousel-autoplay-status', 'N');
        alert("스와이프가 중지되었습니다.");
        $("#carouselplaybtn").css("display","");
        $("#carouselstopbtn").css("display","none");
    });
})(jQuery);

</script>
</html>