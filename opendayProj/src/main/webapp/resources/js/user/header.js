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

  
   window.onload=()=>{
	   
        var alarmBtn = document.querySelector('.IconColor');
        var modalBtn = document.querySelector('#alarm');
       
        var userId = '${userId.userId}';

        alarmBtn.addEventListener('click',()=>{  
        	if(!modalBtn.classList.contains('show')){
                modalBtn.classList.add('show');
            }else{
                modalBtn.classList.remove('show'); 
            }
        })

   
        if (userId) {
            setInterval(function() {
            $.ajax({
              url: 'notification/'+userId,
              type:'get',
              contentType: 'application/json',
              success: function(data){
                $('#notiList li').remove();
                 if ($('#notiList li').length == 0) {
                  for(const noti of data) {
                    console.log(noti.ntfMessage)
                    $('#notiList').append(`
                      <li>
                        <a href="\${noti.ntfUrl}" class="a-a">
                        <span class="message">\${noti.ntfMessage}</span>
                        </a>
                      </li>
                      <li>
                        <button class="a-del-btn">
                          <span class="material-symbols-outlined">
                              close
                          </span>
                        </button>
                        <input type="hidden" id="ntfId" value="\${noti.ntfId}">
                      </li>
                    `);
                  }
                 }  
              }
            })
            },5*1000);
        }
        
       
        var delBtns = document.querySelectorAll('#alarm .a-del-btn');
        delBtns.forEach(btn=>{
            btn.addEventListener('click',()=>{
                var ipEl = btn.nextElementSibling.value.toString();
                console.log(ipEl); 
                var ulValue = btn.parentElement.parentElement;
                ulValue.remove();


                $.ajax({
                    url:"deletealarm",
                    type:'post',
                    data: {"ipEl":ipEl},
                    success:function(response){
                        console.log('success');
                    },
                    error:function(){
                        console.log('error');
                    }
                })
            })
        }) 
    }
        