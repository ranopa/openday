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
<body>
    <div id="includeWrapper">
        <div id="includeHeader" class="includeHeader">
            <%@ include file="../header.jsp"%>
        </div>
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
            <div id="pagination"></div>
        </div>
        <script type="text/javascript">
            $.noConflict();
            $(document).ready(function() {
                // 페이지당 행 개수와 초기 페이지 설정
                var rowsPerPage = 10;
                var currentPage = 1;

                // 테이블 행 숨기기 함수
                function hideTableRows() {
                    $("table tbody tr").hide(); // 모든 행 숨기기
                    // 현재 페이지에 해당하는 행 보이기
                    var startIndex = (currentPage - 1) * rowsPerPage;
                    var endIndex = Math.min(startIndex + rowsPerPage, $("table tbody tr").length); // 행 개수보다 클 경우 보정
                    $("table tbody tr").slice(startIndex, endIndex).show();
                }

                // 페이지네이션 버튼 생성 함수
                function createPaginationButtons() {
                    var rowCount = $("table tbody tr").length;
                    var pageCount = Math.ceil(rowCount / rowsPerPage);

                    // 이전 페이지로 이동하는 버튼
                    var prevButton = $("<button>")
                        .text("이전 페이지")
                        .click(function() {
                            if (currentPage > 1) {
                                currentPage--;
                                hideTableRows();
                                updatePaginationButtons();
                            }
                        });

                    // 다음 페이지로 이동하는 버튼
                    var nextButton = $("<button>")
                        .text("다음 페이지")
                        .click(function() {
                            if (currentPage < pageCount) {
                                currentPage++;
                                hideTableRows();
                                updatePaginationButtons();
                            }
                        });

                    // 버튼 추가
                    $("#pagination").append(prevButton);
                    $("#pagination").append(nextButton);

                    // 10단위로 이동하는 버튼
                    function updatePaginationButtons() {
                        $("#pagination").empty();

                        // 이전 10단위 페이지로 이동하는 버튼
                        var prevTenButton = $("<button>")
                            .text("이전 " + ((currentPage - 1) / 10 * 10) + " - " + ((currentPage - 1) / 10 * 10 + 9))
                            .click(function() {
                                if (currentPage > 10) {
                                    currentPage -= 10;
                                } else {
                                    currentPage = 1;
                                }
                                hideTableRows();
                                updatePaginationButtons();
                            });

                        // 다음 10단위 페이지로 이동하는 버튼
                        var nextTenButton = $("<button>")
                            .text("다음 " + ((currentPage - 1) / 10 * 10 + 11) + " - " + ((currentPage - 1) / 10 * 10 + 20))
                            .click(function() {
                                if (currentPage + 10 <= pageCount) {
                                    currentPage += 10;
                                } else {
                                    currentPage = pageCount;
                                }
                                hideTableRows();
                                updatePaginationButtons();
                            });

                        // 버튼 추가
                        $("#pagination").append(prevTenButton);

                        // 번호가 있는 버튼 페이지
                        for (var i = Math.max(1, currentPage - 10); i <= Math.min(currentPage + 9, pageCount); i++) {
                            var pageButton = $("<button>")
                                .text(i)
                                .click((function(page) {
                                    return function() {
                                        currentPage = page;
                                        hideTableRows();
                                        updatePaginationButtons();
                                    };
                                })(i));

                            if (i === currentPage) {
                                pageButton.addClass("active");
                            }

                            $("#pagination").append(pageButton);
                        }

                        $("#pagination").append(nextTenButton);
                    }

                    // 초기화
                    hideTableRows();
                    updatePaginationButtons();
                }
                createPaginationButtons();
            });
        </script>
        <div id="includeFooter" class="includeFooter">
            <%@ include file="../footer.jsp"%>
        </div>
    </div>
</body>
</html>
