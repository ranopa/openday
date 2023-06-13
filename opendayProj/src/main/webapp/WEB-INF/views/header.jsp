<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src='<c:url value="/resources/js/user/mainContent.js"/>'></script>
<link rel="stylesheet" href="<c:url value="/resources/css/user/mainContent.css"/>">

<link rel="stylesheet"	href="<c:url value="/resources/css/user/header.css"/>">
<script src='<c:url value="/resources/js/user/header.js"/>'></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />

<!-- 제이쿼리달력-->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style>
/* datepicer 버튼 롤오버 시 손가락 모양 표시 */
.ui-datepicker-trigger {
	cursor: pointer;
}

 /* datepicer input 롤오버 시 손가락 모양 표시  */
.hasDatepicker {
	cursor: pointer;
}
.IconText{
font-size: 16px;
	font-family: 'NanumBarunGothic';
}
</style>


 
<script>   
  $.datepicker.setDefaults({ 
    dateFormat: 'yy-mm',
    prevText: '이전 달',
    nextText: '다음 달',
    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    showMonthAfterYear: true,
    yearSuffix: '년' 
  });
  /* $(function() {
    $("#datepicker1, #datepicker2").datepicker();
  }); */

  $(function() {
    $("#datepicker1").datepicker();
    $("#datepicker2").datepicker();
  });

</script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- 에이작스 밑에 쓰기 -->
<script>

 $(function(){
	$.ajax({
		url:'categorylist',
		type:'post',
		async:true,
		dataType:'json',
		contentType:'application/json;charset=utf-8',
		success:function(data){
			data.unshift({codNum: '', codClassfication: '카테고리', codName: '전체', codNewdate: 1684854000000});
			let tablestr = '';
			let idx = 0
 			for(let code of data){
				$('#category').append(`<option value="\${code.codNum}">\${code.codName}</option>`);
 				if(idx%5==0) tablestr+='<tr>';

 				tablestr += `<td><button type="button" class="categoryButton"
					name="categoryButton" value="\${code.codNum}" onclick="location.href='./menu?pageNum=1&codNum=\${code.codNum}&codName=\${code.codName}'">\${code.codName}</button></td>`;

 				if(idx%5==0) tablestr+='<\tr>';	
 				idx++;
 			} 
			
 			$('#categoryTable').append(tablestr);
 			
 			$(".categoryButton").click(function(e) {
 				$(".categoryButton").removeClass("selected");
 				console.log($(this).val());
 				$(this).addClass("selected");
 			})
		}
	})
 })
</script>
<script>
  function closeSearchFilterWrapper() {
    var searchFilterWrapper = document.querySelector(".searchFilterWrapper");
    searchFilterWrapper.style.display = "none";
  }
  

</script>
<style>


.topBA2 {
	margin-top: 10px;
}

.topButtonColor {
	margin-left: 10px;
}

</style>

<script type="text/javascript">
document.addEventListener('DOMContentLoaded', function() {
  var searchInput = document.querySelector('.search');
  var disElement = document.getElementById('dis');
  var categoryElement = document.getElementById('category');
  var disMenuElement = document.getElementById('disMenu');
  var menuIconInput = document.querySelector('.menuIcon');

  searchInput.addEventListener('click', function(event) {
    event.stopPropagation();
    disElement.style.display = 'block';
    disMenuElement.style.display = 'none';
  });

  categoryElement.addEventListener('click', function() {
    disMenuElement.style.display = 'none';
  });

  menuIconInput.addEventListener('click', function(event) {
    event.stopPropagation();
    disMenuElement.style.display = 'block';
    disElement.style.display = 'none';
  });

  document.addEventListener('click', function(event) {
    if (!disElement.contains(event.target)) {
      disElement.style.display = 'none';
    }
    if (!disMenuElement.contains(event.target)) {
      disMenuElement.style.display = 'none';
    }
  });
});
</script>




<!-- 알림css -->
 <style>
        #alarm *{
            padding: 0;
            margin:0; 
        }
        #alarm{
             opacity: 0;
            visibility: hidden; 
            transition: 0.3s all;
             position: absolute;
            right: 60px;
            top: 130;
            background-color: white;
        }
        #alarm.show{
            opacity: 1;
            visibility: visible;
        }

        #alarm .a-a{
            text-decoration: none;
            color: black;
        }
        #alarm .a-a:hover{
            text-decoration: underline;
        }
        
        #alarm .a-box{
            width: 290px;  
            min-height: 250px;
            box-shadow: 2px 2px 3px 1px  rgb(206, 206, 206);
            border-radius: 4px;
            padding:15px;
            
        }
        #alarm .a-p{ 
            margin:0 auto;
            text-align: center;
            font-size: 14px;
            font-weight: bold;
            border-bottom: 1px solid rgb(223, 223, 223);
            margin-top : 5px;
            margin-bottom : 10px;
            padding-bottom : 10px;
        }
        #alarm .a-ul{
            list-style: none;
            display: flex;
            justify-content: space-between;
            margin-bottom: 10px;
            
        }
        #alarm .a-span{
            font-weight: bold;
            font-size: 13px;
            position:relative;
        }
        
        #alarm .a-del-btn{
            border: none;
            background-color: transparent;  
            cursor: pointer;  
        }
        #alarm .message{
            font-size: 12px;
        }
            
        
        #alarm .material-symbols-outlined{
            font-size: 20px;
            color:rgb(207, 207, 207);     
            padding-top: 3px;
        }
		 .alarm-btn{
		 	background-color:transparent;
		 	border:none;
		 	color:#7C4AFF;
		 }
    </style>

