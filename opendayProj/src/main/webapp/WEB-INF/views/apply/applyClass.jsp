<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="<%=request.getContextPath() %>" />

<c:import url="/WEB-INF/views/header.jsp" />
<html>
<head>
	<link rel="stylesheet" href="${contextPath}/resources/css/user/applyClass.css">
	<script src="${contextPath }/resources/js/user/applyClass.js"></script>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	


<c:if test="${data.schedules ne null and data.schedules.size() > 0}">

<script>
let availableDays = [];
let availableDateTimes = [];
<c:forEach var="s" items="${data.schedules}">
	availableDays.push("${s.scdDate}");
	availableDateTimes.push({
		date: "${s.scdDate}",
		time: "${s.scdTime}",
		timeAndPlace: "[${s.scdTime}] ${s.scdPlace} (${s.scdLoc})",
		num: "${s.scdNum}"
	});
</c:forEach>

availableDateTimes.sort((s1, s2) => (s1.time > s2.time) ? 1 : -1)

function textToDateStr(dateText) {
	let date = new Date(dateText);
	
	let offset = date.getTimezoneOffset() * 60000; //ms단위라 60000곱해줌
	let selectedDate = new Date(date.getTime() - offset);
	const selectedDateStr = selectedDate.toISOString().substr(0,10);
	
    return selectedDateStr;
}

$(function() {
	let lastSelectedDateTime = {date: "", time: ""};
	$("#datepicker").datepicker({
		beforeShowDay : function(date) {
			var currentDate = new Date();
			currentDate.setHours(0, 0, 0, 0); // 오늘 날짜의 시간을 00:00:00으로 설정
			if (date < currentDate) {
				return [ true, "past-date", "과거 날짜" ];
			}
			date = $.datepicker.formatDate('yy-mm-dd', date);
			if (availableDays.includes(date)) {
	        	return [true, "available"];
	    	} 
			return [ true, "", "" ];
		},
        onSelect: function(dateText, inst) {
        	const selectTime = $("#selectTime");
        	selectTime.empty();
        	selectTime.append("<option>-- 시간을 선택하세요 --</option>");
        	const selectDate = textToDateStr(dateText);
        	
        	if (availableDays.includes(selectDate)) {
        		lastSelectedDateTime.date = selectDate;
        		
        		$.each(availableDateTimes, function (i, item) {
        			if (item.date == lastSelectedDateTime.date) {
        				selectTime.append($('<option>', { 
        				        value: item.time,
        				        num: item.num,
        				        text : item.timeAndPlace
        				 }));	
        			}
        		});
        	} else {
        		$(".ui-datepicker-current-day").css("background-color", "");
        		lastSelectedDateTime.date = "";
        	}
        	
        	if (lastSelectedDateTime.date == "") {
        		$("#requestDateSelection").show();
        	} else {
        		$("#requestDateSelection").hide();
        	}
        },
	});
	$(".ui-datepicker-current-day").removeClass("ui-datepicker-current-day");
	
	$("#btn-proceed-payment").on("click", function(){
		const scdNum = $("#selectTime option:selected").attr("num");
		$("#scdNum").val(scdNum);
		$("#clsId").val(${data.clsId});
	});
})
	
 </script>
</c:if>
</head>
<body>

	<div class="wrapper">
	<form action="paymentProcess" method="POST">

		<input type="hidden" id="clsId" name="clsId" />
		<input type="hidden" id="scdNum" name="scdNum" />
		
		<div class="header-title">클래스 신청</div>
		<div class="container">
		
			<div class="box">
				<div class="class-image-card">
					<img src="resources/image/teacher/cat.jpg" width="100%" height="350px" style="object-fit:fill;"/>
				</div>
				<div class="class-detail">
					<h4>${data.clsName }</h4>

					<div class="detail-bottom">
						<span>${data.codName }</span>
						<span>${data.clsPrice }</span>
					</div>
				</div>

			</div>
			<div class="box">
				<div class="apply-date-calendar">
					날짜 선택 - 캘린더
					<div class="class-calendar">
						<div id="datepicker"></div>
					</div>

				</div>
				<div id="requestDateSelection">날짜를 선택하세요</div>
				
				<div class="apply-date-hour">
					<p>시간 선택 - 드롭다운</p>

					<select id="selectTime" name="selectTime">
						<option value="none">-- 시간을 선택하세요 --</option>
					</select>
				</div>
			</div>
			<div class="box">
				<div class="apply-people-count">
					<span>신청 인원 수</span>
					<input type="number" name="applyPersonnel" min="1" max="100" value="1" />
				</div>
			</div>
			<div class="box">
				<div class="btn-wrapper">
					<button class="btn-next" type="submit" id="btn-proceed-payment">다음으로</button>
				</div>
			</div>
			
		</div>
		</form>	
	</div>
</body>
</html>
