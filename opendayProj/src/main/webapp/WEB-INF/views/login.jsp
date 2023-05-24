<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="loginWrapper">
<div class="contentWrapper">

<ul class="ipcontainer">
                        <li>
                        <span class="red">*</span>&nbsp;&nbsp;<input type="text" class="ipbox" id="userId" name="userId"
                            placeholder="아이디" required maxlength="15">
                        <input type="button" class="idcheck ck" id="idCheckBtn" value="중복확인">
                         </li>
                        <li>
                            <span class="red">*</span>&nbsp;&nbsp;<input type="password" class="ipbox" id="userPassword" name="userPassword"
                                placeholder="비밀번호" required maxlength="15">
                        </li>
</ul>


<div class="btns">
                <button type="button" class="cancel-btn">취소</button>
                <button type="submit" class="submit-btn">가입완료</button>
</div>

</div>
</div>
</body>
</html>