</head>
<body>

	<div class="headerWrapper">
		<div class="contentWrapper">
			<header>
				<div class="topBA0">
					<div class="topBA">
						<div class="topBA2">
							<ul class="topButtons">
								<c:set var="userId" value="${sessionScope.userId}" />
								<!-- <li class="nickname">닉네임</li> -->
								<c:choose>
									<c:when test="${userId eq null}">
										<li class="logoutButton"></li>
									</c:when>
									<c:otherwise>
										<b><c:out value="${userId.userNickname}" /></b>

										<li class="logoutButton"><a href="logout"><button>
													<span>로그아웃</span>
												</button></a></li>
									</c:otherwise>
								</c:choose>


								<li class="topButtonColor tB topButtonsMargin"><a
									href="classOpen"><span>강사신청</span></a></li>

								<li class="topButton tB topButtonsMargin"><a
									href="requestlist"><span>클래스요청</span></a></li>

								<li class="topButton tB tBLast topButtonsMargin"><a href="announcementList"><span>고객센터</span></a></li>

							</ul>
						</div>
					</div>
				</div>
		</div>
		<div class="hr1"></div>
		<div class="contentWrapper">
			<div class="logoMenu">
				<h1 class="logo">
					<a href="./">열어데이</a>
				</h1>
				<form type="text" action="searchinput" method="get"
					class="searchAndMenu">

					<div class="searchAndIconBox">
						<div>

							<input class="search" type="text" onclick="dis()"
								placeholder="강사닉네임/클래스명으로 검색" name="keyword">
						</div>
						<div>
							<button type="submit" class="rSearchIcon">
								<span class="material-symbols-outlined">search</span>
							</button>
							<!-- <input
							type="submit" class="searchIcon" value="검색"> -->
						</div>
					</div>

				</form>



				<div class="verticalAlign">
					<c:set var="authority" value="${sessionScope.userId.authority }" />
					<c:choose>
						<c:when test="${authority eq 0}">

							<div class="IconColorAdmin">
								<a href="adm"><div class="IconBoxAdmin">
										<div class="material-symbols-outlined">engineering</div>
										<div class="IconTextAdmin">관리자</div>
									</div></a>
							</div>

						</c:when>
					</c:choose>
					<div class="IconColor">
						<button type="button" id="abtn" class="alarm-btn"><div class="IconBox">
								<div class="material-symbols-outlined">notifications</div>
								<div class="IconText">알림</div>
							</div></button>
					</div>
					<c:set var="userId" value="${sessionScope.userId }" />

					<c:choose>
						<c:when test="${userId eq null}">
							<div class="IconColor">
								<a href="loginform"><div class="IconBox">
										<div class="material-symbols-outlined">person</div>
										<div class="IconText">로그인</div>
									</div></a>
							</div>
						</c:when>
						<c:otherwise>

							<div class="IconColor">
								<a href="mypage"><div class="IconBox">
										<div class="material-symbols-outlined">person</div>
										<div class="IconText">마이</div>
									</div></a>
							</div>
						</c:otherwise>
					</c:choose>

					<div class="IconColor menuIcon" id="menuIcon">
						<a href="#"><div class="IconBox" onclick="disMenu()">
								<div class="material-symbols-outlined" id="menu"
									>menu</div>
								<div class="IconText">카테고리</div>
							</div></a>
					</div>
				</div>
			</div>




		</div>
		<div class="hr2"></div>
	</div>
	</header>


	<form type="text" action="search" method="get">
		<div id='dis' class="searchFilterWrapper">

			<div class="contentWrapper">
				<div class="filterUl1">
					<p class="filterUlTitle">지역</p>
					<input type="radio" name="clsLoc" id="all" value="" checked />
					<label class="radio-label" for="all">전체</label>
					<input type="radio" name="clsLoc" value="서울" id="seoul"/> <label class="radio-label" for="seoul">서울</label> 
						 <input type="radio" name="clsLoc" id="gyeonggi" value="경기" /><label class="radio-label" for="gyeonggi">경기 </label>
					<input type="radio" name="clsLoc" value="인천" id="incheon" /> <label class="radio-label" for="incheon">인천 </label>
					 <input type="radio" name="clsLoc" value="강원" id="gangwon"/><label class="radio-label" for="gangwon">강원 </label>
					 <input type="radio" name="clsLoc" value="충북" id="chungbuk"/><label class="radio-label" for="chungbuk">충북 </label>
					 <input type="radio" name="clsLoc" value="충남" id="chungnam"/><label class="radio-label" for="chungnam">충남 </label> 
					 <input type="radio" name="clsLoc" value="세종" id="sejong"/><label class="radio-label" for="sejong">세종 </label> 
					<input type="radio" name="clsLoc" value="대전" id="daejeon"/><label class="radio-label" for="daejeon"> 대전 </label> 
					 <input type="radio" name="clsLoc" value="광주" id="gwangju"/><label class="radio-label" for="gwangju">광주 </label> 
					 <input type="radio" name="clsLoc" value="전북" id="jeonbuk"/><label class="radio-label" for="jeonbuk">전북 </label> 
					 <input type="radio" name="clsLoc" value="경북" id="gyeongbuk"/><label class="radio-label" for="gyeongbuk">경북 </label> 
					 <input type="radio" name="clsLoc" value="대구" id="daegu"/><label class="radio-label" for="daegu">대구 </label>
					  <input type="radio" name="clsLoc" value="제주" id="jeju"/><label class="radio-label" for="jeju">제주 </label>
					 <input type="radio" name="clsLoc" value="전남" id="jeonnam"/>  <label class="radio-label" for="jeonnam">전남 </label> 
					  <input type="radio" name="clsLoc" value="경남/울산" id="gyeongnam"/> <label class="radio-label-long" for="gyeongnam">경남/울산 </label> 
					   <input type="radio" name="clsLoc" value="부산" id="busan"/><label class="radio-label" for="busan">부산 </label>

				</div>

				<div class="filterUl2">
					<p class="filterUlTitle">카테고리</p>
					<select name="clsCode" id="category">
						<!-- 		<option value="all" selected>전체</option> -->
					</select>

				</div>


				<!-- 검색 필터 달력 -->
				<!-- <div class="filterUl3">
					<p class="filterUlTitle">요일</p>
					<div class="container px-1 px-sm-5 mx-auto searchDatepicker">
						<form autocomplete="off searchDatepickerForm">
							<div class="searchDatepickerDiv">
								<div class="col-lg-6 col-11">
									<div class="input-group input-daterange">
										<input type="text" class="form-control input1"
											name="startDate" placeholder="Start Date" readonly> <input
											type="text" class="form-control input2" name="endDate"
											placeholder="End Date" readonly>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div> -->

				<div class="filterUl3">
					<p class="filterUlTitle">기간</p>

					<p>
						<input type="date" id="datepicker1" name="startDate" placeholder="yyyy-mm-dd"> ~ 
						<input type="date" id="datepicker2" name="endDate" placeholder="yyyy-mm-dd">
					</p>
				</div>

				<div class="searchFilterButton">

					<input type="submit" class="searchButton" value="검색">
					<button type="button" class="refresh"
						onclick="closeSearchFilterWrapper()">
						<!-- <span class="material-symbols-outlined"> refresh </span> -->
						닫기
					</button>
				</div>
			</div>
		</div>
	</form>

	<div id='disMenu' class="menuWrapper">
		<div class="contentWrapper">
			<table class="mainMenuTable" id="categoryTable">

			</table>
		</div>
	</div>
	 <div id="alarm" > 
        <div class="a-box">
            <p class="a-p">알림</p> 
            <ul class="a-ul" id="notiList">
              
            </ul>
        </div>         
    </div> 
    <script>
    
	 var alarmBtn = document.querySelector("#abtn");
     var modalBtn = document.querySelector("#alarm"); 
    

     alarmBtn.addEventListener('click',()=>{   
    	 if(!modalBtn.classList.contains('show')){
             modalBtn.classList.add('show');
         }else{
             modalBtn.classList.remove('show'); 
         }
     })
    </script>
