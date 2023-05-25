
$(function() {
	$.datepicker.setDefaults({

		closeText : "닫기",
		currentText : "오늘",
		prevText : '이전 달',
		nextText : '다음 달',
		monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
				'9월', '10월', '11월', '12월' ],
		monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
				'9월', '10월', '11월', '12월' ],
		dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
		weekHeader : "주",
		yearSuffix : '년',
		showMonthAfterYear : true,
	});

	$("#datepicker").datepicker({
		beforeShowDay : function(date) {
			var currentDate = new Date();
			currentDate.setHours(0, 0, 0, 0); // 오늘 날짜의 시간을 00:00:00으로 설정
			if (date < currentDate) {
				return [ true, "past-date", "과거 날짜" ];
			}
			return [ true, "", "" ];
		}
	});
});