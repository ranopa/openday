//메뉴 외 클릭시 메뉴 닫히게
document.addEventListener('click', function(e) {
    var menu = document.getElementById('menu');
    var includeWrapper = document.getElementById('includeWrapper');
    var includeHeader = document.getElementById('includeHeader');
    
    // 클릭된 요소가 header나 menu 내에 있는지 확인합니다.
    var isHeaderElement = includeHeader.contains(e.target);
    var isMenuElement = menu.contains(e.target);
    
    // 클릭이 header와 menu 외부에서 발생한 경우, 메뉴를 숨깁니다.
    if (!isHeaderElement && !isMenuElement) {
        menu.style.display = 'none';
    }
});