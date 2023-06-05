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

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>


<link href='<c:url value="/resources/lib/main.min.css" />'rel="stylesheet">
<script src='<c:url value="/resources/lib/main.js" />'></script>
 
<script>
document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      initialView : 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
	  locale: 'ko', // 한국어 설정
	  navLinks: true, // 날짜 선택
      selectable: true,
      selectMirror: true,
      select: function(info) {
          var title = prompt('일정 입력:');          
          if (title) {
            calendar.addEvent({
              title: title,
              start: info.startStr,
              end: info.endStr,
              allDay: info.allDay
            })
          }
          calendar.unselect()
        },
        eventClick: function(info) {
        	/*   
            if (confirm('Are you sure you want to delete this event?')) {
              arg.event.remove()
            }
             */
        	var eventElement = info.el;

            // 기존의 삭제 버튼 제거
            var deleteButton = eventElement.querySelector('.delete-button');
            if (deleteButton) {
              deleteButton.remove();
            }

            var deleteButton = document.createElement('button');
            deleteButton.innerText = '삭제';
            deleteButton.classList.add('delete-button');
            deleteButton.addEventListener('click', function() {
              if (confirm('정말로 이 일정을 삭제하시겠습니까?')) {
                info.event.remove();
              }
            });
            eventElement.appendChild(deleteButton);

            var action = prompt('일정 수정:', info.event.title);
            if (action) {
              info.event.setProp('title', action);
              calendar.updateEvent(info.event);
            }
          },
        editable: true,
      
     /*  dateClick: function(info) {
        alert('clicked ' + info.dateStr);
      },
      select: function(info) {
        alert('selected ' + info.startStr + ' to ' + info.endStr);
      } */
      
    });
    calendar.render();
  });

</script>

</head>
<body>
<div id='calendar'></div>
</body>
</html>

