<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div id="notice-detail">
        <form action="admnoticedelete" method="get">
            <div class="w-modal">
                <div class="w-wrap"> 
                    <div class="w-txtbox"> 
                        <p class="w-p">정말 이 게시글을 삭제하시겠습니까?</p> 
                    </div>
                    <div class="w-btn-box">
                        <button type="button" class="w-submit-btn">취소하기</button>
                        <input type="submit" class="w-cancel-btn" value="삭제하기">
                    </div>
                </div>
            </div>
        </form>
        <div class="container">
            <h2>공지</h2>
            <div class="page">
                <form action="" , method="post">
                    <table class="table">
                        <tbody>
                            <tr>
                                <td class="td1 bold">유형</td>
                                <td colspan="2" class="radios t22">강사채널 공지</td>
                            </tr>
                            <tr>
                                <td class="td1 bold">제목</td>
                                <td colspan="3" class="td2 t22">안녕하시렵니까?</td>
                            </tr>
                            <tr>
                                <td class="td1 bold">첨부파일</td>
                                <td colspan="3"> <a href="${첨부파일경로}" download class="file-down"> ${첨부파일이름}
                                </td>
                            </tr>
                            <tr class="txtbox">
                                <td class="td1 bold">내용</td>
                                <td colspan="3" class="td2 txt-content">아무노래나일단틀어아무렇게나춤춰</td>
                            </tr>
                           
                        </tbody>
                    </table>
                    <div class="btn-par">
                        <button type="button" class="submit-btn btn2">목록으로</button>
                        <button type="button" class="submit-btn btn1" id="del-btn">삭제</button>
                    </div>

                </form>
            </div>
        </div>
        
    
    </div>
    
    