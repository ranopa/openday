<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <c:set var="contextPath" value="${pageContext.request.contextPath }"/> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/classOpen.css" />'
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src='<c:url value="/resources/js/classOpen.js" />'></script>

<link rel="stylesheet"
	href="https://uicdn.toast.com/editor/latest/toastui-editor.css" />

<script
	src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
	
</head>

<body>
	<%@ include file="header.jsp"%>

	<div id="div1">
		<h3>클래스 개설</h3>
		<div id=opendiv1>
			
			<div>
				<span class="span">클래스 이름</span> <input type="text" name="clsName"
					placeholder="클래스 이름을 입력해 주세요(20자 이하)" required autofocus
					maxlength="20">
			</div>

			<div>
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
				<input type="radio" id="category9" name="clsCode"><label for="category9">유리</label><br><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category10" name="clsCode"><label for="category10">음악</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category11" name="clsCode"><label for="category11">자수</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category12" name="clsCode"><label for="category12">조향/캔들/방향제</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category13" name="clsCode"><label for="category13">취미</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category14" name="clsCode"><label for="category14">쿠킹</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category15" name="clsCode"><label for="category15">키즈</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category16" name="clsCode"><label for="category16">플라워/벌룬</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category17" name="clsCode"><label for="category17">핸드메이드</label>&nbsp;&nbsp;&nbsp;&nbsp;<br><br>
				</div>
			</div>

			<div>
				<span class="span">클래스 소개글</span> 
				<input type="text"name="cls_description" id="clsDescription"placeholder="클래스 소개글을 입력해 주세요(200자 이하)" autofocus maxlength="200">
			</div>

			<form id="divdobule">
				<div>
					<p>
						<label for="content">클래스 썸네일 설정</label>
					</p>
					<div class="thumbnail-container" id="thumbnail-container">
						<input type="file" class="file-input" id="thumbnail-input"onchange="readURL(this);"> <img id="preview" />
					</div>
				</div>

				<div>
					<p>강사, 강의 경력</p>
					<textarea placeholder="내용을 입력해 주세요"></textarea>
				</div>
			</form>

			<div id=curri>
				<p>커리큘럼 작성</p>
				<div id="editor"></div>
			</div>

			<div>
				<p id="detailP">클래스 세부 설정</p>

				<table class="detailT">
					<tr>
						<td>
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

						<td>
							<p>수강료 설정</p> <input type="text">원</input>
						</td>


						<td>
							<table>
								클래스 장소 설정
								<tr>
									<td>주소 입력</td>
									<td><input type="text" name="detailAddress" id="address"></td>
									<td><button type="button" id="searchBtn">검색</button></td>
								</tr>
								<tr>
									<td>상세 주소</td>
									<td><input type="text" name="detailAddress2"></td>
									<td></td>
								</tr>
							</table>
							<div id="map"></div> <script type="text/javascript"
								src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f123941dd9e33a2fc56e4cff04c0f675&libraries=services"></script>
							<script>
								var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
								mapOption = {center : new kakao.maps.LatLng(33.450701,126.570667), // 지도의 중심좌표
									level : 3// 지도의 확대 레벨
								};

								// 지도를 생성합니다    
								var map = new kakao.maps.Map(mapContainer,mapOption);

								// 버튼을 click했을때
								$('#searchBtn').click(function() {

									// 주소-좌표 변환 객체를 생성합니다
									var geocoder = new kakao.maps.services.Geocoder();

									// 주소로 좌표를 검색합니다
									geocoder.addressSearch($('#address').val(),function(result,status) {

											// 정상적으로 검색이 완료됐으면 
											if (status === kakao.maps.services.Status.OK) {
												var coords = new kakao.maps.LatLng(
														result[0].y,
														result[0].x);

												// 추출한 좌표를 통해 도로명 주소 추출
												let lat = result[0].y;
												let lng = result[0].x;
												getAddr(lat,lng);
												function getAddr(lat,lng) {
													let geocoder = new kakao.maps.services.Geocoder();
													let coord = new kakao.maps.LatLng(lat,lng);
													let callback = function(result,status) {
														if (status === kakao.maps.services.Status.OK) {
															// 추출한 도로명 주소를 해당 input의 value값으로 적용
															$('#address').val(result[0].road_address.address_name);
														}
													}
													geocoder.coord2Address(coord.getLng(),coord.getLat(),callback);
												}

												// 결과값으로 받은 위치를 마커로 표시합니다
												var marker = new kakao.maps.Marker(
														{
															map : map,
															position : coords
														});

												// 인포윈도우로 장소에 대한 설명을 표시합니다
												var infowindow = new kakao.maps.InfoWindow(
														{content : '<div style="width:150px;text-align:center;padding:6px 0;">클래스장소</div>'});
												infowindow.open(map,marker);

												// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
												map	.setCenter(coords);
											}
										});
								});
							</script>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<button onClick="window.location.reload()">초기화</button>
		<button type="submit" id="classOpen">클래스 승인 요청</button>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>