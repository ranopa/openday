window.onload = function() {
  var heartBtns = document.querySelectorAll(".h-btn");

  heartBtns.forEach(function(heartBtn) {
    heartBtn.addEventListener('click', function() {
      var heartIcon = this.querySelector(".icon-custom");
      var clsId = this.value.toString();

      if (heartIcon.classList.contains('fill')) { 
        $.ajax({
          url: 'removeheart',
          method: 'POST',
          data: { clsId: clsId },
          success: function(response) {
            console.log('성공!');
            heartIcon.classList.remove('fill');
          },
          error: function(xhr, status, error) {
            console.log('Error:', error);
          }
        });
      } else {
        $.ajax({
          url: 'addheart',
          method: 'POST',
          data: { clsId: clsId },
          success: function(response) {
            console.log('성공!');
            heartIcon.classList.add('fill');
          },
          error: function(xhr, status, error) {
            console.log('Error:', error);
          }
        });
      }
    });
  });
}