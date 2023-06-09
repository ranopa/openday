  window.onload=()=>{
  
  
  
  var fileInp = document.querySelector('#file');
                        var fileLbl = document.querySelector('#file-label');
                        fileInp.addEventListener("change", function (event) {
                            var file = event.target.files[0];
                            fileLbl.textContent = file.name;
                        });
  }