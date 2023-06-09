<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
    window.onload=()=>{
        
        var writeBtn = document.querySelector('#adm-notice #write-btn');
             writeBtn.addEventListener('click',()=>{
      	    location.href="admnoticewrite";
      	})
                var btns = document.querySelectorAll('.btnss');
                btns.forEach(b=>{
                    b.addEventListener('click',()=>{
                        btns.forEach(bb=>{
                        if(bb.classList.contains('hover-color')){
                            bb.classList.remove('hover-color');
                        } 
                        b.classList.add('hover-color'); 
                    })
                
                    //$.ajax
                }) 
            })
        }
     </script>
<div id="adm-notice">
	<div class="container">
		<h2>공지</h2>
		<div class="btns">
			<button type="button" id="all-btn" class="btnss" value="전체">전체</button>
			<button type="button" id="tchc-btn" class="btnss" value="강사공지">강사공지</button>
			<button type="button" id="nomal-btn" class="btnss" value="일반공지">일반공지</button>
		</div>

		<table class="table">
			<thead>
				<tr class="th-color">
					<th class="td1">NO</th>
					<th class="td2">제목</th>
					<th class="td3">조회수</th>
					<th class="td4">작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ancList }" var="anc">
					<tr>
						<td class="td1">${anc.ancId }</td>
						<td class="td2"><a href="admnoticedetail/${anc.ancId }"><p class="ellipsis">${anc.ancTitle }</p></a></td>
						<td class="td3">${anc.ancViewcount }</td>
						<td class="td4">${anc.ancUploadDate }</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		<div class="write-box">
		<button type="button" id="write-btn" class="write-btn">공지작성</button> 
			<script>
				var btn = document.querySelector('#write-btn');
				btn.addEventListener('click',()=>{
					location.href="admannouncementwriteform";
				})
			</script>
		</div>
	</div>
</div>