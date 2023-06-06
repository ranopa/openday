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
        };