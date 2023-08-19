    window.onload=()=>{
    
    var writeBtn = document.querySelector('#adm-notice #write-btn');
         writeBtn.addEventListener('click',()=>{
  	    location.href="admnoticewrite";
  })
            var btns = document.querySelectorAll('.btnss');
            btns.forEach(b=>{
                b.addEventListener('click',()=>{
                    btns.forEach(bb=>{
                    if(bb.classList.contains('hover-color')){
                        bb.classList.remove('hover-color');
                    } 
                    b.classList.add('hover-color'); 
                })
            
                //$.ajax
            }) 
        })
    }
 