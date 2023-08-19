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

<!-- 캘린더 css, js  -->
<link href='<c:url value="/resources/lib/main.min.css" />'rel="stylesheet">
<script src='<c:url value="/resources/lib/main.js" />'></script>
 
 
<script>
    var calendar = null;
    var initialLocaleCode = 'ko';
    var localeSelectorEl = document.getElementById('locale-selector');

        $(document).ready(function (){

                var calendarEl = document.getElementById('calendar');
                calendar = new FullCalendar.Calendar(calendarEl, {
                	locale: 'ko', // 한국어 설정
                    initialView: 'dayGridMonth',
                    headerToolbar: {
                        left: 'prev,next today',
                        center: 'title',
                        right: 'dayGridMonth,timeGridWeek,timeGridDay'
                      },
                    navLinks: true,
                    editable: true,
                    selectable: true,
                    droppable: true, // this allows things to be dropped onto the calendar

                    eventAdd: function () { // 이벤트가 추가되면 발생하는 이벤트
                        console.log()
                    },

                    select: function (arg) { // 캘린더에서 드래그로 이벤트를 생성할 수 있다.


                        var title = prompt('일정을 입력해주세요.');
                        if (title) {
                            calendar.addEvent({
                                title: title,
                                start: arg.start,
                                end: arg.end,
                                allDay: arg.allDay,
                            })
                        }
                        var allEvent = calendar.getEvents(); // .getEvents() 함수로 모든 이벤트를 Array 형식으로 가져온다. (FullCalendar 기능 참조)

                        var events = new Array(); // Json 데이터를 받기 위한 배열 선언
                        for (var i = 0; i < allEvent.length; i++) {
                            var obj = new Object();     // Json 을 담기 위해 Object 선언
                            // alert(allEvent[i]._def.title); // 이벤트 명칭 알람
                            obj.title = allEvent[i]._def.title; // 이벤트 명칭  ConsoleLog 로 확인 가능.
                            obj.start = allEvent[i]._instance.range.start; // 시작
                            obj.end = allEvent[i]._instance.range.end; // 끝

                            events.push(obj);
                        }
                        var jsondata = JSON.stringify(events);
                        console.log(jsondata); // 데이터 콘솔 확인
                        // saveData(jsondata);
                    },
                    // 삭제 기능
                    eventClick: function (info){
                        if(confirm("'"+ info.event.title +"' 일정을 삭제하시겠습니까 ?")){
                            // 확인 클릭 시
                            info.event.remove();
                        console.log(info.event);
                        var events = new Array(); // Json 데이터를 받기 위한 배열 선언
                        var obj = new Object();
                            obj.title = info.event._def.title;
                            obj.start = info.event._instance.range.start;
                            obj.end = info.event._instance.range.end;
                            events.push(obj);

                        }
                    },
                });
                calendar.render();
    });

</script>


</head>
<body>
<div id='calendar'></div>
</body>
</html>

