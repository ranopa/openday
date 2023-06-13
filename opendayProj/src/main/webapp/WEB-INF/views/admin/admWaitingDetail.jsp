<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div id="waiting-detail">
	<div id="div1">
		<div class="page">
			<div id=opendiv1>
				<div class="opendiv2">
					<span class="span s1">클래스 이름</span><span>${oclass.clsName }</span>
				</div>
				<div class="opendiv2">
					<span class="span s1">클래스 지역</span> <span class="span">${oclass.clsLoc}</span>
				</div>
				<div class="opendiv2">
					<span class="span s1">클래스 수강료</span> <span>${oclass.clsPrice}
						원</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class="span s1">할인률</span><span>200000
						%</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</div>
				<div class="opendiv2">
					<span class="span s1">클래스 카테고리</span> <span>${oclass.clsCode}</span>
				</div>

				<div class="opendiv2">
					<span class="span s1">클래스 소개글</span> <span>
						${oclass.clsDescription}</span>
				</div>

				<div id="divdouble">
					<div>
						<p class="s1" style="font-size: 18px;">클래스 썸네일</p>
						<div class="thumbnail-container" id="thumbnail-container">
							<img src="img/${oclass.filNum }" />
						</div>
					</div>

					<div>
						<p class="s1" style="font-size: 18px;">강사, 강의 경력</p>
						<textarea name="clsCareer" readonly>${oclass.clsCareer}</textarea>
					</div>
				</div>

				<div id=curri class="opendiv2">
					<p class="s1" style="font-size: 18px; margin-bottom: 10px;">커리큘럼
						작성</p>
					<div id="viewer" >${oclass.clsCurri }</div>
				</div>
			</div>
			<div class="container">
				<div class="waiting-container"></div>
				<div class="btn-par">
					<form action="${contextPath}/adm/adminrefuse" method="post">
						<input type="hidden" name="clsId" value="${oclass.clsId }">

						<button type="submit" id="no-btn" class="submit-btn btn1">거절하기</button>
					</form>
					<form action="${contextPath}/adm/adminallow" method="post">
						<input type="hidden" name="clsId" value="${oclass.clsId }">
						<button type="submit" id="ok-btn" class="submit-btn btn2">승인하기</button>
					</form>
				</div>
			</div>
		</div>

	</div>
</div>

<style>
#viewer p{
	color:black !important;
}
</style>
<script>
            document.addEventListener("DOMContentLoaded", function () {
                const viewer = toastui.Editor.factory({
                    el: document.querySelector('#viewer'),
                    viewer: true,
                    height: '500px',
                    initialValue: content
                });

            });


        </script>