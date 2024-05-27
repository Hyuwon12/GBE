<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.marathonInfo td{
	height: 40px;
}
tbody tr{
	border-bottom: 1px solid #999;
}
tbody tr:hover{
	border: 3px solid red;
	cursor:pointer;
}

</style>
</head>
<body>
	<%@include file="/views/common/menubar.jsp"%>
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
						<td colspan="5">조회된 게시글이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="mar" items="${marathonArr}">
						<tr class="marathonInfo" onclick='restoreMarathon(this);'>
							<td class="mno">${mar.marathonNo}</td>
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
</body>
<script type="text/javascript">
	function restoreMarathon(e){		
		if(confirm("해당 마라톤을 복구하시겠습니까?")){
			 let form = document.createElement('form');
			 form.setAttribute('method', 'post');
			 form.setAttribute('action', '${contextPath }/restore.ma?marathonNo='+$(e).children().first().text());
			 document.body.appendChild(form);
			 form.submit();
		}
	}
</script>
</html>