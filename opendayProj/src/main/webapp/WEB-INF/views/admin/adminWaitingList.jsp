<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="<%=request.getContextPath() %>" />


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- header -->
    <style>
        @charset "UTF-8";

        @font-face {
            font-family: 'Cafe24Ohsquare';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/Cafe24Ohsquare.woff') format('woff');
            font-weight: normal;
            font-style: normal;
        }


        @font-face {
            font-family: 'NanumBarunGothic';
            font-style: normal;
            font-weight: 400;
            src:
                url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.eot');
            src:
                url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.eot?#iefix') format('embedded-opentype'),
                url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.woff') format('woff'),
                url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.ttf') format('truetype');
        }



        * {
            margin: 0;
            padding: 0;
            font-family: 'NanumBarunGothic';
        }

        /* 
        #background-color {
            width: 100vw;
            height: 100vh;
            background-color: rgb(241, 241, 241);
            position: absolute;
            z-index: -999;
        } */

        #header h1,
        p,
        ul,
        li {
            color: white;
            list-style: none;
        }

        #header h1{
            font-family: 'Cafe24Ohsquare';
        }

        #header .abox {
            width: 1210px;
            height: 70px;  
            display: flex;
            flex-direction: column;
            align-items: flex-end;
            justify-content: center;
            position:relative;
            left: 0;
        }

        #header .to-main {
            font-size: 24px;
            font-family: 'Cafe24Ohsquare';
            color: #7C4AFF;   
        }

        #header .white-header {
            position:fixed;
            width: 100vw;
            margin: 0 auto;
            height: 70px;
            background-color: rgb(255, 255, 255);
        }

        button {
            cursor: pointer;
        }

        a {
            text-decoration: none;
        }

        #header #container {
            background-color: #7C4AFF;
            width: 250px;
            height: 100vh;
            margin-left: -5px;
            position: fixed;
            left: 0;
            top: 0;
            z-index: 999;
        }

        #header #content { 
            margin: 0 auto;
            padding-left: 40px;
            padding-top: 35px;
        }

        #header p {
            font-size: 12px;
            margin-top: 10px;
        }

        #header .logo-box {
            width: 150px; 
            text-align: center;
            border-bottom: 1px solid rgb(168, 168, 168);
            padding-bottom: 20px;
        }

        #header .list-box {
            display: flex;
            flex-direction: column;
            margin-top: 33px;
            margin-left: 15px;
        }

        #header .f-list {
            margin-bottom: 30px;
        }

        #header .s-ul {
            font-weight: 400;
            font-size: 17px;
            font-weight: bold;
        }

        #header .s-li {
            width: 185px;
            height: 27px;
            font-weight: 400;
            font-size: 15px;
            margin-left: -50px;
            margin-top: 4px;
            padding-left: 60px;
            padding-top: 7px;
            transition: 0.1s linear;
        }

        #header .s-li:hover {
            background-color: white;
            color: #7C4AFF;
            font-weight: bold;
        }

        #header .footer { 
            margin-left: -23px;
            margin-top: 30px;
            font-size: 2px;
            color: rgb(202, 202, 202);
            
        }
    </style>
    <!-- content -->
    <style>
          
        #waiting {
            width: 100vw;
            height: 100vw;
            background-color: rgb(240, 240, 240);
        }

        #waiting .w-container {
            /* width: calc(1280-245)px;  */ 
            width:1035px;
            padding: 20px;
            margin: 0 auto;
            margin-left: 245px; 
        } 
        #waiting h2{  
           font-size: 24px;
           color: #7C4AFF;
           margin-top: 100px;
           margin-bottom: 50px;
           margin-left: 70px;
        }
        #waiting .table{ 
            width:900px;
            margin: 0 auto;
            text-align: center; 
            font-size: 14px;  
        } 
        #waiting tr{   
            margin-bottom: 15px;
            display: inline-block; 
            background-color: rgb(255, 255, 255);
            border-radius: 7px;      
        }
        #waiting th{  
            height: 50px; 
            color: rgb(68, 59, 59);  
        } 
        #waiting .th-color{
            background-color: rgb(223, 223, 223);
        }
      
        #waiting td{ 
            height: 60px;   
        } 
        #waiting .td1{
            width: 100px;
        }
        #waiting .td2{
            width: 500px;   
        }
        #waiting .td3{
            width: 250px;
        }
        #waiting .td4{
            width: 150px;
        }
        #waiting .td5{
            width: 200px;
        }
        #waiting .ellipsis{
            text-overflow: ellipsis;
            width: 90%; 
            margin: 0 auto; 
            color: black; 
            overflow: hidden;
            -webkit-box-orient: vertical;
            word-wrap: break-word;
            display: -webkit-box;
            -webkit-line-clamp: 1; 
            height: 1.2em;   
        }
        #waiting .a-box{
            width: 100%;
            height: 100%;
        }

    </style>


</head>


