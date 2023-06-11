<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="user-list">
	<div class="sr-container">
		<h2>전체 회원 목록</h2>
		<form action="" method="get">
			<div class="search-box">
				<diV class="search1">
					<p class="s-p">회원 조회</p>
					<input type="text" class="ip-box ipt" name="searchText"
						placeholder="아이디 / 닉네임 / 이름">
					<button type="submit" class="sub-btn">
						<span class="material-symbols-outlined"> search </span>
					</button>
					<button type="button" class="tu-both-btn tu-btn" value="전체">전체</button>
					<button type="button" class="only-tchc-bun tu-btn" value="강사">강사목록</button>
					<button type="button" class="only-user-btn tu-btn" value="유저">유저목록</button>
				</diV>
		</form>

	</div>
	<table class="table">
		<thead>
			<tr class="th-color">
				<th class="td2">아이디</th>
				<th class="td3">닉네임</th>
				<th class="td4">이메일</th>
				<th class="td5">전화번호</th>
				<th class="td6">가입일</th>
				<th class="td7"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<c:choose>
					<c:when test="${user.tchcNum eq null}">
						<tr>
							<td class="td2">${user.userId }</td>
							<td class="td3">${user.userNickname }</td>
							<td class="td4">${user.userEmail }</td>
							<td class="td5">${user.userTel }</td>
							<td class="td6">${user.userJoindate }</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td class="td2">${user.userId }</td>
							<td class="td3"><span class="host-badge">H</span>${user.userNickname }</td> 
							<td class="td4">${user.userEmail }</td>
							<td class="td5">${user.userTel }</td>
							<td class="td6">${user.userJoindate }</td>
							<td class="td7"><button type="button" id="detail-btn"
									class="detail-btn">
									<span class="material-symbols-outlined icon2">
										expand_more </span>
								</button>
						</tr>
						<tr class="sub-toggle">
							<td>
								<ul class="sub-table">
									<ul class="sub-ul ul1">
										<li>NO</li>
										<li>강사닉네임</li>
										<li>이름</li>
										<li>계좌번호</li>
										<li>등록일</li>
									</ul>
									<ul class="sub-ul">
										<li>${user.tchcNum}</li>
										<li>${user.tchcNickname}</li>
										<li>${user.userName}</li>
										<li>${user.userAccount}</li>
										<li>${user.userJoindate}</li>
									</ul>
								</ul>
							</td>
						</tr>
					</c:otherwise>
				</c:choose> 
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

            var tuBtns = document.querySelectorAll(".tu-btn");
            tuBtns.forEach(btn => {
                btn.addEventListener('click', () => {
                    tuBtns.forEach(btnn => { 
                        if (btnn.classList.contains('purple')) {
                            btnn.classList.remove('purple'); 
                        }
                    })
                    btn.classList.add('purple'); 
                    var strText = btn.value;

                    // $.ajax({

                    // })
                })
            })
        } 
</script>