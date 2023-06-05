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

        * {
            margin: 0;
            padding: 0;
        }

        #background-color {
            width: 100vw;
            height: 100vh;
            background-color: rgb(241, 241, 241);
            position: absolute;
            z-index: -999;
        }

        #header h1,
        p,
        ul,
        li {
            color: white;
            list-style: none;
        }

        #header .to-main {}

        #header .white-header {
            width: 100vw;
            left: 0;
            top: 0;
            height: 70px;
            background-color: rgb(255, 255, 255);
            position: fixed; 
        }

        button {
            cursor: pointer;
        }

        a {
            text-decoration: none;
        }

        #header {
            width: 1280px; 
            margin: 0 auto;
        }

        #header #container {
            background-color: #7C4AFF;
            width: 300px;
            height: 100vh;
            margin-left: -5px;
            position: fixed;
            left: 0;
            top: 0;
        }

        #header #content {
            width: 88%;
            height: 80%;
            margin: 0 auto;
            padding-left: 40px;
            padding-top: 35px;
        }

        #header h1 {}

        #header p {
            font-size: 12px;
            margin-top: 10px;
        }

        #header .logo-box {
            width: 200px;
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
            width: 235px;
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
            margin-top: 20px;
            font-size: 2px;
            color: rgb(202, 202, 202);
        }
        #con{
            width:1280px;
            height: 800px;
            margin: 0 auto;
            border: 1px solid black; 
        }
    </style>
    <!-- content -->

</head>


<body>
    <div id="background-color">
        <div id="header">
            <div class="white-header">
                <a class="to-main">열어데이</a>
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
        <div id="클래스개설검토"></div>
    </div>

    <div id="con">
        

    </div>

</body>



</html>