
    window.onload=()=>{
    
  var wModalBtn = document.querySelector("#del-btn");
  var wModalEl = document.querySelector(".w-modal"); 
  var wCancelBtn = document.querySelector(".w-cancel-btn");
  var wSubmitBtn = document.querySelector(".w-submit-btn");
  
  
  
  
  wModalBtn.addEventListener("click",()=>{
  	console.log("cleck")
        if(!wModalEl.classList.contains('w-hide')){
           wModalEl.classList.add("w-hide"); 
        }
    })

  
   wSubmitBtn.addEventListener('click',()=>{
        if(wModalEl.classList.contains('w-hide')){
        	wModalEl.classList.remove('w-hide');
        }    	
    })
    }