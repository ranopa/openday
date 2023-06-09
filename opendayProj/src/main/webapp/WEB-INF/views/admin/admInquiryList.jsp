<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <div id="adm-imquiry">
        <div class="s-container">
            <h2>문의 목록</h2>
            <table class="table">
                <thead>
                    <tr class="th-color">
                        <th class="td1">NO</th>
                        <th class="td2">분류</th>
                        <th class="td3">아이디</th>
                        <th class="td4">제목</th>
                        <th class="td5">등록일</th>
                        <th class="td6">답변일</th>
                        <th class="td7">상태</th>

                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${inquiryList} var="inquiry">
                    <tr>
                        <td class="td1">${inquiry.admNum}</td>
                        <td class="td2">${inquiry.admType}</td>
                        <td class="td3">${inquiry.userId}</td>
                        <td class="td4"><a href=""><p class="ellipsis">${inquiry.admTitle}</p></a></td>
                        <td class="td5">${inquiry.admUploadDate}</td>
                        <c:choose>
                        <c:when test="${inquiry.admAnDate ne null}">
                        <td class="td6">${inquiry.admAnDate}</td>
                        </c:when> 
                        <c:otherwise>
                        <td class="td6">-</td>
                        </c:otherwise>
                        
                        </c:choose>
                        <td class="td7 "><p class="waiting clear">${inquiry.admStatus}</p></td>
                    </tr>                   
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>