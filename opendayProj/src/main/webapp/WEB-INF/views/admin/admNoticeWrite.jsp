<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <div id="notice-write">
        <div class="container">
            <h2>공지 작성</h2>
            <div class="page">
                <form action="admannouncementwrite"  method="post" enctype="multipart/form-data"
			name="noticefile">
                    <table class="table">
                        <tbody>
                            <tr>
                                <td class="td1 bold">유형선택</td>
                                <td colspan="2" class="radios t22"><input type="radio" name="ancType" required class="radio" id="tchc-radio"><label for="tchc-radio" class="radio-lb">강사채널 공지</label>
                                    <input type="radio" name="ancType" required class="radio" id="user-radio"><label for="user-radio" class="radio-lb">일반 공지</label></td>
                            </tr>
                            <tr>
                                <td class="td1 bold">제목</td>
                                <td colspan="3" class="td2 t22"><input type="text" name="ancTitle"  maxlength="50" required class="title-ip"></td>
                            </tr>

                            <tr class="txtbox">
                                <td class="td1 bold">내용</td>
                                <td colspan="3" class="td2"><textarea type="text" name="ancContent" maxlength="1000"
                                        class="txtarea txt-ip" required> </textarea></td>
                            </tr>
                            <tr>
                                <td colspan="4" class="file-id" style="border-radius: 7px;"><input type="file"
                                        style="display: none" id="file" name="file">
                                    <label for="file" id="file-label"> 파일을 선택해 주세요</label>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="btn-par">
                        <button type="button" id="notice-write-cancel-btn" class="submit-btn btn1">취소</button>
                        <button type="submit" class="submit-btn btn2">등록</button>
                    </div>
                    <script>
                    	$('#notice-write-cancel-btn').click(()=>{
                    		location.href="admnoticelist";
                    	})
                    </script>

                </form>
            </div>
        </div>
    </div>
