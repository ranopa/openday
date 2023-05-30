<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<style>
/* 클래스 카드 */
*{
	 padding:0;
	 margin:0;
}
.oclass {
	width: 300px;
	height: 368.95px;
	/* background-color: antiquewhite; */
	border-radius: 5px;
	border: 1px solid rgb(207, 207, 207);
}

.ssum-img {
	width: 100%;
	height: 260px;
	background-color: rgb(218, 218, 218);
	margin-bottom: 10px;
}

.txt-box {
	padding-right: 10px;
	padding-left: 10px;
}

.tb1 {
	display: flex;
	justify-content: space-between;
	font-size: 13px;
	margin-bottom: 5px;
}

.t1 {
	margin-left: 6px;
}

.t1 span {
	margin-right: 3px;
	color: #7A7A7A;
	font-weight: bold;
}

.t2 {
	margin-right: 6px;
}

.t2 span {
	margin-right: 3px;
}

.heart {
	font-size: 12px;
	color: #FF729D;
}

.star {
	color: #FFD029;
}

.cls-name {
	font-size: 18px;
	font-weight: bold;
	border-bottom: 1px solid rgb(212, 212, 212);
	width: 95%; margin-bottom : 10px;
	padding-bottom: 10px;
	margin-left: 5px;
	margin-bottom: 10px;
}

.oclass p {
	margin-top: 7px;
}

.tb2 {
	display: flex;
	font-size: 18px;
	padding-bottom: 15px;
	margin-right: 10px;
	flex-direction: row;
	justify-content: flex-end;
}

.oriPrice {
	color: #B4B4B4;
	font-size: 15px;
	margin-right: 5px;
	margin-top: 3px;
}

.disc {
	color: #8556FF;
	font-weight: 600;
}

.fp {
	font-weight: 600;
}

.oclassIcon {
	font-size: 14px;
}
</style>
</head>

<body>
	<div class="newList">

				<%-- <c:forEach items="${nlist}" var="list"> --%>
					<table class="oclassTable">
						<tr>
							<td class="oclass">
								<div class="ssum-img">이미지</div>
								<div class="txt-box">
									<div class="tb1">
										<div class="t1">
											<span>서울</span><span>|</span><span>쿠킹</span>
										</div>
										<div class="t2">
											<span><i class="bi bi-star-fill star"></i></span><span>3</span><span>(26)</span>
											<span><i class="bi bi-heart-fill heart"></i></span><span>3523</span>
										</div>
									</div>
									<p class="cls-name">클래스이름</p>
									<div class="tb2">
										<span class="oriPrice"><strike>400000원</strike></span>
										<div class="price">
											<span class="disc">20%</span> <span
												class="fp">10000 원</span>
										</div>
									</div>
								</div>
							</td>
						</tr>
					</table>
			<!-- 	</c:forEach> -->
			</div>
</body>
</html>