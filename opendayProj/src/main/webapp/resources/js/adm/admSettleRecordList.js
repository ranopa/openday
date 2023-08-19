 window.onload = () => {
        var today = new Date();
        var oneMonthAgo = new Date();
        oneMonthAgo.setMonth(oneMonthAgo.getMonth() - 1);
        $("#datepicker1").datepicker({
            defaultDate: oneMonthAgo,
            dateFormat: "yy-mm-dd",

        });
        $("#datepicker2").datepicker({
            defaultDate: today,
            dateFormat: "yy-mm-dd"

        });



        document.getElementById('datepicker1').placeholder = getDate1();
        $(".ui-datepicker-default").addClass("custom-style");
        document.getElementById('datepicker2').placeholder = getDate2();
    };

    function getDate2() {
        var today = new Date();
        var day = String(today.getDate()).padStart(2, '0');
        var month = String(today.getMonth() + 1).padStart(2, '0');
        var year = today.getFullYear();
        return year + '-' + month + '-' + day;
    }
    function getDate1() {
        var today = new Date();
        var oneMonthAgo = new Date();
        oneMonthAgo.setMonth(oneMonthAgo.getMonth() - 1);
        var day = String(oneMonthAgo.getDate()).padStart(2, '0');
        var month = String(oneMonthAgo.getMonth() + 1).padStart(2, '0');
        var year = oneMonthAgo.getFullYear();
        return year + '-' + month + '-' + day;
    }
 