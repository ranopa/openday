<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
    window.onload=()=>{
        
        var writeBtn = document.querySelector('#adm-notice #write-btn');
             writeBtn.addEventListener('click',()=>{
      	    location.href="admnoticewrite";
      	})
                var btns = document.querySelectorAll('.btnss');
                btns.forEach(b=>{
                    b.addEventListener('click',()=>{
                        btns.forEach(bb=>{
                        if(bb.classList.contains('hover-color')){
                            bb.classList.remove('hover-color');
                        } 
                        b.classList.add('hover-color'); 
                    })
                
                    //$.ajax
                }) 
            })
        }
     </script>
 <div id="adm-notice">
        <div class="container">
            <h2>공지</h2>
            <div class="btns"> 
                <button type="button" id="all-btn" class="btnss" value="전체">전체</button>
                <button type="button" id="tchc-btn" class="btnss" value="강사공지">강사공지</button>
                <button type="button" id="nomal-btn" class="btnss" value="일반공지">일반공지</button>
            </div>

            <table class="table">
                <thead>
                    <tr class="th-color">
                        <th class="td1">NO</th>
                        <th class="td2">제목</th>
                        <th class="td3">조회수</th>
                        <th class="td4">작성일</th> 
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="td1">1123</td>
                        <td class="td2"><a href="admnoticedetail"><p class="ellipsis">제가 원데이 클래스를 개설하려고 하는데요 어쩌고 저쩌고 그런데 말입니다 예라이나쁜넘아~</p></a></td>
                        <td class="td3">123354</td>
                        <td class="td4">2023-05-24</td>
                    </tr>
                    <tr>
                        <td class="td1">1123</td>
                        <td class="td2"><a href="admnoticedetail"><p class="ellipsis">제가 원데이 클래스를 개설하려고 하는데요 어쩌고 저쩌고 그런데 말입니다 예 그런것입니다</p></a></td>
                        <td class="td3">123354</td>
                        <td class="td4">2023-05-24</td>
                    </tr>
                    <tr>
                        <td class="td1">1123</td>
                        <td class="td2"><a href="admnoticedetail"><p class="ellipsis">제가 원데이 클래스를 개설하려고 하는데요 어쩌고 저쩌고 그런데 말입니다 예</p></a></td>
                        <td class="td3">123354</td>
                        <td class="td4">2023-05-24</td>
                    </tr>
                     
                </tbody>
            </table>
            <div class="write-box">
                <button type="button" id="write-btn" class="write-btn">공지작성</button> 
            </div>
        </div>
    </div>