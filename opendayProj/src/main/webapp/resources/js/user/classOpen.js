// 썸네일
function readURL(input) {
  if (input.files && input.files[0]) {
    var reader = new FileReader();
    reader.onload = function(e) {
      var preview = document.getElementById('preview');

      var image = new Image();
      image.onload = function() {
        var maxWidth = 400; // .thumbnail-container의 최대 너비
        var maxHeight = 300; // .thumbnail-container의 최대 높이

        var width = image.width;
        var height = image.height;

        var aspectRatio = width / height;

        if (aspectRatio > maxWidth / maxHeight) {
          width = maxWidth;
          height = maxWidth / aspectRatio;
        } else {
          height = maxHeight;
          width = maxHeight * aspectRatio;
        }

        preview.style.width = width + 'px';
        preview.style.height = height + 'px';

        preview.style.backgroundImage = 'url("' + reader.result + '")';
        preview.style.backgroundSize = 'cover';
        preview.style.backgroundPosition = 'center';
        preview.style.backgroundColor = 'rgba(217, 217, 217, 1)';
        
        // 이미지를 미리보기로 설정합니다.
        preview.innerHTML = '';
        preview.appendChild(image);
        
          // 이미지를 가운데로 정렬합니다.
        var marginLeft = (maxWidth - width) / 2;
        preview.style.marginLeft = marginLeft + 'px';

        // 미리보기 이미지를 정중앙에 수직 정렬합니다.
        var marginTop = (maxHeight - height) / 2;
        preview.style.marginTop = marginTop + 'px';
      };

      image.src = reader.result;
    };
    reader.readAsDataURL(input.files[0]);
  } else {
    document.getElementById('preview').style.backgroundImage = "";
  }
}


// 토스트 ui
document.addEventListener("DOMContentLoaded", function() {
    const editor = new toastui.Editor({
        el: document.querySelector('#editor'),
        previewStyle: 'vertical',
        initialEditType: 'wysiwyg',
        initialValue: '커리큘럼을 작성해 주세요'
    });

    const saveButton = document.getElementById('classSubmit');
    saveButton.addEventListener('click', function() {
        const content = editor.getHTML(); // 에디터의 내용을 Markdown 형식으로 가져옴
    document.getElementById('hidden').value = content;
    });    
});

// 취소 버튼
$(function() {
	$('.cancel-btn').click(function() {
		location.href = './';
	});
});
