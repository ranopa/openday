// 썸네일
function readURL(input) {
  if (input.files && input.files[0]) {
    var reader = new FileReader();
    reader.onload = function(e) {
      var preview = document.getElementById('preview');
      preview.src = reader.result;
    };
    reader.readAsDataURL(input.files[0]);
  } else {
    document.getElementById('preview').src = "";
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

    const saveButton = document.querySelector('#classSubmit');
    saveButton.addEventListener('click', function() {
        const content = editor.getMarkdown(); // 에디터의 내용을 Markdown 형식으로 가져옴
    });
});

// 취소 버튼
$(function() {
	$('#cancel-btn').click(function() {
		location.href = './';
	});
});
