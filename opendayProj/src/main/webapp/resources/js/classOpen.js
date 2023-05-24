// 썸네일
function readURL(input) {
  if (input.files && input.files[0]) {
    var reader = new FileReader();
    reader.onload = function(e) {
      document.getElementById('preview').src = "<c:url value='/resources/image/${file.fileId}' />";
    };
    reader.readAsDataURL(input.files[0]);
  } else {
    document.getElementById('preview').src = "";
  }
}

// 토스트 ui
document.addEventListener("DOMContentLoaded", function() {
   const Editor = toastui.Editor; 
   const editor = new Editor({
        el: document.querySelector('#editor'),
        previewStyle: 'vertical',
        initialEditType: 'wysiwyg',
    });
 
});
        
// 캘린더 api
 window.onload = function () { buildCalendar(); }    // 웹 페이지가 로드되면 buildCalendar 실행

    let nowMonth = new Date();  // 현재 달을 페이지를 로드한 날의 달로 초기화
    let today = new Date();     // 페이지를 로드한 날짜를 저장
    today.setHours(0, 0, 0, 0);    // 비교 편의를 위해 today의 시간을 초기화

    let selectedDates = [];  // 선택된 날짜를 저장할 배열

    // 달력 생성 : 해당 달에 맞춰 테이블을 만들고, 날짜를 채워 넣는다.
    function buildCalendar() {

        let firstDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth(), 1);     // 이번달 1일
        let lastDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth() + 1, 0);  // 이번달 마지막날

        let tbody_Calendar = document.querySelector(".Calendar > tbody");
        document.getElementById("calYear").innerText = nowMonth.getFullYear();             // 연도 숫자 갱신
        document.getElementById("calMonth").innerText = leftPad(nowMonth.getMonth() + 1);  // 월 숫자 갱신

        while (tbody_Calendar.rows.length > 0) {                        // 이전 출력결과가 남아있는 경우 초기화
            tbody_Calendar.deleteRow(tbody_Calendar.rows.length - 1);
        }

        let nowRow = tbody_Calendar.insertRow();        // 첫번째 행 추가           

        for (let j = 0; j < firstDate.getDay(); j++) {  // 이번달 1일의 요일만큼
            let nowColumn = nowRow.insertCell();        // 열 추가
        }

        for (let nowDay = firstDate; nowDay <= lastDate; nowDay.setDate(nowDay.getDate() + 1)) {   // day는 날짜를 저장하는 변수, 이번달 마지막날까지 증가시키며 반복  

            let nowColumn = nowRow.insertCell();        // 새 열을 추가하고


            let newDIV = document.createElement("p");
            newDIV.innerHTML = leftPad(nowDay.getDate());        // 추가한 열에 날짜 입력
            nowColumn.appendChild(newDIV);

            if (nowDay.getDay() == 6) {                 // 토요일인 경우
                nowRow = tbody_Calendar.insertRow();    // 새로운 행 추가
            }

            if (nowDay < today) {                       // 지난날인 경우
                newDIV.className = "pastDay";
            }
            else if (nowDay.getFullYear() == today.getFullYear() && nowDay.getMonth() == today.getMonth() && nowDay.getDate() == today.getDate()) { // 오늘인 경우           
                newDIV.className = "today";
                newDIV.onclick = function () { choiceDate(this); }
            }
            else {                                      // 미래인 경우
                newDIV.className = "futureDay";
                newDIV.onclick = function () { choiceDate(this); }
            }

            if (selectedDates.includes(nowDay.getTime())) {  // 선택된 날짜인 경우
                newDIV.classList.add("choiceDay");
            }
        }
    }

    // 날짜 선택
    function choiceDate(newDIV) {
        let selectedDate = new Date(nowMonth.getFullYear(), nowMonth.getMonth(), parseInt(newDIV.innerHTML));
        let selectedTime = selectedDate.getTime();

        if (selectedDates.includes(selectedTime)) {  // 이미 선택된 날짜인 경우
            selectedDates = selectedDates.filter(date => date !== selectedTime);  // 선택된 날짜 배열에서 제거
            newDIV.classList.remove("choiceDay");  // 선택된 날짜의 "choiceDay" class 제거
        } else {  // 새로운 날짜를 선택한 경우
            selectedDates.push(selectedTime);  // 선택된 날짜 배열에 추가
            newDIV.classList.add("choiceDay");  // 선택된 날짜에 "choiceDay" class 추가
        }
    }
    
    
    // 이전달 버튼 클릭
    function prevCalendar() {
        nowMonth = new Date(nowMonth.getFullYear(), nowMonth.getMonth() - 1, nowMonth.getDate());   // 현재 달을 1 감소
        buildCalendar();    // 달력 다시 생성
    }
    // 다음달 버튼 클릭
    function nextCalendar() {
        nowMonth = new Date(nowMonth.getFullYear(), nowMonth.getMonth() + 1, nowMonth.getDate());   // 현재 달을 1 증가
        buildCalendar();    // 달력 다시 생성
    }

    // input값이 한자리 숫자인 경우 앞에 '0' 붙혀주는 함수
    function leftPad(value) {
        if (value < 10) {
            value = "0" + value;
            return value;
        }
        return value;
    }

        
        
        
        
        
     