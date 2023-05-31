<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
	<script src='<c:url value="/resources/js/user/main.js"/>'></script> 
 
</head>

<body>
 <jsp:include page="../header.jsp" /> 

	<div class="newList">
 
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
		
			</div>
</body>
</html>
  <jsp:include page="../footer.jsp"/> 