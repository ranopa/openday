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
  var categoryButtons = document.querySelectorAll('.categoryButton');

  function toggleSelection(button) {
    categoryButtons.forEach(function(btn) {
      if (btn !== button) {
        btn.classList.remove("selected");
      }
    });

    button.classList.toggle("selected");
  }

  categoryButtons.forEach(function(button) {
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

//menu or search

document.getElementById('body').addEventListener('click', function(e) {
  if (!document.getElementById('menu').contains(e.target)) {
    document.getElementById('menu').style.display = 'none';
  }
});
