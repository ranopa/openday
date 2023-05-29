<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='<c:url value="/resources/js/user/subClassList.js"/>'></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/user/subClassList.css"/>">
</head>
<body>
	<div class="mainContentBigWrapper">
		<div class="mainContentWrapper">
			<%@ include file="header.jsp"%>
			<p>${codName}쿠킹</p>
			<hr>
			<div class="tchcsList">

				<div>${filNum}프로필</div>
				<span>${tchcNickname}닉네임</span>

			</div>

			<div>
				<label><input type="checkbox" name="color" value="blue">인기순</label>
				<label><input type="checkbox" name="color" value="blue">등록일순</label>
				<label><input type="checkbox" name="color" value="blue">가격높은순</label>
				<label><input type="checkbox" name="color" value="blue">가격낮은순</label>

			</div>

			<table class="oclassTable">
				<tr>
					<td class="oclass">
						<div class="ssum-img">이미지넣는곳</div>
						<div class="txt-box">
							<div class="tb1">
								<div class="t1">
									<span>지역</span> <span>|</span> <span>카테고리</span>
								</div>
								<div class="t2">
									<span><span class="material-symbols-outlined oclassIcon">
											star </span>별점수</span><span>(후기수)</span> <span><span
										class="material-symbols-outlined oclassIcon"> favorite
									</span>하트수</span>
								</div>
							</div>
							<p class="cls-name">클래스 이름</p>
							<div class="tb2">
								<strike><p>원래 가격</p></strike> <span>할인율</span> <span>40000원</span>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>