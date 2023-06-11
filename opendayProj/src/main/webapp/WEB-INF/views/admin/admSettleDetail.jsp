<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div id="settle-detail">
        <div class="container">
            <h2>공지</h2>
            <div class="page">
                <!-- 정산번호 -->
                <input type="hidden" name="">
                <div class="receipt">
                    <div class="conbox">
                        <p class="phead">열어데이</p>
                        <div class="receipt-head">
                            <p>NO.3094</p>
                            <p>2023-05-21</p>
                        </div>
                        <p class="seperate">=========================================</p>
                        <div class="receipt=content">
                            <ul class="re-ul">
                                <li>
                                    *&nbsp;&nbsp;&nbsp;&nbsp;클래스명
                                </li>
                                <li>
                                    성빈아뜰리에
                                </li>
                            </ul>
                            <ul class="re-ul">
                                <li>
                                    *&nbsp;&nbsp;&nbsp;&nbsp;예금주
                                </li>
                                <li>
                                    홍성빈
                                </li>
                            </ul>
                            <ul class="re-ul">
                                <li>
                                    *&nbsp;&nbsp;&nbsp;&nbsp;계좌번호
                                </li>
                                <li>
                                    112-2147-5941-02
                                </li>
                            </ul>
                            <ul class="re-ul">
                                <li>
                                    *&nbsp;&nbsp;&nbsp;&nbsp;예상지급일
                                </li>
                                <li>
                                    2023-05-28
                                </li>
                            </ul>
                            <p class="seperate">=========================================</p>
                            <ul class="re-ul">
                                <li>
                                    *&nbsp;&nbsp;&nbsp;&nbsp;총 판매금액
                                </li>
                                <li>
                                    200,000
                                </li>
                            </ul>
                            <ul class="re-ul">
                                <li>
                                    *&nbsp;&nbsp;&nbsp;&nbsp;수수료
                                </li>
                                <li>
                                    20,000
                                </li>
                            </ul>
                            <p class="seperate">=========================================</p>
                            <ul class="re-ul">
                                <li>
                                    *&nbsp;&nbsp;&nbsp;&nbsp;최종정산금액
                                </li>
                                <li>
                                    180,000
                                </li>
                            </ul>  
                        </div>
                    </div>
                </div>
                <div class="btn-par">
                    <button type="button" class="submit-btn btn1" id="del-btn">돌아가기</button>
                    <button type="button" id="receipt-btn" class="submit-btn btn2">정산하기</button>
                </div>
            </div>

        </div>
        
        <script>
    $('#receipt-btn').click(() => {
        location.href = "settlesubmit"; 
        // $.ajax
    })
</script>