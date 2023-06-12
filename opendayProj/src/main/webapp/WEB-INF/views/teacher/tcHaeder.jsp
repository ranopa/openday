<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="tc-haeder">
	<div class="tc-logo">
		<h1>
			<a href="./" class="tc-logoLink">열어데이</a>
		</h1>
	</div>
	<div class="tc-profile">
		<a href="#" class="tc-profileLink"> <img id="profile_file_add1" src=""
			alt="#" class="tc-profileImg">
		</a> <br> <i class="tc-profileEditLink material-symbols-outlined"
			id="open-modal"> edit </i>
	</div>
	<form id="frm_profile">
		<div id="profileUploadModal" class="profileUpload">
			<div class="modal-content">
				<div class="profileUpload-image">
					<img src="" alt="#"
						class="tc-profileImg" name="profileFile" id="profile_file_add">
					<input type="file" name="fileProfile" id="file" hidden="hidden">
				</div>
				<div class="profileUpload-profile">
					<h3>프로필 수정</h3>
					<div>닉네임</div>
					<input type="text" name="nickName"><br>
					<div>강사 소개 입력</div>
					<textarea rows="" cols="" name="tcIntroduction"></textarea>
					<button id="save-modal">저장</button>
					<button id="close-modal">취소</button>
				</div>
			</div>
		</div>
	</form>
	<div class="tc-nav">
		<ul class="tc-nav-item">
			<li class="tc-nav-list"><a href="classOpen">클래스 개설</a></li>
			<li class="tc-nav-list"><a href="tcHome">대시보드</a></li>
			<li class="tc-nav-list"><a href="tcClass">클래스 관리</a></li>
			<li class="tc-nav-list"><a href="tcClsUser">수강생 관리</a></li>
			<li class="tc-nav-list"><a href="tcClsInquiry">수강생 문의</a></li>
			<li class="tc-nav-list"><a href="tcClsSchedule">일정 관리</a></li>
			<li class="tc-nav-list"><a href="tcClsSales">클래스별 수익금</a></li>
			<li class="tc-nav-list"><a href="tcClsSalesList">정산신청 내역</a></li>
		</ul>
	</div>
	<div class="tc-logout">
		<a href="logout">로그아웃</a>
	</div>
</div>
<script>

	const modal = document.getElementById("profileUploadModal");
	const openModalBtn = document.getElementById("open-modal");
	const closeModalBtn = document.getElementById("close-modal");
	const saveModalBtn = document.getElementById("save-modal");
	// 모달창 열기
	openModalBtn.addEventListener("click", () => {
	  modal.style.display = "block";
	  document.body.style.overflow = "hidden"; // 스크롤바 제거
	  
	});
	// 모달창 닫기
	closeModalBtn.addEventListener("click", () => {
	  modal.style.display = "none";
	  document.body.style.overflow = "auto"; // 스크롤바 보이기
	});
	modal.addEventListener("click", (e) => {
		if(e.target === modal) {
		  modal.style.display = "none";
		  document.body.style.overflow = "auto"; // 스크롤바 보이기
		}
	});
	
	saveModalBtn.addEventListener("click", (e) => {
		console.log("버튼클릭");
		$( "#frm_profile" ).submit();
        let fileProfile = $("input[name='fileProfile']").val();
        var frm = document.getElementById('profile_file_add');
        frm.method = "POST";
        frm.enctype = "multipart/form-data";
        var Data = new FormData($("#frm_profile")[0]);
        Data.append("file",fileProfile);
        // ajax
        $.ajax({
            type:'POST',
            url:'profileUpdate',
            data: Data,
            contentType: false,
            processData: false,
            success : function(data) {
            	console.log("성공적");
            	console.log(data);
            },
            error : function(request,status,error) {  
            	console.log("실패","code:"+request.status+"\n"+"error:"+error);
            }
        });
        modal.style.display = "none";
  	  	document.body.style.overflow = "auto"; // 스크롤바 보이기
	});
	   //이미지 클릭시 업로드창 실행
	 $('#profile_file_add').click(function() {
	        console.log('fileadd');
	        $("input[name='fileProfile']").click();
	       
	    })
	    //업로드 파일체인지가 됬을경우 실행되는 이벤트
	$("input[name='fileProfile']").change(function(e){
       
		 e.preventDefault();
		 
		    var file = this.files[0];
		        reader = new FileReader();
		   reader.fileName = file.name;
		    reader.onload = function (event) {
		        var img = new Image();
		        console.log(event.target.fileName);
		        img.src = event.target.result;
		        if (img.width > 700 || img.height > 500) { // holder width
		          img.width = 700;
		          img.height = 500;
		        }
		        $('#profile_file_add').attr("src",img.src);
		        $('#file').attr("src",img.src);
		        //$('#file').val(file);
		        $('#file').attr("src",img.src);
		    };
		    reader.readAsDataURL(file);
		   
		    return false;
    })
	 	$.ajax({
	        type:'POST',
	        url:'profileImage',
	        data : {
	        	id : "hong"//${session.id}
	        },
	        success : function(data) {
	        	if(data == '' || data == null) {
		        	$("#profile_file_add").attr("src","resources/image/user/basic_profile.png");
		        	$("#profile_file_add1").attr("src","resources/image/user/basic_profile.png");
	        	}else {
		        	$("#profile_file_add").attr("src","resources/upload/" + data.filSaveName);
		        	$("#profile_file_add1").attr("src","resources/upload/" + data.filSaveName);
	        	}
	        },
	        error : function(request,status,error) {  
	        	console.log("실패","code:"+request.status+"\n"+"error:"+error);
	           //alert("code:"+request.status+"\n"+"error:"+error);
	        }
	    });
</script>