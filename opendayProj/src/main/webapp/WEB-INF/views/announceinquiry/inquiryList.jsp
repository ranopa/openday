<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/resources/css/adm/inquiryList.css" />' rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src='<c:url value="/resources/js/announcement/inquiryList.js" />'></script>
<!-- 일단 임시로 넣어줌 아이콘 문제임 -->
<link rel="shortcut icon" href="#">
<!-- 제이쿼리 문제 -->
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
                        <th>작성자</th>
                        <th>답변</th>
                        <th>작성날짜</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="inquiry" items="${ilist}">
                        <tr>
                            <td class="smallth"><a href="inquiryDetail?admNum=${inquiry.admNum}">${inquiry.admNum }</a></td>
                            <td id="largeth"><a href="inquiryDetail?admNum=${inquiry.admNum}">${inquiry.admTitle }</a></td>
                            <td><a href="inquiryDetail?admNum=${inquiry.admNum}">${inquiry.userId }</a></td>
                            <td><a href="inquiryDetail?admNum=${inquiry.admNum}">${inquiry.admStatus }</a></td>
                            <td><a href="inquiryDetail?admNum=${inquiry.admNum}">${inquiry.admUploadDate }</a></td>
                            <td>
                                <c:if test="${not empty sessionScope.userId and sessionScope.userId.userId eq inquiry.userId}">
                                    <a href="inquiryDelete?admNum=${inquiry.admNum }">삭제</a>
                                </c:if>
                            </td>
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
    	      var $pageButton = $('<a href="#" class="page" style="margin:30px; font-size:20px; text-decoration-line: none; color:black;">' + i + "</a>");
    	      if (i === currentPage) {
    	        $pageButton.addClass("active");
    	      }
    	      $pagination.append($pageButton);
    	    }

    	    // 다음 페이지로 가는 버튼
    	    if (currentPage < totalPages) {
    	      $pagination.append('<a href="#" class="next" style="text-decoration-line: none; color:black;">></a>');
    	    } else {
    	    	 $pagination.append('<span class="disabled">></span>');
    	    }
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

    	  // 페이지 버튼 클릭 처리
    	  $("#pagination").on("click", ".page", function() {
    	    var page = parseInt($(this).text());
    	    goToPage(page);
    	  });

    	  // 이전 페이지로 가는 버튼 클릭 처리
    	  $("#pagination").on("click", ".prev", function() {
    	    goToPage(currentPage - 1);
    	  });

    	  // 다음 페이지로 가는 버튼 클릭 처리
    	  $("#pagination").on("click", ".next", function() {
    	    goToPage(currentPage + 1);
    	  });

    	  // 초기 페이지 버튼 생성
    	  createPaginationButtons();
    	});
    </script>
<%@ include file="../footer.jsp"%>
</html>
