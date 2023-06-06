window.onload = () => {
     alert('hello');
     console.log('hello');
      var headerLies = document.querySelectorAll("#header .h-atag");    
            headerLies.forEach(ha=>{
                ha.addEventListener('click',(event)=>{ 
                    event.preventDefault();
                    var child1 = ha.firstElementChild;
                    headerLies.forEach(li2=>{
                        var childLi2 = li2.firstElementChild; 
                        if(childLi2.classList.contains('header-hover')){
                            childLi2.classList.remove('header-hover'); 
                        }
                    })
                    child1.classList.add('header-hover');
                    return true; 
                })
            })
}