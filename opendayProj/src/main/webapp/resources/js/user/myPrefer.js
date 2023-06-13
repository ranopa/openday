   
window.onload = function() {
  var categoryButtons = document.querySelectorAll('.categoryButton');
  var selectedButtons = [];

  function toggleSelection(button) {
    button.classList.toggle("selected");
    var index = selectedButtons.indexOf(button);
    if (index > -1) {
      selectedButtons.splice(index, 1);
    } else {
      selectedButtons.push(button);
    } 
    
  }

  categoryButtons.forEach(function(button) {
    button.addEventListener('click', function() {
      toggleSelection(this);
    });
  });


var buttons = document.getElementsByClassName("category-btn");
	var selectedValues = [];
	
	for (var i = 0; i < buttons.length; i++) {
	  buttons[i].addEventListener("click", function() {
	    if (this.classList.contains("selected")) {
	      this.classList.remove("selected");
	      var index = selectedValues.indexOf(this.value);
	      if (index !== -1) {
	        selectedValues.splice(index, 1);
	      }
	    } else {
	      this.classList.add("selected");
	      selectedValues.push(this.value);
	    }
	  });
	}
	
	var resultButton = document.getElementById("preferBtn");
	resultButton.addEventListener("click", function() { 
	var concatenatedValues = selectedValues.join('_');
	document.getElementById("preferValues").value = concatenatedValues; 
	});
};
 


function toggleCategoryButton() {
	const selectCnt = $(".category-btn.checked").length;
	
	// 이미 3개 눌려있고, 현재 버튼이 unchecked이면? 클릭되면 안됨.
    if (selectCnt == 3 && $(this).hasClass("unchecked")) {
    	alert("최대 3개까지만 선택 가능합니다!");
    	return false; 
    }
    
    // toggle checked<->unchecked
    if ($(this).hasClass("checked")) {
    	$(this).removeClass("checked");
    	$(this).addClass("unchecked");
    } else if ($(this).hasClass("unchecked")) {
    	$(this).removeClass("unchecked");
    	$(this).addClass("checked");
    }
}

$(function() {
	$(".category-btn").on("click", toggleCategoryButton);
});

