$(document).ready(function () {
	$("#datepicker1").datepicker({
	    	language: 'ko'
	    });
    $("#datepicker2").datepicker({
    	language: 'ko'
    }); 
    datePickerSet($("#datepicker1"), $("#datepicker2"), true); //다중은 시작하는 달력 먼저, 끝달력 2번째

    /*
        * 달력 생성기
        * @param sDate 파라미터만 넣으면 1개짜리 달력 생성
        * @example   datePickerSet($("#datepicker"));
        * 
        * 
        * @param sDate, 
        * @param eDate 2개 넣으면 연결달력 생성되어 서로의 날짜를 넘어가지 않음
        * @example   datePickerSet($("#datepicker1"), $("#datepicker2"));
        */
    function datePickerSet(sDate, eDate, flag) {

        //시작 ~ 종료 2개 짜리 달력 datepicker	
        if (!isValidStr(sDate) && !isValidStr(eDate) && sDate.length > 0 && eDate.length > 0) {
            var sDay = sDate.val();
            var eDay = eDate.val();

            if (flag && !isValidStr(sDay) && !isValidStr(eDay)) { //처음 입력 날짜 설정, update...			
                var sdp = sDate.datepicker().data("datepicker");
                sdp.selectDate(new Date(sDay.replace(/-/g, "/")));  //익스에서는 그냥 new Date하면 -을 인식못함 replace필요

                var edp = eDate.datepicker().data("datepicker");
                edp.selectDate(new Date(eDay.replace(/-/g, "/")));  //익스에서는 그냥 new Date하면 -을 인식못함 replace필요
            }

            //시작일자 세팅하기 날짜가 없는경우엔 제한을 걸지 않음
            if (!isValidStr(eDay)) {
                sDate.datepicker({
                    maxDate: new Date(eDay.replace(/-/g, "/"))
                });
            }
            sDate.datepicker({
                language: 'ko',
                autoClose: true,
                onSelect: function () {
                    datePickerSet(sDate, eDate);
                }
            });

            //종료일자 세팅하기 날짜가 없는경우엔 제한을 걸지 않음
            if (!isValidStr(sDay)) {
                eDate.datepicker({
                    minDate: new Date(sDay.replace(/-/g, "/"))
                });
            }
            eDate.datepicker({
                language: 'ko',
                autoClose: true,
                onSelect: function () {
                    datePickerSet(sDate, eDate);
                }
            });

            //한개짜리 달력 datepicker
        } else if (!isValidStr(sDate)) {
            var sDay = sDate.val();
            if (flag && !isValidStr(sDay)) { //처음 입력 날짜 설정, update...			
                var sdp = sDate.datepicker().data("datepicker");
                sdp.selectDate(new Date(sDay.replace(/-/g, "/"))); //익스에서는 그냥 new Date하면 -을 인식못함 replace필요
            }

            sDate.datepicker({
                language: 'ko',
                autoClose: true
            });
        }


        function isValidStr(str) {
            if (str == null || str == undefined || str == "")
                return true;
            else
                return false;
        }
    }
});
function dateFunc(obj) {
		let datepicker1 = document.getElementById("datepicker1");
		let datepicker2 = document.getElementById("datepicker2");

		let today = new Date();
		let year = today.getFullYear(); // 년도
		let month = today.getMonth() + 1; // 월
		let date = today.getDate(); // 날짜

		if (month < 10) {
			month = "0" + month;
		}
		if (date < 10) {
			date = "0" + date;
		}

		if (obj.name == "date_range_All") {
			datepicker1.value = "";
			datepicker2.value = "";

		} else if (obj.name == "date_range_Now") {
			datepicker1.value = year + '-' + month + '-' + date;
			datepicker2.value = year + '-' + month + '-' + date;
		} else if (obj.name == "date_range_1Mon") {
			const newDate = new Date(year, month - 1, date);
			let nyear = newDate.getFullYear();
			let nmonth = newDate.getMonth();
			let ndate = newDate.getDate();
			let lastDayofLastMonth = ( new Date( year, month - 6, 0) ).getDate();
			if(ndate > lastDayofLastMonth) {
			    ndate = lastDayofLastMonth;
			}
			if (nmonth < 10) {
				nmonth = "0" + nmonth;
			}
			datepicker1.value = nyear + '-' + nmonth + '-' + ndate;
			datepicker2.value = year + '-' + month + '-' + date;
		} else if (obj.name == "date_range_6Mon") {
			const newDate = new Date(year, month - 6, date);
			let nyear = newDate.getFullYear();
			let nmonth = newDate.getMonth();
			let ndate = newDate.getDate();
			let lastDayofLastMonth = ( new Date( year, month - 6, 0) ).getDate();
			if(ndate > lastDayofLastMonth) {
			    ndate = lastDayofLastMonth;
			}
			if (nmonth < 10) {
				nmonth = "0" + nmonth;
			}
			datepicker1.value = nyear + '-' + nmonth + '-' + ndate;
			datepicker2.value = year + '-' + month + '-' + date;
		} else if (obj.name == "date_range_1Year") {
			datepicker1.value = year - 1 + '-' + month + '-' + date;
			datepicker2.value = year + '-' + month + '-' + date;
		}
	}
function resetBtn() {
	document.getElementById("datepicker1").value = null;
	document.getElementById("datepicker2").value = null;
	document.getElementById("clsStatus").value = "";
	document.getElementById("keyword").value = null;
}