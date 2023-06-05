/**
 * 
 */
 window.onload=function(){
 //idcheck
 
 var checked="N";
		//아이디 중복 체크 
		$("#idCheckBtn").click(function() {			
			$.ajax({
				url : 'idCheck',
				type : 'get',
				data : {
					userId : $("#userId").val()
				},
				dataType : 'text', 
				success : function(responseData, status, xhr) {	
					var message = $("#idMessage");
					if(responseData=="사용가능한 아이디입니다."){
						message.css("color", "blue");
						checked = "Y";
					}else{
						message.css("color", "red");
						checked = "N";
					}				
					message.text(responseData);					
				},
				error : function(xhr, status, error) {
				}
			});			
		});
 
 
 //패스워드, 패스워드 확인 처리
		$("#userPw2").blur(function(){			
			let message = $("#pwMessage");
			
			if($(this).val()==$("#userPassword").val()){
				message.css("color", "blue").text("일치");					
			}else{				
				message.css("color", "red").text("비밀번호확인");
			}
		});
}