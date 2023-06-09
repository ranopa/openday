<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="settle-record">
	<div class="sr-container">
		<h2>정산 내역 조회</h2>
		<form action="" method="get">

			<div class="search-box">
				<div class="search1">
					<p class="s-p">기간으로 조회</p>
					<input type="text" id="datepicker1" class="datepicker ip-box" /><span>&nbsp;&nbsp;&nbsp;
						- &nbsp;&nbsp;&nbsp;</span> <input type="text" id="datepicker2"
						class="datepicker ip-box" />
				</div>

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
				<th class="td3">아이디</th>
				<th class="td4">수수료</th>
				<th class="td5">정산금액</th>
				<th class="td6">정산일</th>

			</tr>
		</thead>
		<tbody>
		<c:forEach items="settleList" var="settle">
			<tr>
				<td class="td1">41</td>
				<td class="td2">
					<p class="ellipsis">성빈의베이킹쿠킹오만거다하는엄청난클래스입니다킹오만거다하는엄청난</p>
				</td>
				<td class="td3">ttjdj121</td>
				<td class="td4">100,000</td>
				<td class="td5">900,000</td>
				<td class="td6">2023-05-07</td>
			</tr> 
		</c:forEach>
		</tbody>
	</table>
</div>

