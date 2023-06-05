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
                        	<a href="javascript:void(0)" class="r-link">
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
           <!-- <div id="record-box" class="re-box"> 
                <table class="oclassTable">
                    <tr class=tableTr>
                        <td class="oclass"><a href="javascript:void(0)" class="r-link">
                                <img src="img/${list.filNum}" class="h-ssum-img">  
                                <div class="h-ssum-img"></div>
                                <div class="txt-box">
                                    <div class="t1">
                                        <p>2021-03-05</p>
                                        <p class="record-badge">수강완료</p>
                                    </div>
                                    <p class="cls-name">chat GPT 강의</p>

                                    <div class="tb2">
                                        <span class="oriPrice">결제금액&nbsp;&nbsp;</span>
                                        <span class="fp price">300000원</span>
                                    </div>
                                </div>
                            </a></td>
                    </tr>
                </table>
            </div>
            <div id="re-cancel-box" class="re-box"> 
                <table class="oclassTable">
                    <tr class=tableTr>
                        <td class="oclass">
                            <a href="javascript:void(0)" class="r-link">
                                <img src="img/${list.filNum}" class="h-ssum-img">  
                                <div class="h-ssum-img"></div>
                                <div class="txt-box">
                                    <div class="t1">
                                        <p>2021-03-05</p>
                                        <p class="cancel-badge">취소</p>
                                    </div>
                                    <p class="cls-name"><strike>GPT 강의</strike> </p>

                                    <div class="tb2">
                                        <span class="oriPrice">환불금액&nbsp;&nbsp;</span>
                                        <span class="fp price">300000원</span>
                                    </div>
                                </div>
                            </a>
                        </td>
                        <td class="oclass">
                            <a href="javascript:void(0)" class="r-link">
                                <img src="img/${list.filNum}" class="h-ssum-img">  
                                <div class="h-ssum-img"></div>
                                <div class="txt-box">
                                    <div class="t1">
                                        <p>2021-03-05</p>
                                        <p class="cancel-badge">취소</p>
                                    </div>
                                    <p class="cls-name"><strike>GPT 강의</strike> </p>

                                    <div class="tb2">
                                        <span class="oriPrice">환불금액&nbsp;&nbsp;</span>
                                        <span class="fp price">300000원</span>
                                    </div>
                                </div>
                            </a>
                        </td>
                        <td class="oclass">
                            <a href="javascript:void(0)" class="r-link">
                                <img src="img/${list.filNum}" class="h-ssum-img">  
                                <div class="h-ssum-img"></div>
                                <div class="txt-box">
                                    <div class="t1">
                                        <p>2021-03-05</p>
                                        <p class="cancel-badge">취소</p>
                                    </div>
                                    <p class="cls-name"><strike>GPT 강의</strike> </p>

                                    <div class="tb2">
                                        <span class="oriPrice">환불금액&nbsp;&nbsp;</span>
                                        <span class="fp price">300000원</span>
                                    </div>
                                </div>
                            </a>
                        </td>
                        <td class="oclass">
                            <a href="javascript:void(0)" class="r-link">
                                <img src="img/${list.filNum}" class="h-ssum-img">  
                                <div class="h-ssum-img"></div>
                                <div class="txt-box">
                                    <div class="t1">
                                        <p>2021-03-05</p>
                                        <p class="cancel-badge">취소</p>
                                    </div>
                                    <p class="cls-name"><strike>GPT 강의</strike> </p>

                                    <div class="tb2">
                                        <span class="oriPrice">환불금액&nbsp;&nbsp;</span>
                                        <span class="fp price">300000원</span>
                                    </div>
                                </div>
                            </a>
                        </td>
                    </tr>
                    <tr class=tableTr>
                        <td class="oclass">
                            <a href="javascript:void(0)" class="r-link">
                                <img src="img/${list.filNum}" class="h-ssum-img">  
                                <div class="h-ssum-img"></div>
                                <div class="txt-box">
                                    <div class="t1">
                                        <p>2021-03-05</p>
                                        <p class="cancel-badge">취소</p>
                                    </div>
                                    <p class="cls-name"><strike>GPT 강의</strike> </p>

                                    <div class="tb2">
                                        <span class="oriPrice">환불금액&nbsp;&nbsp;</span>
                                        <span class="fp price">300000원</span>
                                    </div>
                                </div>
                            </a>
                        </td>
                        <td class="oclass">
                            <a href="javascript:void(0)" class="r-link">
                                <img src="img/${list.filNum}" class="h-ssum-img">  
                                <div class="h-ssum-img"></div>
                                <div class="txt-box">
                                    <div class="t1">
                                        <p>2021-03-05</p>
                                        <p class="cancel-badge">취소</p>
                                    </div>
                                    <p class="cls-name"><strike>GPT 강의</strike> </p>

                                    <div class="tb2">
                                        <span class="oriPrice">환불금액&nbsp;&nbsp;</span>
                                        <span class="fp price">300000원</span>
                                    </div>
                                </div>
                            </a>
                        </td>
                        <td class="oclass">
                            <a href="javascript:void(0)" class="r-link">
                                <img src="img/${list.filNum}" class="h-ssum-img">  
                                <div class="h-ssum-img"></div>
                                <div class="txt-box">
                                    <div class="t1">
                                        <p>2021-03-05</p>
                                        <p class="cancel-badge">취소</p>
                                    </div>
                                    <p class="cls-name"><strike>GPT 강의</strike> </p>

                                    <div class="tb2">
                                        <span class="oriPrice">환불금액&nbsp;&nbsp;</span>
                                        <span class="fp price">300000원</span>
                                    </div>
                                </div>
                            </a>
                        </td>
                        <td class="oclass">
                            <a href="javascript:void(0)" class="r-link">
                                <img src="img/${list.filNum}" class="h-ssum-img">  
                                <div class="h-ssum-img"></div>
                                <div class="txt-box">
                                    <div class="t1">
                                        <p>2021-03-05</p>
                                        <p class="cancel-badge">취소</p>
                                    </div>
                                    <p class="cls-name"><strike>GPT 강의</strike> </p>

                                    <div class="tb2">
                                        <span class="oriPrice">환불금액&nbsp;&nbsp;</span>
                                        <span class="fp price">300000원</span>
                                    </div>
                                </div>
                            </a>
                        </td>
                    </tr>
                </table>
            </div>
 -->

            <!-- <table class="oclassTable">
				<tr class=tableTr>
					<c:forEach items="${reserveList}" var="list" varStatus="status">

						<td class="oclass"><a href="javascript:void(0)" class="r-link"> 
								<img src="img/${list.filNum}" class="h-ssum-img"> 
							 <button class="r-btn" value="${list.clsId}"><span class=" material-symbols-outlined fill icon-custom">favorite</span></button> 
								<div class="txt-box">
									<div class="tb1">
										<div class="t1">
											<span>${list.clsLoc}</span><span>|</span><span>${list.codName}</span>
										</div>
										<div class="t2">
											<span><i class="bi bi-star-fill star"></i></span><span>${list.avgStar}</span><span>(${list.reviewCount})</span>
											<span><i class="bi bi-reserve-fill reserve"></i></span><span>${list.reserveCnt}</span>
										</div>
									</div>
									<p class="cls-name">${list.clsName}</p>
									<div class="tb2">
										<span class="oriPrice"><strike>${list.clsPrice}원</strike></span>
										<div class="price">
											<span class="disc">${list.clsDiscount}%</span> <span
												class="fp">${list.finalPrice}원</span>
										</div>
									</div>
								</div>
						</a></td>
						<c:if test="${(status.count % 4 eq 0) and (status.last eq false)}">
				</tr>
				<tr>
					</c:if>
					</c:forEach>
				</tr>
			</table> -->
        </div>
    </div>
</body>
</html>


