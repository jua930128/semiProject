<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${ path }/resources/js/jquery-3.6.3.js"></script>
<script src="${ path }/resources/js/main.js"></script>
<link rel="stylesheet" href="${ path }/resources/css/main.css">
</head>
<body>
    <header id="wrap">
        <!-- <div> -->
            <img id="mainimg" src="${ path }/resources/images/AdobeStock_251459815.jpeg">
        <!-- </div> -->
        <div id="loginbar">
            <a href="#">회원가입</a>
            <div></div>

            <a href="/Semi/login">로그인</a>

        </div>
        <div id="topbar">
            <ul id="topbar_ul">
                <li>
                    <a href="#">펜션소개</a>
                    <ul>
                        <li><a href="#">우리 펜션 소개</a></li>
                        <li><a href="#">오시는길</a></li>
                    </ul>
                </li>
                <li>
                    <a href="${ path }/room/roomList">예약하기</a>
                    <ul>
                        <li><a href="${ path }/room/roomList">객실예약</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">메인로고</a>
                </li>
                <li>
                    <a href="https://www.naver.com">커뮤니티</a>
                    <ul>
                        <li><a href="https://www.google.com">공지사항</a></li>
                        <li><a href="https://www.nexon.com">자주하는 질문</a></li>
                        <li><a href="${path}/board/qna">문의하기</a></li>
                        <li><a href="${path}/board/review">후기</a></li>

                    </ul>
                </li>
                <li><a href="#">마이페이지</a>
                    <ul>
                        <li><a href="#">회원정보</a></li>
                        <li><a href="#">예약확인</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </header>



<!-- </body> -->
<!-- </html> -->