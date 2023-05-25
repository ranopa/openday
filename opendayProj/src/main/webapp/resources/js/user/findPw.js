//아이디 찾기 비밀번호 찾기 누르면 굵기 굵게
window.addEventListener('DOMContentLoaded', function() {
  // Find the menu items
  var findIdMenu = document.querySelector('.findMenu li:nth-child(1)');
  var pwFindMenu = document.querySelector('.findMenu li:nth-child(2)');

  // Add click event listeners to the menu items
  findIdMenu.addEventListener('click', function() {
    // Remove the "bold" class and reset the font color from the "비밀번호 찾기" menu item
    pwFindMenu.classList.remove('bold');
    pwFindMenu.style.color = ''; // Reset the font color to default

    // Add the "bold" class and set the font color to #8456FF for the "아이디 찾기" menu item
    findIdMenu.classList.add('bold');
    findIdMenu.style.color = '#8456FF';
    
    // Additional code specific to the "아이디 찾기" page
    // ...
  });

  pwFindMenu.addEventListener('click', function() {
    // Remove the "bold" class and reset the font color from the "아이디 찾기" menu item
    findIdMenu.classList.remove('bold');
    findIdMenu.style.color = ''; // Reset the font color to default

    // Add the "bold" class and set the font color to #8456FF for the "비밀번호 찾기" menu item
    pwFindMenu.classList.add('bold');
    pwFindMenu.style.color = '#8456FF';
    
    // Additional code specific to the "비밀번호 찾기" page
    // ...
  });
});

