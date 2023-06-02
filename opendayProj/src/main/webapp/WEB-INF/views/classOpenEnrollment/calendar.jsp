<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
html, body {
  margin: 0;
  padding: 0;
  font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
  font-size: 14px;
}

#calendar {
  max-width: 1100px;
  margin: 40px auto;
}
</style>

<link href='<c:url value="/resources/css/user/calendar.css" />'rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src='<c:url value="/resources/js/user/calendar.js" />'></script>


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.css">

<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.js"></script>

<script>
document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	
	var calendar = new FullCalendar.Calendar(calendarEl, {
		initialView : 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
		headerToolbar : { // 헤더에 표시할 툴 바
			start : 'prev next today',
			center : 'title',
			end : 'dayGridMonth,dayGridWeek,dayGridDay'
		},
		titleFormat : function(date) {
			return date.date.year + '년 ' + (parseInt(date.date.month) + 1) + '월';
		},
		//initialDate: '2021-07-15', // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)
		selectable : true, // 달력 일자 드래그 설정가능
		droppable : true,
		editable : true,
		nowIndicator: true, // 현재 시간 마크
		navLinks: true,
		//날짜클릭
		navLinkDayClick: function(date, jsEvent) {
		// 뭐가 나옴
    	console.log('day', date.toISOString());
    	console.log('coords', jsEvent.pageX, jsEvent.pageY);
  },
  // 특정 이벤트	드래그해서 일정 넣음	
  selectable: true,
  selectMirror: true,
  select: function(arg) {
    var title = prompt('Event Title:');
    if (title) {
      calendar.addEvent({
        title: title,
        start: arg.start,
        end: arg.end,
        allDay: arg.allDay
      })
    }
    calendar.unselect()
  },
  // 일정 취소 기능
  eventClick: function(arg) {
      if (confirm('Are you sure you want to delete this event?')) {
        arg.event.remove()
      }
    },
    editable: true,
    dayMaxEvents: true, // allow "more" link when too many events
    
    
		locale: 'ko' // 한국어 설정
		
		
		
		
		

	});
	calendar.render();
});



</script>

</head>
<body>
<div id='calendar'></div>
</body>
</html>

