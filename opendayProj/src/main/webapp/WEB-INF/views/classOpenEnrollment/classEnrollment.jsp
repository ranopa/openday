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

<!-- 캘린더 css, js  -->
<link href='<c:url value="/resources/lib/main.min.css" />'rel="stylesheet">
<script src='<c:url value="/resources/lib/main.js" />'></script>
</head>

<body>
	<div id="includeWrapper">
		<%@ include file="../header.jsp"%>
	<div id="div1">
	<form id="form" action="classEnrollment" method="post" enctype="multipart/form-data">
		<input type="hidden" id="" name="clsId" value="${scheduleDeatil.clsId }" />
		<h3>클래스 개설</h3>
		<div id=opendiv1>
			<div class="opendiv2">
				<span class="span">클래스 이름</span>
				<input type="text" id="clsName" name="clsName" value="${scheduleDeatil.clsName }"/>
			</div>

			<div class="opendiv2">
				<span class="span">클래스 카테고리</span><br><br>
				<div class=catediv>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<input type="radio" id="category1" name="clsCode" value="C1" ${scheduleDeatil.clsCode eq 'C1' ? 'checked' : ''}><label for="category1">가죽</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category2" name="clsCode" value="C2" ${scheduleDeatil.clsCode eq 'C2' ? 'checked' : ''}><label for="category2">금속/악세사리</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category3" name="clsCode" value="C3" ${scheduleDeatil.clsCode eq 'C3' ? 'checked' : ''}><label for="category3">도자기</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category4" name="clsCode" value="C4" ${scheduleDeatil.clsCode eq 'C4' ? 'checked' : ''}><label for="category4">라탄/마크라메</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category5" name="clsCode" value="C5" ${scheduleDeatil.clsCode eq 'C5' ? 'checked' : ''}><label for="category5">목공</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category6" name="clsCode" value="C6" ${scheduleDeatil.clsCode eq 'C6' ? 'checked' : ''}><label for="category6">미술</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category7" name="clsCode" value="C7" ${scheduleDeatil.clsCode eq 'C7' ? 'checked' : ''}><label for="category7">뷰티/미용</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category8" name="clsCode" value="C8" ${scheduleDeatil.clsCode eq 'C8' ? 'checked' : ''}><label for="category8">애견</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category9" name="clsCode" value="C9" ${scheduleDeatil.clsCode eq 'C9' ? 'checked' : ''}><label for="category9">유리</label>
				<br><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category10" name="clsCode" value="C10" ${scheduleDeatil.clsCode eq 'C10' ? 'checked' : ''}><label for="category10">음악</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category11" name="clsCode" value="C11" ${scheduleDeatil.clsCode eq 'C11' ? 'checked' : ''}><label for="category11">자수</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category12" name="clsCode" value="C12" ${scheduleDeatil.clsCode eq 'C12' ? 'checked' : ''}><label for="category12">조향/캔들/방향제</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category13" name="clsCode" value="C13" ${scheduleDeatil.clsCode eq 'C13' ? 'checked' : ''}><label for="category13">취미</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category14" name="clsCode" value="C14" ${scheduleDeatil.clsCode eq 'C14' ? 'checked' : ''}><label for="category14">쿠킹</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category15" name="clsCode" value="C15" ${scheduleDeatil.clsCode eq 'C15' ? 'checked' : ''}><label for="category15">키즈</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category16" name="clsCode" value="C16" ${scheduleDeatil.clsCode eq 'C16' ? 'checked' : ''}><label for="category16">플라워/벌룬</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category17" name="clsCode" value="C17" ${scheduleDeatil.clsCode eq 'C17' ? 'checked' : ''}><label for="category17">핸드메이드</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="category18" name="clsCode" value="C18" ${scheduleDeatil.clsCode eq 'C18' ? 'checked' : ''}><label for="category18">기타</label>
				<br><br>
				</div>
			</div>

			<div class="opendiv2">
				<span class="span">클래스 소개글</span>
				<input type="text" name="clsDescription" id="clsDescription" value="${scheduleDeatil.clsDescription }" autofocus maxlength="200"> 
			</div>

			<div id="divdouble">
				<div>
					<p style="font-size:18px;">클래스 썸네일 설정</p>
					<div class="thumbnail-container">
						<img class="thumbnail-container" src="./image/${scheduleDeatil.filNum }" id="preview" />
						<input type="file" name="filNum" value="" class="file-input" id="thumbnail-input" onchange="readURL(this);"> 
					</div>
				</div>

				<div>
					<p style="font-size:18px;">강사, 강의 경력</p>
					<textarea placeholder="내용을 입력해 주세요" name="clsCarrer">${scheduleDeatil.clsDescription }</textarea>
				</div>
			</div>

			<div id=curri class="opendiv2">
				<p style="font-size:18px;">커리큘럼 작성</p>
				<div id="editor" name="clsCurri">${scheduleDeatil.clsCurri}</div>
			</div>

			<div class="opendiv2">
				<table class="detailT">
					<tr>
						<td class="detailtd" id="detailtd">
						  	<p id="detailP">클래스 세부 설정</p><br><br>
							<p>수강료(인당)</p> 
							<p>
							<input type="text" id="clsPrice" name="clsPrice" value="${scheduleDeatil.clsPrice }" min="0" required autofocus>원</input>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							할인률 : &nbsp;<input type="number" id="clsDiscount" name="clsDiscount" value="${scheduleDeatil.clsDiscount }" min="0" max="100" autofocus>%
							<p>
							<br>
							<p>클래스 소요시간	</p> 
							<p>
   							<input type="number" id="minute" name="scdRunTime" value="${scheduleDeatil.scdRunTime }" min="0" class="detailI" required><label for="minute"> &nbsp;분</label>
   							</p>
   							<br>
   							<p>수강 인원 수<p>
   							<br>
   							<span>
   							최소 &nbsp;&nbsp;<input id="nubmer" name="scdMinPersonnel" value="${scheduleDeatil.scdMinPersonnel }" style="width:40px;" class="detailI" type="number" min="0"> 명 &nbsp;&nbsp; 
   							최대 &nbsp;&nbsp;<input id="nubmer" name="scdMaxPersonnel" value="${scheduleDeatil.scdMaxPersonnel }" style="width:40px;" class="detailI" type="number" min="0"> 명
   							</span>
						</td>


						<td class="detailtd">
							<p id="detailtdP">장소 설정
							<select id="select" name="scdLoc">
										<option>선택</option>
										<option ${scheduleDeatil.clsLoc eq '서울' ? 'selected' : ''}>서울</option>
										<option ${scheduleDeatil.clsLoc eq '경기' ? 'selected' : ''}>경기</option>
										<option ${scheduleDeatil.clsLoc eq '부산' ? 'selected' : ''}>부산</option>
										<option ${scheduleDeatil.clsLoc eq '인천' ? 'selected' : ''}>인천</option>
										<option ${scheduleDeatil.clsLoc eq '대전' ? 'selected' : ''}>대전</option>
										<option ${scheduleDeatil.clsLoc eq '대구' ? 'selected' : ''}>대구</option>
										<option ${scheduleDeatil.clsLoc eq '광주' ? 'selected' : ''}>광주</option>
										<option ${scheduleDeatil.clsLoc eq '경북' ? 'selected' : ''}>경북</option>
										<option ${scheduleDeatil.clsLoc eq '경남/울산' ? 'selected' : ''}>경남/울산</option>
										<option ${scheduleDeatil.clsLoc eq '전북' ? 'selected' : ''}>전북</option>
										<option ${scheduleDeatil.clsLoc eq '전남' ? 'selected' : ''}>전남</option>
										<option ${scheduleDeatil.clsLoc eq '충북' ? 'selected' : ''}>충북</option>
										<option ${scheduleDeatil.clsLoc eq '충남' ? 'selected' : ''}>충남</option>
										<option ${scheduleDeatil.clsLoc eq '세종' ? 'selected' : ''}>세종</option>
										<option ${scheduleDeatil.clsLoc eq '강원' ? 'selected' : ''}>강원</option>
										<option ${scheduleDeatil.clsLoc eq '제주' ? 'selected' : ''}>제주</option>										
							</select>
							</p>
							<div>
							주소 검색 : 
							<input type="text" class="map-input" id="sample5_address" name="scdPlace" value="${scheduleDeatil.scdPlace }" placeholder="검색을 클릭해주세요">
							<input type="button" id="map-input" onclick="sample5_execDaumPostcode()" value="검색"><br>
							</div>
							<div>
							상세 주소 : 
							<input type="text" class="map-input" name="scdPlaceDetail" value="${scheduleDeatil.scdPlaceDetail }" placeholder="상세 주소를 입력해주세요">
							</div>	
	
							<div id="map"></div>
							<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> 
							<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f123941dd9e33a2fc56e4cff04c0f675&libraries=services"></script>
							<script>
							    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
							        mapOption = {
							            center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
							            level: 5 // 지도의 확대 레벨
							        };
							
							    //지도를 미리 생성
							    var map = new daum.maps.Map(mapContainer, mapOption);
							    //주소-좌표 변환 객체를 생성
							    var geocoder = new daum.maps.services.Geocoder();
							    //마커를 미리 생성
							    var marker = new daum.maps.Marker({
							        position: new daum.maps.LatLng(37.537187, 127.005476),
							        map: map,
							        draggable: true // 마커를 드래그 가능하도록 설정
							    });
							
							    // 초기에 지도를 보이도록 설정
							    mapContainer.style.display = "block";
							    map.relayout();
							
							    // 마커 드래그가 끝난 후 이벤트 처리
							    daum.maps.event.addListener(marker, 'dragend', function() {
							        var position = marker.getPosition(); // 마커의 현재 위치를 가져옴
							
							        // 좌표를 주소로 변환
							        geocoder.coord2Address(position.getLng(), position.getLat(), function(result, status) {
							            if (status === daum.maps.services.Status.OK) {
							                var addr = result[0].address.address_name; // 주소 변수
							
							                // 주소 정보를 해당 필드에 넣는다.
							                document.getElementById("sample5_address").value = addr;
							            } else {
							                document.getElementById("sample5_address").value = "주소를 찾을 수 없습니다.";
							            }
							        });
							    });
							
							    function sample5_execDaumPostcode() {
							        new daum.Postcode({
							            oncomplete: function(data) {
							                var addr = data.address; // 최종 주소 변수
							
							                // 주소 정보를 해당 필드에 넣는다.
							                document.getElementById("sample5_address").value = addr;
							                // 주소로 상세 정보를 검색
							                geocoder.addressSearch(data.address, function(results, status) {
							                    // 정상적으로 검색이 완료됐으면
							                    if (status === daum.maps.services.Status.OK) {
							
							                        var result = results[0]; //첫번째 결과의 값을 활용
							
							                        // 해당 주소에 대한 좌표를 받아서
							                        var coords = new daum.maps.LatLng(result.y, result.x);
							                        // 지도를 보여준다.
							                        mapContainer.style.display = "block";
							                        map.relayout();
							                        // 지도 중심을 변경한다.
							                        map.setCenter(coords);
							                        // 마커를 결과값으로 받은 위치로 옮긴다.
							                        marker.setPosition(coords);
							                    } else {
							                        document.getElementById("sample5_address").value = "주소를 찾을 수 없습니다.";
							                    }
							                });
							            }
							        }).open();
							    }
							    
							 // 값이 주소값으로 주어질 변수
							    var addressValue = "${scheduleDeatil.scdPlace}";

							    // 주어진 주소값으로 좌표를 검색하고, 지도에 표시한다.
							    geocoder.addressSearch(addressValue, function(results, status) {
							        // 정상적으로 검색이 완료됐으면
							        if (status === daum.maps.services.Status.OK) {

							            var result = results[0]; //첫번째 결과의 값을 활용

							            // 해당 주소에 대한 좌표를 받아서
							            var coords = new daum.maps.LatLng(result.y, result.x);
							            // 지도를 보여준다.
							            mapContainer.style.display = "block";
							            map.relayout();
							            // 지도 중심을 변경한다.
							            map.setCenter(coords);
							            // 마커를 결과값으로 받은 위치로 옮긴다.
							            marker.setPosition(coords);
							        } else {
							            document.getElementById("sample5_address").value = "주소를 찾을 수 없습니다.";
							        }
							    });
							</script> 
						</td>
					</tr>	
					<tr>
						<td id='cal' colspan="2">
							<p id="calP">클래스 일정 설정</p>
							<div id='calendar'></div>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="btns">
		<button type="button" class="cancel-btn" onClick="window.location.reload()">초기화</button>
      <button type="button" class="cancel-btn">취소</button>
      <button type="submit" class="submit-btn">클래스 등록</button>
	</div>
	</form>
	</div>
<%@ include file="../footer.jsp"%>
</body>
</html>