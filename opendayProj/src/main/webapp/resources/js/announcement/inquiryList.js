$(document).ready(function() {
  // 현재 URL
  var currentURL = window.location.href;

  // a 태그를 클릭했을 때 이벤트 처리
  $('.atag').each(function() {
    // 클릭된 a 태그의 href 속성값
    var linkURL = $(this).attr('href');

    // 현재 URL의 경로 부분과 클릭된 링크의 경로 부분이 동일한 경우에만 스타일 변경
    if (currentURL.endsWith(linkURL)) {
      $(this).css('color', 'black');
    }
  });

  // 페이지 로드 시 현재 URL을 기준으로 스타일 변경
  $('.atag').each(function() {
    var linkURL = $(this).attr('href');
    if (currentURL.endsWith(linkURL)) {
      $(this).css('color', 'black');
    }
  });
});


