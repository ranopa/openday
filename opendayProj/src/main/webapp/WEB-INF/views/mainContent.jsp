<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src='<c:url value="/resources/js/user/mainContent.js"/>'></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/user/mainContent.css"/>">


</head>
<body>
	<div class="mainContentBigWrapper">
		<div class="mainContentWrapper">
			<table class="mainMenuTable">
				<tr>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">전체</button>
					</td>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">도자기</button>
					</td>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">가죽</button>
					</td>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">목공</button>
					</td>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">금속/악세서리</button>
					</td>

				</tr>
				<tr>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">유리</button>
					</td>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">조향/캔들/방향제</button>
					</td>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">라탄/마크라메</button>
					</td>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">자수/재봉/펠트</button>
					</td>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">취미/레저</button>
					</td>

				</tr>
				<tr>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">플라워/벌룬</button>
					</td>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">애견</button>
					</td>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">미술</button>
					</td>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">음악(보컬/악기/프로그램 등)</button>
					</td>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">뷰티/미용</button>
					</td>

				</tr>
				<tr>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">쿠킹</button>
					</td>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">핸드메이드</button>
					</td>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">키즈</button>
					</td>
					<td>
						<button type="button" class="mainCategoryButton"
							name="categoryButton">기타</button>
					</td>

				</tr>
			</table>
			<div class="newList">

<%-- <c:forEach items="${collectoDTO}" var="new" > --%>
			<table class="oclassTable">
				<tr>
					<td class="oclass">
						<div class="ssum-img">${collectoDTO.oclassDTO.filNum}</div>
						<div class="txt-box">
							<div class="tb1">
								<div class="t1">
									<span>지역</span> <span>|</span> <span>${collectoDTO.oclassDTO.clsCode}</span>
								</div>
								<div class="t2">
									<span><span class="material-symbols-outlined oclassIcon">
											star </span>${collectoDTO.oclassDTO.clsStar}</span><span>(${collectoDTO.reviewCount})</span> <span><span
										class="material-symbols-outlined oclassIcon"> favorite </span>${collectoDTO.oclassDTO.clsHeart}</span>
								</div>
							</div>
							<p class="cls-name">${collectoDTO.oclassDTO.clsName}</p>
							<div class="tb2">
								<strike><p>${collectoDTO.oclassDTO.clsPrice}</p></strike> <span>${collectoDTO.scheduleDTO.scdDiscount}</span> <span>${collectoDTO.finalPrice}</span>
							</div>
						</div>
					</td>
				</tr>
			</table>
<%-- </c:forEach> --%>
</div>





		</div>
	</div>
</body>
</html>