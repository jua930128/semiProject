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
    <title>커뮤니티 직접 문의하기 목록</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ path }/resources/css/main.css">
    <link rel="stylesheet" href="${ path }/resources/css/reviewboard.css">

</head>
<body>
    <head>

    </head>

    <div id="pagecontainer">
    <section>
        <div class="container" id="container">
            <h1>후기</h1>
            
            <br>
            <hr class="thick">
            <br>
            <div>
                <div id="titlewrap">
                    <p id="roomnumber">${ review.room_name }</p>
                    <p id="title"><h2>${review.no}.  ${ review.title }</h2></p>
                </div>
                    <br><br>
                <div id="divwrap1">
                    <p class="wrapp" id="warpp1">작성자 : ${ review.writer }</p>

                    <p class="wrapp">작성일 : ${ review.date }</p>
                    
                    <p class="wrapp" id="visit" >조회수 : ${ review.revivewview }</p>
                    
                    <p class="wrapp" id="rate">별점 : ${ review.rate }</p>
                </div>
                
                <br>
                <hr class="thick">
                
                <div id="content">${review.content }</div>
                
                <hr class="thick">

                <table>
                    
                    <tr id="reply"  >
                        <th id="writer">작성자</th>
                        <th id="replys">답변</th>
                        <th id="date">작성일자</th>
                        <th id="delete"></th>
                        
                    </tr>
                    
				<c:forEach var="reply" items="${ review.reviewReply }">
                    <tr id="replybox">
                        <td id="boxwriter">${ reply.userId }</td>
                        <td id="boxreplys">${ reply.replyContent }</td>
                        <td id="boxdate">${ reply.replyDate }</td>  
                        <td  ><button id="boxdelete" disabled >삭제</button></td>
                    	
                    </tr>
                </c:forEach>    
                </table>
            </div>

            <div id="commentwirte">
            	<!--  로그인 구현시 user1234 대신 loginmember.id 넣기 -->
                <p id="writerid">user1234</p> 
                <form action="${path}/board/reviewreply" method="POST">
                	<input type="hidden" name="review_no" value="${ review.no }">
                    <textarea name="commentbox" id="commentbox" cols="100" rows="4" placeholder="댓글을 입력하세요." ></textarea>
                    <button type="submit" id="btncomment">댓글 작성하기</button>
                    
                </form>
            </div>
            

            <div id="bottom">
                <div id="pp">
                	<c:if test="${ not empty preReview }">
    	                <button id="btnpp" class="btn btn-secondary" onclick="location.href='${path}/board/reviewboard?no=${ preReview.no }'">이전 글</button>
	                    <label for="btnpp" id="pptitle">${ preReview.title }</label>
                	</c:if>
                	<c:if test="${ empty preReview }">
						<button id="btnpp" class="btn btn-secondary" disabled="disabled">이전 글</button>
	                    <label for="btnpp" id="pptitle">이전 게시글이 없습니다.</label>
                		
                	</c:if>
                
                </div>
                <hr class="thick">
                <div id="np">
                <c:if test="${ not empty nextReview }">
                    <button id="btnnp" class="btn btn-secondary" onclick="location.href='${path}/board/reviewboard?no=${ nextReview.no }'">다음 글</button>
                    <label id="nptitle" for="btnnp">${ nextReview.title }</label>
                </c:if>
                <c:if test="${ empty nextReview }">
                    <button id="btnnp" class="btn btn-secondary" disabled="disabled" >다음 글</button>
                    <label id="nptitle" for="btnnp">다음 게시글이 없습니다.</label>
                </c:if>
             	
                </div>
            </div>


            <div id="btnbottom">
                <button type="button" class="btn btn-primary btn-sm" id="btn-write" onclick="location.href='${path}/board/writereview'" >글쓰기 </button>  
                <button type="button" class="btn btn-primary btn-sm" id="btn-delete" >삭제</button>
                <button type="button" class="btn btn-primary btn-sm" id="btn-update" onclick="location.href='${path}/board/reviewupdate?no=${ review.no }'" >수정</button>
                <button type="button" class="btn btn-primary btn-sm" id="btn-title" onclick="location.href='${path}/board/review'" >목록</button>

                
                
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
				location.replace('${path}/reviewBoard/delete?no=${ review.no }');
					
			}
			
		})
		
		$('#boxdelete').on('click', ()=>{
			if(confirm('댓글을 삭제 하시겠습니까?')){
				location.replace('${path}/reviewreply/delete?no=${ reviewreply.no }');
			}
			
		});
		
    });
    </script>
</body>
</html>


    