</body>
<script>

window.onload=()=>{
	   
    

 var userId = '${userId.userId}';
     if (userId) {
         setInterval(function() {
         $.ajax({
           url: 'notification/'+userId,
           type:'get',
           contentType: 'application/json',
           success: function(data){
             $('#notiList li').remove();
              if ($('#notiList li').length == 0) {
               for(const noti of data) {
                 console.log(noti.ntfMessage)
                 $('#notiList').append(`
                   <li>
                     <a href="\${noti.ntfUrl}" class="a-a">
                     <span class="message">\${noti.ntfMessage}</span>
                     </a>
                   </li>
                   <li>
                     <button class="a-del-btn">
                       <span class="material-symbols-outlined">
                           close
                       </span>
                     </button>
                     <input type="hidden" id="ntfId" value="\${noti.ntfId}">
                   </li>
                 `);
               }
              }  
           }
         })
         },5*1000);
     }
     
    
     var delBtns = document.querySelectorAll('#alarm .a-del-btn');
     delBtns.forEach(btn=>{
         btn.addEventListener('click',()=>{
             var ipEl = btn.nextElementSibling.value.toString();
             console.log(ipEl); 
             var ulValue = btn.parentElement.parentElement;
             ulValue.remove();


             $.ajax({
                 url:"deletealarm",
                 type:'post',
                 data: {"ipEl":ipEl},
                 success:function(response){
                     console.log('success');
                 },
                 error:function(){
                     console.log('error');
                 }
             })
         })
     }) 
 }
     
</script>
</html>