<body>
    <!-- adm header -->
    <div id="header">
        <div class="white-header">
            <div class="abox">
                <a href="#" class="to-main"> 열어데이&nbsp;&nbsp;></a>
            </div>
        </div>
        <div id="container">
            <div id="content">
                <div class="logo-box">
                    <h1>열어데이</h1>
                    <p>관리자페이지</p>
                </div>
                <ul class="list-box">
                    <li class="f-list">
                        <ul class="s-ul">
                            클래스 개설 검토
                            <a href="">
                                <li class="s-li">개설신청 목록</li>
                            </a>
                        </ul>
                    </li>
                    <li class="f-list">
                        <ul class="s-ul">
                            회원 관리
                            <a href="">
                                <li class="s-li">회원 목록</li>
                            </a>
                            <a href="">
                                <li class="s-li">클래스 목록</li>
                            </a>
                        </ul>
                    </li>
                    <li class="f-list">
                        <ul class="s-ul">
                            고객센터
                            <a href="">
                                <li class="s-li">문의</li>
                            </a>
                            <a href="">
                                <li class="s-li">공지</li>
                            </a>
                        </ul>
                    </li>
                    <li class="f-list">
                        <ul class="s-ul">
                            정산 및 매출
                            <a href="">
                                <li class="s-li">정산하기</li>
                            </a>
                            <a href="">
                                <li class="s-li">정산내역 조회</li>
                            </a>
                            <a href="">
                                <div class="s-li-div">
                                    <li class="s-li">매출 확인</li>
                                </div>
                            </a>
                        </ul>
                    </li>
                    <li class="footer">Copyright © OPENJO.All rights reserved.</li>
                </ul>
            </div>
        </div>
    </div> 

    <!-- adm content : waiting -->
    <div id="waiting">
        <div class="w-container">
            <h2>개설신청 목록</h2>
            <table class="table" >
                <thead>
                    <tr class="th-color">
                        <th class="td1">NO</th>
                        <th class="td2">클래스명</th>
                        <th class="td3">카테고리</th>
                        <th class="td4">신청자</th>
                        <th class="td5">등록일</th>
                    </tr>
                </thead>
                <tbody> 
                    <a href="#" class="a-box">  
                    <tr>
                        <td class="td1" >NO</td>
                        <td class="td2" ><p class="ellipsis">성빈 키우기 원데이 클래스성빈 키우기 원데이 클래스성빈 키우기 원데이 클래스성빈 키우기 원데이 클래스성빈 키우기 원데이 클래스성빈 키우기 원데이 클래스성빈 키우기 원데이 클래스성빈 키우기 원데이 클래스성빈 키우기 원데이 클래스성빈 키우기 원데이 클래스</p></td>
                        <td class="td3">향초/베이킹/디퓨저</td>
                        <td class="td4">llsbdm001</td>
                        <td class="td5">2023-05-07</td>
                    </tr>
                </a>
                    <tr>
                        <a href="#" class="a-box">  
                        <td class="td1" >NO</td>
                        <td class="td2">성빈 키우기 원데이 클래스</td>
                        <td class="td3">디퓨저</td>
                        <td class="td4">llsbdm001</td>
                        <td class="td5">2023-05-07</td>
                    </tr>
                </a>
                    <tr>
                        <td class="td1" >NO</td>
                        <td class="td2" >성빈 키우기 원데이 클래스</td>
                        <td class="td3">향초/디퓨저</td>
                        <td class="td4">llsbdm001</td>
                        <td class="td5">2023-05-07</td>
                    </tr>
                    <tr>
                        <td class="td1" >NO</td>
                        <td class="td2">성빈 키우기 원데이 클래스</td>
                        <td class="td3">향초/베이킹/디퓨저</td>
                        <td class="td4">llsbdm001</td>
                        <td class="td5">2023-05-07</td>
                    </tr>
                    <tr>
                        <td class="td1" >NO</td>
                        <td class="td2">성빈 키우기 원데이 클래스</td>
                        <td class="td3">향초/베이킹/디퓨저</td>
                        <td class="td4">llsbdm001</td>
                        <td class="td5">2023-05-07</td>
                    </tr>
                    <tr>
                        <td class="td1" >NO</td>
                        <td class="td2">성빈 키우기 원데이 클래스</td>
                        <td class="td3">향초/베이킹/디퓨저</td>
                        <td class="td4">llsbdm001</td>
                        <td class="td5">2023-05-07</td>
                    </tr>
                    <tr>
                        <td class="td1" >NO</td>
                        <td class="td2">성빈 키우기 원데이 클래스</td>
                        <td class="td3">향초/베이킹/디퓨저</td>
                        <td class="td4">llsbdm001</td>
                        <td class="td5">2023-05-07</td>
                    </tr>
                    <tr>
                        <td class="td1" >NO</td>
                        <td class="td2">성빈 키우기 원데이 클래스</td>
                        <td class="td3">향초/베이킹/디퓨저</td>
                        <td class="td4">llsbdm001</td>
                        <td class="td5">2023-05-07</td>
                    </tr>
                    <tr>
                        <td class="td1" >NO</td>
                        <td class="td2">성빈 키우기 원데이 클래스</td>
                        <td class="td3">향초/베이킹/디퓨저</td>
                        <td class="td4">llsbdm001</td>
                        <td class="td5">2023-05-07</td>
                    </tr> 
                </tbody>
            </table>
        </div>
    </div>

</body>



</html>