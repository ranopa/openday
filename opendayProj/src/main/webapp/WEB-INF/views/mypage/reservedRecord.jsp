<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page import = "com.kosta.openday.user.dto.MyRecordDTO" %>
<% 
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/user/reserve.css"/>"> 
<script src='<c:url value="/resources/js/user/reserve.js"/>'></script>
</head>
<body>

 <div id="reserve"> 
        <div class="reserve-content">

            <div class="menu-text">
                <button id="reserve-btn" class="r-btn">
                    <h2 class="reserve-h2 pick">신청내역</h2>
                </button>
                <button id="record-btn" class="r-btn"> 
                    <h2 class="reserve-h2">수강내역</h2>
                </button>
                <button id="cancel-btn" class="r-btn">
                    <h2 class="reserve-h2">환불내역</h2>
                </button>
            </div>
             <div id="reserve-box" class="re-box">
                <table class="oclassTable">
                    <tr class=tableTr>
                <c:forEach items="${reservedList}" var="list" varStatus="status" >
                        <td class="oclass">
                        	<a href="classinfo/${list.clsId}" class="r-link">
                                <img src="img/${list.filNum}" class="h-ssum-img"> 
                                <div class="txt-box">
                                    <div class="t1">
                                        <p>${list.scdDate}</p>
		                                        <p class="reserve-badge">수강예정</p> 
                                     </div>
                                    <p class="cls-name">${list.clsName}</p>

                                    <div class="tb2">
                                        <span class="oriPrice">결제금액&nbsp;&nbsp;</span>
                                        <span class="fp price">${list.apFinalAmount}&nbsp;원</span>
                                    </div>
                                </div>
                            </a></td>
                            <c:if test="${(status.count % 4 eq 0) and (status.last eq false)}">
                    </tr>
					<tr>     
                            </c:if>
			               </c:forEach>
                </table> 
            </div>
          
        </div>
    </div>
</body>
</html>


