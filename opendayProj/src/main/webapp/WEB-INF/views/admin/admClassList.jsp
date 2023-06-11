<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="cls-list">
	<div class="sr-container">
		<h2>전체 클래스 목록</h2>
		<form action="" method="get">
			<div class="search-box">
				<diV class="search1">
					<p class="s-p">강사/클래스명 조회</p>
					<input type="text" class="ip-box ipt" name="searchText"
						placeholder="강사명/클래스명">
					<button type="submit" class="sub-btn">
						<span class="material-symbols-outlined"> search </span>
					</button>
				</diV>
		</form>

	</div>
	<table class="table">
		<thead>
			<tr class="th-color">
				<th class="td1">NO</th>
				<th class="td2">클래스명</th>
				<th class="td3">카테고리</th>
				<th class="td4">강사명</th>
				<th class="td5">연락처</th>
				<th class="td6">등록일</th>
				<th class="td7">자세히</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="cas"> 
				<tr>
					<td class="td1">${cas.clsId }</td>
					<td class="td2">
						<p class="ellipsis">${cas.clsName}</p>
					</td>
					<td class="td3">${cas.clsCode}</td>
					<td class="td4">${cas.teacherId}</td>
					<td class="td5">${cas.teacherTel}</td>
					<td class="td6">${cas.clsCreatedAt}</td>
					<td class="td7">
						<button type="button" id="detail-btn" class="detail-btn">
							<span class="material-symbols-outlined icon2">
								expand_more
							</span>
						</button>
					</td>
				</tr>
				<tr class="sub-toggle">
					<td>
						<ul class="sub-table">
							<ul class="sub-ul ul1">
								<li>NO</li>
								<li>강의일</li>
								<li>시각</li>
								<li>장소</li>
								<li>수강인원</li>
								<li>강의상태</li>
							</ul>
							<c:forEach items="${cas.schedules}" var="scd">
								<ul class="sub-ul">
									<li>${scd.scdNum}</li>
									<li>${scd.scdDate}</li>
									<li>${scd.scdStartTime}</li>
									<li>${scd.scdPlace}</li>
									<li>${scd.scdMaxPersonnel}</li>
									<li>${scd.scdStatus}</li>
								</ul>
							</c:forEach>

						</ul>
					</td> 
				</tr>
			</c:forEach>

		</tbody>
	</table>

</div> 
<script>
window.onload = () => { 
    var subBtns = document.querySelectorAll(".detail-btn");

    subBtns.forEach((btn) => {
        var hiddenUl = btn.parentElement.parentElement.nextElementSibling;
        btn.addEventListener('click', () => {
            if (hiddenUl.classList.contains('show')) {
                hiddenUl.classList.remove('show');
            } else {
                hiddenUl.classList.add('show');

            } 
        });
    });
};
</script>
