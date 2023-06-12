<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link href='<c:url value="/resources/css/adm/announcementList.css" />'rel="stylesheet">
<script src='<c:url value="/resources/js/announcement/announcementList.js" />'></script>

<!-- 일단 임시로 넣어줌 아이콘 문제임 -->
<link rel="shortcut icon" href="#">

<!-- 제이쿼리 문제 -->
<script type="text/javascript">
	$.noConflict();
</script>
</head>
<div id="includeWrapper">
<%@ include file="../header.jsp"%>
	<body>
		<div id="noticeWrapper">
			<a href="announcementList" class="atag">공지사항</a> 
			<a href="inquiry" class="atag">문의하기</a> 
			<a href="inquiryList" class="atag">문의내역</a> 
			<br><br><br>
			<table>
				<thead>
				<tr>
					<th class="smallth">번호</th>
					<th id="largeth">제목</th>
					<th>분류</th>
					<th>조회수</th>
					<th>작성날짜</th>
				</tr>
				</thead>
				<tbody>
				 <c:forEach var="ancList" items="${ancList}">
				<tr>
					<td class="smallth"><a href="announcementDetail?ancId=${ancList.ancId}" class="alist">${ancList.ancId }</a></td>
					<td id="largeth"><a href="announcementDetail?ancId=${ancList.ancId}" class="alist">${ancList.ancTitle}</a> </td>
					<td><a href="announcementDetail?ancId=${ancList.ancId}" class="alist">${ancList.ancType }</a></td>
					<td><a href="announcementDetail?ancId=${ancList.ancId}" class="alist">${ancList.ancViewcount }</a></td>
					<td><a href="announcementDetail?ancId=${ancList.ancId}" class="alist">${ancList.ancUploadDate }</a></td>
				</tr>
				</c:forEach>
				</tbody>
			</table>
			<div id="pagination"  style="text-align: center; text-decoration: none; margin-top:50px;"></div>
		</div>
	</body>
</div>
<script>
$(document).ready(function() {
    var $table = $("table");
    var $tbody = $table.find("tbody");
    var rowsPerPage = 10; // 페이지당 행 수
    var currentPage = 1; // 현재 페이지

    // 테이블의 행 수 계산
    var totalRows = $tbody.find("tr").length;
    var totalPages = Math.ceil(totalRows / rowsPerPage); // 전체 페이지 수

    // 페이지 버튼 생성
    function createPaginationButtons() {
        var $pagination = $("#pagination");
        $pagination.empty();

        // 이전 페이지로 가는 버튼
        if (currentPage > 1) {
            $pagination.append('<a href="#" class="prev" style="text-decoration-line: none; color:black;"><</a>');
        } else {
            $pagination.append('<span class="disabled"><</span>');
        }

        // 페이지 버튼 생성
        var startRow = (currentPage - 1) * rowsPerPage;
        var endRow = startRow + rowsPerPage - 1;
        $tbody.find("tr").hide().slice(startRow, endRow + 1).show();

        // 현재 페이지 범위 계산
        var startPage = Math.floor((currentPage - 1) / 10) * 10 + 1;
        var endPage = startPage + 9;
        if (endPage > totalPages) {
            endPage = totalPages;
        }
        for (var i = startPage; i <= endPage; i++) {
            var $pageButton = $('<a href="#" class="page" style="margin:25px; font-size:20px; text-decoration-line: none; color:black;">' + i + "</a>");
            if (i === currentPage) {
                $pageButton.addClass("active");
                $pageButton.css("text-decoration", "underline"); // 현재 페이지에 밑줄 추가
            }
            $pagination.append($pageButton);
        }

        // 다음 페이지로 가는 버튼
        if (currentPage < totalPages) {
            $pagination.append('<a href="#" class="next" style="text-decoration-line: none; color:black;">></a>');
        } else {
            $pagination.append('<span class="disabled">></span>');
        }

        // 다음 10단위 버튼을 생성
        var next10Button = $('<a href="#" class="next-10" style="text-decoration-line: none; color:black;  margin-left:15px;">>></a>');
        $pagination.append(next10Button);

        // 이전 10단위 버튼을 생성
        var prev10Button = $('<a href="#" class="prev-10" style="text-decoration-line: none; color:black; margin-right:15px;"><<</a>');
        $pagination.prepend(prev10Button);

        // 페이지 상태 저장
        savePageState();
    }

    // 페이지 이동 처리
    function goToPage(page) {
        if (page < 1 || page > totalPages || page === currentPage) {
            return;
        }

        // 현재 페이지 갱신
        currentPage = page;
        createPaginationButtons();
    }

    // 브라우저 뒤로 가기 이벤트 처리
    window.addEventListener('popstate', function(event) {
        var state = event.state;
        if (state && state.currentPage) {
            currentPage = state.currentPage;
            createPaginationButtons();
        }
    });

    // 페이지 이동 시 상태 저장
    function savePageState() {
        var state = {
            currentPage: currentPage
        };
        history.pushState(state, '', '');
    }

    // 행 클릭 시 페이지 이동
    $tbody.on("click", "tr", function() {
        var page = Math.ceil(($tbody.find("tr").index(this) + 1) / rowsPerPage);
        goToPage(page);
    });

    // 이전 페이지로 가는 버튼 클릭 시 이벤트 처리
    $("#pagination").on("click", ".prev", function() {
        goToPage(currentPage - 1);
    });

    // 다음 페이지로 가는 버튼 클릭 시 이벤트 처리
    $("#pagination").on("click", ".next", function() {
        goToPage(currentPage + 1);
    });

    // 이전 10단위 버튼 클릭 시 이벤트 처리
    $("#pagination").on("click", ".prev-10", function() {
        goToPage(Math.max(currentPage - 10, 1));
    });

    // 다음 10단위 버튼 클릭 시 이벤트 처리
    $("#pagination").on("click", ".next-10", function() {
        goToPage(Math.min(currentPage + 10, totalPages));
    });

    // 페이지 버튼 클릭 시 이벤트 처리
    $("#pagination").on("click", ".page", function() {
        var page = parseInt($(this).text());
        goToPage(page);
    });

    // 초기 페이지 버튼 생성
    createPaginationButtons();
});
</script>
	<%@ include file="../footer.jsp"%>
</html>