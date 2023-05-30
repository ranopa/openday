<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/user/classEnrollment.css" />'rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src='<c:url value="/resources/js/user/classEnrollment.js" />'></script>

<link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor.css" />
<script	src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.48.4/codemirror.min.css"/>

<!-- 일단 임시로 넣어줌 아이콘 문제임 -->
<link rel="shortcut icon" href="#">
</head>

<body>
	<div id="includeWrapper">
	<div id="includeHeader" class="includeHeader">
		<%@ include file="../header.jsp"%>
	</div>
	<div id="div1">
	<form id="form" action="classEnrollment" method="post">
		<h3>클래스 개설</h3>
		<div id=opendiv1>
			
			<div class="opendiv2">
				<span class="span">클래스 이름</span> ${claName }
			</div>

			<div class="opendiv2">
				<span class="span">클래스 카테고리</span><br><br>
				<div class=catediv>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<input type="radio"id="category1" name="clsCode" ><label for="category1">가죽</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category2" name="clsCode"><label for="category2">금속/악세사리</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category3" name="clsCode"><label for="category3">도자기</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category4" name="clsCode"><label for="category4">라탄/마크라메</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category5" name="clsCode"><label for="category5">목공</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category6" name="clsCode"><label for="category6">미술</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category7" name="clsCode"><label for="category7">뷰티/미용</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category8" name="clsCode"><label for="category8">애견</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category9" name="clsCode"><label for="category9">유리</label>
				<br><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category10" name="clsCode"><label for="category10">음악</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category11" name="clsCode"><label for="category11">자수</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category12" name="clsCode"><label for="category12">조향/캔들/방향제</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category13" name="clsCode"><label for="category13">취미</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category14" name="clsCode"><label for="category14">쿠킹</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category15" name="clsCode"><label for="category15">키즈</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category16" name="clsCode"><label for="category16">플라워/벌룬</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category17" name="clsCode"><label for="category17">핸드메이드</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category18" name="clsCode"><label for="category17">기타</label>
				<br><br>
				</div>
			</div>

			<div class="opendiv2">
				<span class="span">클래스 소개글</span> 
				${clsDescription }
			</div>

			<div id="divdouble">
				<div>
					<p>클래스 썸네일 설정</p>
					<div class="thumbnail-container" id="thumbnail-container">
						<input type="file" name="filName" class="file-input" id="thumbnail-input"onchange="readURL(this);"> <img id="preview" />
					</div>
				</div>

				<div>
					<p>강사, 강의 경력</p>
					<textarea placeholder="내용을 입력해 주세요" name="clsCarrer"></textarea>
				</div>
			</div>

			<div id=curri class="opendiv2">
				<p>커리큘럼 작성</p>
				<div id="editor" name="clsCurri"></div>
			</div>

			<div class="opendiv2">
				<p id="detailP">클래스 세부 설정</p>

				<table class="detailT">
					<tr>
						<td class="detailtd">
							<p id="cal">
							<table class="Calendar">
								&nbsp;&nbsp;일자 설정
								<thead>
									<tr>
										<td onClick="prevCalendar();" style="cursor: pointer;">&#60;</td>
										<td colspan="5"><span id="calYear"></span>년 
										<span id="calMonth"></span>월</td>
										<td onClick="nextCalendar();" style="cursor: pointer;">&#62;</td>
									</tr>
									<tr>
										<td>일</td>
										<td>월</td>
										<td>화</td>
										<td>수</td>
										<td>목</td>
										<td>금</td>
										<td>토</td>
									</tr>
								</thead>

								<tbody>
								</tbody>
							</table>
							</p>
						</td>

						<td class="detailtd" id="detailtd">
							<p>수강료(인당)</p> 
							<p><input type="text" name="scdPrice"> 원</input><p>
							<br>
							<p>클래스 운영시간</p> 
							<p><input type="time"> - <input type="time"></p>
							<br>
							<p>클래스 소요시간	</p> 
							<p>
							<input type="number" name="" id="hour" min="0" max="23" required><label for="hour"> 시</label>&nbsp;&nbsp;
   							<input type="number" id="minute" min="0" max="59" required><label for="minute"> 분</label>
   							</p>
   							<br>
   							<p>수강 인원 수<p>
   							<span>최소 <input id="nubmer" style="width:40px;" type="number" min="0"> 명 &nbsp;&nbsp; 최대 <input id="nubmer" style="width:40px;" type="number" min="0"> 명<span>
						</td>


						<td class="detailtd">
							장소 설정
							<div>
							지역
							<select id="select">
										<option>선택</option>
										<option>서울</option>
										<option>경기</option>
										<option>부산</option>
										<option>인천</option>
										<option>대전</option>
										<option>대구</option>
										<option>광주</option>
										<option>경북</option>
										<option>경남/울산</option>
										<option>전북</option>
										<option>전남</option>
										<option>충북</option>
										<option>충남</option>
										<option>세종</option>
										<option>강원</option>
										<option>제주</option>										
							</select>
							</div>
							<div>
							주소 검색 : 
							<input type="text" name="scdLoc" id="address" placeholder="도로명 주소를 입력해주세요">
							<button type="button" id="searchBtn">검색</button>		
							</div>
							<div>
							상세 주소 : 
							<input type="text" name="scdLocDetial" placeholder="상세 주소를 입력해주세요">
							</div>	
	
							<div id="map"></div> 
							<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f123941dd9e33a2fc56e4cff04c0f675&libraries=services"></script>
							<script>
							var mapContainer = document.getElementById('map'); // 지도를 표시할 div
							var mapOption = {
								center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
								level: 3 // 지도의 확대 레벨
							};

							// 지도를 생성합니다
							var map = new kakao.maps.Map(mapContainer, mapOption);

							// 마커 변수를 선언합니다
							var marker = null;

							// 인포윈도우 변수를 선언합니다
							var infowindow = null;

							// 버튼을 클릭했을 때
							$('#searchBtn').click(function () {

								// 주소-좌표 변환 객체를 생성합니다
								var geocoder = new kakao.maps.services.Geocoder();

								// 주소로 좌표를 검색합니다
								geocoder.addressSearch($('#address').val(), function (result, status) {

									// 정상적으로 검색이 완료됐으면
									if (status === kakao.maps.services.Status.OK) {
										var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

										// 추출한 좌표를 통해 도로명 주소 추출
										let lat = result[0].y;
										let lng = result[0].x;
										getAddr(lat, lng);

										function getAddr(lat, lng) {
											let geocoder = new kakao.maps.services.Geocoder();
											let coord = new kakao.maps.LatLng(lat, lng);
											let callback = function (result, status) {
												if (status === kakao.maps.services.Status.OK) {
													// 추출한 도로명 주소를 해당 input의 value값으로 적용
													$('#address').val(result[0].road_address.address_name);
												}
											};
											geocoder.coord2Address(coord.getLng(), coord.getLat(), callback);
										}

										// 이전에 생성된 마커가 있다면 제거합니다
										if (marker !== null) {
											marker.setMap(null);
										}

										// 이전에 생성된 인포윈도우가 있다면 제거합니다
										if (infowindow !== null) {
											infowindow.close();
										}

										// 결과값으로 받은 위치를 마커로 표시합니다
										marker = new kakao.maps.Marker({
											map: map,
											position: coords
										});

										// 인포윈도우로 장소에 대한 설명을 표시합니다
										infowindow = new kakao.maps.InfoWindow({
											content: '<div style="width:150px;text-align:center;padding:6px 0;">클래스장소</div>'
										});
										infowindow.open(map, marker);

										// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
										map.setCenter(coords);
									}
								});
							});
							</script>
					
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="btns">
		<button type="button" class="cancel-btn" onClick="window.location.reload()">초기화</button>
      <button type="button" class="cancel-btn">취소</button>
      <button type="submit" class="submit-btn">클래스 개설</button>
	</div>
		</form>
	</div>
	<div id="includeFooter" class="includeFooter">
			<%@ include file="../footer.jsp"%>
	</div>
	</div>	
</body>
</html>