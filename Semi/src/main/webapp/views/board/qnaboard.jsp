<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/views/common/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>커뮤니티 후기 게시글</title>
    <link rel="stylesheet" href="${ path }/resources/css/qnaboard.css">
    <link rel="stylesheet" href="${ path }/resources/css/main.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    
</head>
<body>
    <head>

    </head>
	<div id="pagecontainer">
    <section>
        <div class="container" id="container" >
        	<div id="content-wrap">
            <h1>직접 문의하기</h1>
            
            <br>
            <hr class="thick">
            <br>
            <div>
                <p><h2>${qna.no}.  ${ qna.title }</h2></p>
                <br><br><br>
                <div id="divwrap1">
                    <p class="wrapp" id="warpp1">작성자 : ${ qna.writer }</p>

                    <p class="wrapp">작성일 : ${ qna.date }</p>
                    
                    		                <c:choose>
		                	<c:when test="${ qna.check eq 'Y' }">
				                <p id="answer">답변 여부 : <img  width="20px" height="20px" src="../resources/images/qna_check.png"></p>
		                	</c:when>
		                	<c:when test="${ qna.check eq 'N'}">		                
		                	<p id="answer" >답변 여부 : <img  width="20px" height="20px" src="../resources/images/qna_check_n.png"></p>
		                	</c:when>
		          		
		                </c:choose>
                </div>
                
                <br>
                <hr class="thick">
                <div id="content">${ qna.content }</div>
<!--                 <textarea  id="content" cols="160" rows="20" readonly >게시글 내용</textarea> -->
                
                <hr class="thick">

                <table>
                    
                    <tr id="reply"  >
                        <th id="writer">작성자</th>
                        <th id="replys">답변</th>
                        <th id="date">작성일자</th>
                    </tr>
				<c:forEach var="reply" items="${ qna.qnaReply }">
                    <tr id="replybox">
                        <td id="boxwriter" >${ reply.userId }</td>
                        <td id="boxreply">${ reply.reply_con }</td>
                        <td id="boxdate">${ reply.reply_date }</td>                        
                    </tr>
				</c:forEach>

                </table>
            </div>
            <div id="commentwirte">
            	<!--  로그인 구현시 user1234 대신 loginmember.id 넣기 -->
                <p id="writerid">admin</p>
                <form action="${path}/board/qnareply" method="POST" >
              	  <input type="hidden" name="qna_no" value="${ qna.no }">
                    <textarea name="commentbox" id="commentbox" cols="100" rows="4" placeholder="답변을 입력하세요." ></textarea>
                    <button type="submit" id="btncomment">답변 작성하기</button>
                    
                </form>
            </div>

            <div id="btnbottom">
                
                <button type="button" class="btn btn-primary btn-sm" id="btn-delete">삭제</button>
                <button type="button" class="btn btn-primary btn-sm" id="btn-update" onclick="location.href='${path}/board/qnaupdate?no=${ qna.no }'" >수정</button>
                <button type="button" class="btn btn-primary btn-sm" id="btn-title" onclick="location.href='${path}/board/qna'" >목록</button>

                
                
            </div>
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
    <script >
    $(document).ready(()=>{    	
		$('#btn-delete').on('click', ()=>{
			if(confirm('게시글을 삭제 하시겠습니까?')){
				location.replace('${path}/qnaboard/delete?no=${ qna.no }');
					
			}
			
		})
		
    });
    </script>
</body>
</html>

