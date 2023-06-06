// 썸네일
function readURL(input) {
  if (input.files && input.files[0]) {
    var reader = new FileReader();
    reader.onload = function(e) {
      var preview = document.getElementById('preview');
      
       $('#preview').attr('src', e.target.result);

      var image = new Image();
      image.onload = function() {
        var maxWidth = 400; // .thumbnail-container의 최대 너비
        var maxHeight = 300; // .thumbnail-container의 최대 높이

        var width = image.width;
        var height = image.height;

        var aspectRatio = width / height;

        if (aspectRatio > maxWidth / maxHeight) {
          width = maxWidth;
          height = maxWidth / aspectRatio;
        } else {
          height = maxHeight;
          width = maxHeight * aspectRatio;
        }

        preview.style.width = width + 'px';
        preview.style.height = height + 'px';

        preview.style.backgroundImage = 'url("' + reader.result + '")';
        preview.style.backgroundSize = 'cover';
        preview.style.backgroundPosition = 'center';
        preview.style.backgroundColor = 'rgba(217, 217, 217, 1)';
        
        // 이미지를 가운데로 정렬합니다.
        var marginLeft = (maxWidth - width) / 2;
        preview.style.marginLeft = marginLeft + 'px';

        // 미리보기 이미지를 정중앙에 수직 정렬합니다.
        var marginTop = (maxHeight - height) / 2;
        preview.style.marginTop = marginTop + 'px';
      };

      image.src = reader.result;
    };
    reader.readAsDataURL(input.files[0]);
  } else {
    document.getElementById('preview').style.backgroundImage = "";
  }
}

$('#thumbnail-input').change(function() {
  readURL(this);
});

// 토스트 ui
document.addEventListener("DOMContentLoaded", function() {
   const Editor = toastui.Editor; 
   const editor = new Editor({
        el: document.querySelector('#editor'),
        previewStyle: 'vertical',
        initialEditType: 'wysiwyg',
    });
 
});

	
//취소 버튼
$(function() {
	buildCalendar();
	$('#cancel-btn').click(function() {
		location.href = './';
	});
});
	
// 풀 캘린더
var calendar = null;
var initialLocaleCode = 'ko';
var localeSelectorEl = document.getElementById('locale-selector');

    $(document).ready(function (){

            var calendarEl = document.getElementById('calendar');
            calendar = new FullCalendar.Calendar(calendarEl, {
            	locale: 'ko', // 한국어 설정
                initialView: 'timeGridWeek',
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