/**
 * 
 */
 var idCheckIndex ="N";
 var nickCheckIndex ="N";
 
 window.onload=function(){
 //idcheck 
		//아이디 중복 체크 
		$("#idCheckBtn").click(function() {			
			$.ajax({
				url : 'idCheck',
				type : 'get',
				data : {
					userId : $("#inputId").val()
				}, 
				success : function(responseData) {	
					var message = $("#idMessage");
					var resultMessage = null;
					if(responseData==="0"){
						message.css("color", "blue"); 
						resultMessage = "사용가능한 아이디입니다.";
						idCheckIndex="Y";
					}else{
						message.css("color", "red"); 
						resultMessage = "이미 존재하는 아이디입니다.";
						idCheckIndex="N";
						
					}				
					message.text(resultMessage);					
				},
				error : function(xhr, status, error) {
				console.log('fail');
				}
			});			
		});
		
	//아이디 중복 체크 
		$("#nickCheckBtn").click(function() {		 
			$.ajax({
				url : 'nicknamecheck',
				type : 'get',
				data : {
					userNickname : $("#userNickname").val()
				}, 
				success : function(responseData) {	
					var message = $("#nickMessage");
					var resultMessage = null;
					if(responseData==="0"){
						message.css("color", "blue"); 
						resultMessage = "사용가능한 닉네임입니다.";
						nickCheckIndex="Y";
					}else{
						message.css("color", "red"); 
						resultMessage = "이미 존재하는 닉네임입니다.";
						nickCheckIndex="N";
					}				
					message.text(resultMessage);					
				},
				error : function(xhr, status, error) {
				console.log('fail');
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
		
		$('#join-check-btn').click(()=>{ 
			if("idCheckIndex"==="N"||"nickCheckIndex"==="N"){
			e.preventDefault();
			alert('항목을 다시 확인하세요');
			}
		})
}