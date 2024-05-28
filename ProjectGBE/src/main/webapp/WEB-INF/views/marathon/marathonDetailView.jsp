<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
</style>
</head>
<body>
<%@include file="/WEB-INF/views/common/menubar.jsp"%>
<div class="head">
	<h1>대회정보</h1>
</div>
<br>
<div class="Detaildiv">
    <table class="marathonDetail table">
    <tr>
    	<th>행사명</th>
    	<td>${mar.marathonName }</td>
    </tr>
    <tr>
    	<th>지역</th>
    	<td>${mar.region }</td>
    </tr>
    <tr>
    	<th>코스 정보</th>
    	<td>${mar.marathonCourse }</td>
    </tr>
    <tr>
    	<th>마라톤 장소</th>
    	<td>${mar.location }</td>
    </tr>
    <tr>
    	<th>출발일</th>
    	<td>${mar.marathonDate }</td>
    </tr>
    <tr>
    	<th>접수기간</th>
    	<td>${mar.applicationDate }</td>
    </tr>
	<tr>
    	<th>주최자</th>
    	<td>${mar.organizer }</td>
    </tr>
    <tr>
    	<th>주최단체</th>
    	<td>${mar.organizerHost }</td>
    </tr>
    <tr>
    	<th>번호</th>
    	<td>${mar.organizerPhone }</td>
    </tr>
    <tr>
    	<th>대회 주소</th>
    	<td><a href="${mar.marathonSite }" target="_blank">${mar.marathonSite }</a></td>
    </tr>
    <tr>
    	<th style="height:250px">상세 정보</th>
    	<td>${mar.otherIntroduction }</td>
    </tr>
    <tr>
    <th style="height:400px"><a href="https://map.kakao.com/link/search/${mar.location }" target="_blank">장소 상세</a></th>
    <td>
    <div id="map" style="width:500px;height:350px;"></div>    
    </td>
    </tr>
    </table>
</div>
<!-- 관리자기능 -->
<div class="admindiv" style="margin-left:300px">
<c:if test="${loginUser.memberId eq 'admin'}">
	<button onclick='checkdelete();' class="btn btn-outline-primary">대회정보 삭제</button>
	<button onclick='location.href="${contextPath }/update.ma?marathonNo=${mar.marathonNo }"' class="btn btn-outline-primary">대회정보 변경</button>
</c:if>
</div>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop">신청자 정보</button>
<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">신청자 정보</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <table class="marathonclass" style="font-size: 12px">
                    <thead align="center">
						<tr>
							<th width="6%">번호</th>
							<th width="11%">참가자</th>
							<th width="30%">마라톤 이름</th>
							<th width="10%">코스</th>
							<th width="8%">지역</th>
							<th width="19%">마라톤 날짜</th>
							<th width="16%">전화 번호</th>
						</tr>
					</thead>
					<tbody align="center">
                      <c:choose>
						<c:when test="${empty participateList }">
						<tr>
							<td colspan="5">조회된 신청자가 없습니다.</td>
						</tr>
						</c:when>
						<c:otherwise>
						<c:forEach var="p" items="${participateList}">
							<tr class="participateInfo">
								<td>${p.getParticipateNo()}</td>
								<td>${p.getName()}</td>								
								<td>${p.getMarathonName() }</td>
								<td>${p.getParticipateCourse()}</td>
								<td>${p.getRegionName() }</td>
								<td>${p.getParticipateDate() }</td>
								<td>010-****-****</td>
							</tr>
						</c:forEach>	
					</c:otherwise>
					</c:choose>
					</tbody>
		</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a1b4846e472c7771e5d7f51cf184db58&libraries=services"></script>
<script>
function checkdelete(){
	if(confirm("정말 삭제하시겠어요?")){
		location.href="${contextPath }/delete.ma?marathonNo=${mar.marathonNo }"
	}
}
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places(); 

// 키워드로 장소를 검색합니다
ps.keywordSearch('${mar.location}', placesSearchCB); 

// 키워드 검색 완료 시 호출되는 콜백함수 입니다
function placesSearchCB (data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        var bounds = new kakao.maps.LatLngBounds();
        displayMarker(data[0]);    
        bounds.extend(new kakao.maps.LatLng(data[0].y, data[0].x));
        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
        map.setBounds(bounds);
        map.setLevel(3);
    }else{
    	// 장소 검색 실패시, alert 
    	alert("장소 검색에 실패했습니다.");
    }
}

// 지도에 마커를 표시하는 함수입니다
function displayMarker(place) {
    
    // 마커를 생성하고 지도에 표시합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: new kakao.maps.LatLng(place.y, place.x) 
    });

    // 마커에 클릭이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'click', function() {
        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
        infowindow.open(map, marker);
    });
}
	</script>
</body>
</html>
