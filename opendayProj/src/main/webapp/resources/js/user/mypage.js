window.onload=function(){
    var modalBtn = document.querySelector("#profile-edit-btn");
    var modalEl = document.querySelector(".modal");
	var	cancelBtn = document.querySelector(".cancel-btn");
    
    modalBtn.addEventListener('click',()=>{
        if(!modalEl.classList.contains('hide')){
           modalEl.classList.add("hide"); 
        }
    })
    
    cancelBtn.addEventListener('click',()=>{
    	console.log("back");
        if(modalEl.classList.contains('hide')){
        	modalEl.classList.remove('hide');
        }    	
    })
    
    document.getElementById("select-file").addEventListener("click",()=>{
    	 document.querySelector(".custom-file-input input[type='file']").click();
    })
    
    document.getElementById("myfile").addEventListener("change", function() {
    var fileInput = this;
    var imageElement = document.getElementById("myImg");

    var reader = new FileReader();
    reader.onload = function(e) {
      imageElement.src = e.target.result;
    };
    
    reader.readAsDataURL(fileInput.files[0]);
  });
  
   
  var wModalBtn = document.querySelector("#withdraw-a");
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

