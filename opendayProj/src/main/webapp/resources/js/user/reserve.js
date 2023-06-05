
 window.onload=()=>{ 
 var menuBtns = document.querySelectorAll(".r-btn");
 	menuBtns.forEach(function(menuBtn){ 
 	menuBtn.addEventListener('click',()=>{ 
	  var menuH2 = menuBtn.firstElementChild;
      var h2Text = menuH2.innerText;
      var txt = menuBtn.firstElementChild;
      var tableText = '<table class="oclassTable"><tr class="tableTr">';
      
         menuBtns.forEach((btn)=>{ 
         var btbfe = btn.firstElementChild;  
         if(btbfe.classList.contains('pick')){
        	btbfe.classList.remove('pick');
			}         
        });
       		txt.classList.add('pick');
        
				 $.ajax({
		          url: 'reservedmenuselect',
		          method: 'GET',
		          async:true, 
		          dataType:'json',
		          data: { h2Text: h2Text },
		          
		        success: function(list) { 
		         	$('#reserve-box').empty(); 
		         	
					for(var i = 0; i < list.length; i++){
		         	if(i%4===0&&i!=0){
			        	tableText+='</tr><tr>';
			        	}  
		         	tableText += '<td class="oclass">'+
        						  '<a href="javascript:void(0)" class="r-link">'+
                			      '<img src="img/'+list[i].filNum+'\" class="h-ssum-img"> '+
                				  '<div class="txt-box">'+
                   				  '<div class="t1">'+
			                      '<p>'+list[i].strDate+'</p>';
			                      
			                      if(h2Text==="신청내역"){   
			                     	 tableText+='<p class="reserve-badge">수강예정</p>';
							      }else if(h2Text==="수강내역"){
							         tableText+='<p class="record-badge">수강완료</p>';  
							      }else{ 
							         tableText+='<p class="cancel-badge">취소</p>';
						       	  } 
						       	  
	               	tableText += '</div>';
	               	
	               				if(h2Text==="환불내역"){
	               					tableText += '<p class="cls-name"><strike>'+list[i].clsName+'</strike></p>';
	               				}else{
			                    	tableText+= '<p class="cls-name">'+list[i].clsName+'</p>'; 	               				
	               				}
	               	
                 	tableText += '<div class="tb2">'+
			                     '<span class="oriPrice">결제금액&nbsp;&nbsp;</span>'+
			                     '<span class="fp price">'+list[i].apFinalAmount+'&nbsp;원</span>'+
			                     '</div>'+
			                     '</div>'+
			                     '</a>'+
			                     '</td>'; 
					}		         	
		         	
		         	tableText += '</tr></table>'; 
					$('#reserve-box').append(tableText);  
			    },
			    error: function(xhr, status, error) { 
			        console.log('Error:', xhr);
			    }  
			})
	 	})
	 })
 }
  
        

 