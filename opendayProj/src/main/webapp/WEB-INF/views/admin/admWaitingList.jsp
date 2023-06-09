<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<div id="waiting">
        <div class="w-container">
            <h2>개설신청 목록</h2>
            <table class="table" >
                <thead>
                    <tr class="th-color">
                        <th class="td1">NO</th>
                        <th class="td2">클래스명</th>
                        <th class="td3">카테고리</th>
                        <th class="td4">신청자</th>
                        <th class="td5">등록일</th>
                    </tr>
                </thead>
                <tbody>  
                <c:forEach items="${list}" var="oclass">
                    <tr>
                        <td class="td1" >${oclass.clsId}</td>
                        <td class="td2"> <a href="#" class="a-box"><p class="ellipsis">${oclass.clsName}</p></a></td>
                        <td class="td3">카테고리명</td>
                        <td class="td4">${oclass.userId}</td>
                        <td class="td5">${oclass.clsCreatedAt}</td>
                    </tr>  
                  </c:forEach>
                </tbody>
            </table>
        </div>
    </div>