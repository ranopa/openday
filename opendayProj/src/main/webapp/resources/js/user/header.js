//search day
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
  
  //menu only one click
window.onload = function() {
  var categoryButton = document.querySelectorAll('.categoryButton');

  function toggleSelection(button) {
    categoryButton.forEach(function(btn) {
      if (btn !== button) {
        btn.classList.remove("selected");
      }
    });

    button.classList.toggle("selected");
  }

  categoryButton.forEach(function(button) {
    button.addEventListener('click', function() {
      toggleSelection(this);
    });
  });
};
  
  //local li selected
document.addEventListener('DOMContentLoaded', function() {
  var filterItems = document.querySelectorAll('.filterUl1 ul li');

  filterItems.forEach(function(item) {
    item.addEventListener('click', function() {
      var selectedItem = document.querySelector('.filterUl1 ul li.selected');
      if (selectedItem) {
        selectedItem.classList.remove('selected');
      }

      this.classList.add('selected');
    });
  });
});

//search menu hide ans show
function dis() {
  var disElement = document.getElementById('dis');
  var disDisplayStyle = window.getComputedStyle(disElement).display;

  if (disDisplayStyle === 'none') {
    disElement.style.display = 'block';
  } else {
    disElement.style.display = 'none';
  }
}

//menu hide and show
function disMenu() {
  var disElement = document.getElementById('disMenu');
  var disDisplayStyle = window.getComputedStyle(disElement).display;

  if (disDisplayStyle === 'none') {
    disElement.style.display = 'block';
  } else {
    disElement.style.display = 'none';
  }
}

//검색필터 달력
//$(document).ready(function(){

//$('.input-daterange').datepicker({
//    format: 'dd-mm-yyyy',
//   autoclose: true
//});

//});

//검색필터 초기화

 function resetFilters() {
    // 필터 값을 초기화하는 코드 작성
    // 예: JavaScript로 필터 값을 변경하거나, 폼을 초기화하거나, URL을 초기값으로 설정 등
    // 필터 값 초기화 후 검색을 다시 수행하거나, 페이지를 다시 로드할 수 있습니다.
    var searchForm = document.getElementById('searchForm');
    searchForm.reset(); // 폼 초기화
    searchForm.submit(); // 검색 수행
    // 다른 필터 초기화 코드 작성
  }
