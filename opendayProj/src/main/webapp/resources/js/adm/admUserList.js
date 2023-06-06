window.onload = () => {


            var subBtns = document.querySelectorAll(".detail-btn");

            subBtns.forEach((btn) => {
                var hiddenUl = btn.parentElement.parentElement.nextElementSibling;
                btn.addEventListener('click', () => {
                    if (hiddenUl.classList.contains('show')) {
                        hiddenUl.classList.remove('show');
                    } else {
                        hiddenUl.classList.add('show');

                    }
                });
            });

            var tuBtns = document.querySelectorAll(".tu-btn");
            tuBtns.forEach(btn => {
                btn.addEventListener('click', () => {
                    tuBtns.forEach(btnn => { 
                        if (btnn.classList.contains('purple')) {
                            btnn.classList.remove('purple'); 
                        }
                    })
                    btn.classList.add('purple'); 
                    var strText = btn.value;

                    // $.ajax({

                    // })
                })
            })
        } 
