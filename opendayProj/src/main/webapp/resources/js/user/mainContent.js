  //menu only one click
window.onload = function() {
  var mainCategoryButton = document.querySelectorAll('.mainCategoryButton');

  function toggleSelection(button) {
    mainCategoryButton.forEach(function(btn) {
      if (btn !== button) {
        btn.classList.remove("selected");
      }
    });

    button.classList.toggle("selected");
  }

  mainCategoryButton.forEach(function(button) {
    button.addEventListener('click', function() {
      toggleSelection(this);
    });
  });
};


function doDisplay(){ 	
    var con = document.getElementById("tableTrHidden"); 	
    if(con.style.display=='none'){ 		
    	con.style.display = 'block'; 	
    }else{ 		
    	con.style.display = 'none'; 	
    } 
}
