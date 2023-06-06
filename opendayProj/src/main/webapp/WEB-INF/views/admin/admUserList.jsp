<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="user-list">
        <div class="sr-container">
            <h2>전체 회원 목록</h2>
            <form action="" method="get">
                <div class="search-box">
                    <diV class="search1">
                        <p class="s-p">회원 조회</p>
                        <input type="text" class="ip-box ipt" name="searchText" placeholder="아이디 / 닉네임 / 이름">
                        <button type="submit" class="sub-btn"><span class="material-symbols-outlined">
                                search
                            </span></button>
                        <button type="button" class="tu-both-btn tu-btn" value="전체">전체</button>
                        <button type="button" class="only-tchc-bun tu-btn" value="강사" >강사목록</button>
                        <button type="button" class="only-user-btn tu-btn" value="유저" >유저목록</button> 
                    </diV>
            </form>

        </div>
        <table class="table">
            <thead>
                <tr class="th-color">
                    <th class="td1">NO</th>
                    <th class="td2">아이디</th>
                    <th class="td3">닉네임</th>
                    <th class="td4">이메일</th>
                    <th class="td5">전화번호</th>
                    <th class="td6">가입일</th>
                    <th class="td7"></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="td1">41</td>
                    <td class="td2">tjdqls1227</td>
                    <td class="td3"><span class="host-badge">H</span>성빈찡vvvv</td>
                    <td class="td4">tjdqls12271@gmail.com</td>
                    <td class="td5">020-5480-6972</td>
                    <td class="td6">2023-05-12</td>
                    <td class="td7"><button type="button" id="detail-btn" class="detail-btn"><span
                                class="material-symbols-outlined icon2">
                                expand_more
                            </span></button>
                </tr>
                <tr class="sub-toggle">
                    <td>
                        <ul class="sub-table">
                            <ul class="sub-ul ul1">
                                <li>NO</li>
                                <li>강사닉네임</li>
                                <li>이름</li>
                                <li>계좌번호</li>
                                <li>등록일</li>
                            </ul>
                            <ul class="sub-ul">
                                <li>777</li>
                                <li>성빈아뜰리에</li>
                                <li>홍성빈</li>
                                <li>(부산)1122147594102</li>
                                <li>2023-06-06</li>
                            </ul>
                        </ul>
                    </td> 
                </tr>



            </tbody>
        </table>

    </div>