<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/views/common/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <title>커뮤니티 리뷰 글쓰기</title>
    <script src="https://cdn.ckeditor.com/ckeditor5/36.0.1/classic/ckeditor.js"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/translations/ko.js"></script>
    <link rel="stylesheet" href="${ path }/resources/css/writeqna.css">

</head>
<body>
	<div id="pagecontainer">
    <section>

        <div class="container">
            <h1>직접 문의하기 수정</h1>
            
            <hr>
                
            <div id="wrap">

                <form action="${path}/board/qnaupdate" method="POST" >
                	<input type="hidden" name="no" value="${ qna.no }" >
                    <div id="tooltop" >
                            <textarea  id="title" cols="40" rows="1" placeholder="제목" name="title" >${ qna.title }</textarea>
                            <textarea name="writer" id="writer" cols="20" rows="1" readonly>작성자 : ${ qna.writer }</textarea>

                    </div>

                    <textarea name="content" id="editor" >${ qna.content }</textarea>
                    <br>

                    <div id="toolbottom" >
                    
                        <button type="submit" id="btnsubmit" class="right">수정하기</button>
                        

                    
                    </div>
                
                </form>
            </div>
        </div>
    </section>
	<footer id="footer">
       <div id="footwrap">
          <div id="tel">T.1544-9970</div>
          	<ul id="footul">
                <li>주소: 서울특별시 강남구 테헤란로14길 6</li>
                <li>업체명: Semi'sPension</li>
                <li>대표자: 양진선</li>
                <li>사업자등록번호: 851-87-00622</li>
            </ul>
          <div id="cpr">Copyright © Semi'sPensionCorp. All Rights Reserved.</div>
       </div>
   	</footer>
  	</div>
    <script>
        ClassicEditor.create( document.querySelector( '#editor' ), {
        removePlugins: [ 'Heading' ],
        language: "ko"
        
        } );
    </script>
</body>
</html>