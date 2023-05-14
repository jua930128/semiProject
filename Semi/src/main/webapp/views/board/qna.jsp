
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
    <title>커뮤니티 리뷰</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ path }/resources/css/qna.css">

</head>

<section>

    <div>
        <div class="container">
        <h1 style="margin-bottom: 50px;">직접 문의하기</h1>


    
    <table class="table table-hover text-center">
        <thead style="border-top: 1px solid;" >
            <tr id="td-top"  >
                <td id="titlenum" ><b>번호</b></td>
                <td id="title1" >제목</td>
                <td id="titledate">작성일</td>
                <td id="titlewriter">작성자</td>
                <td id="titlecheck">답변여부</td>
                <td id="titleview" ></td>
            </tr>
        </thead>
        <tbody style="border-bottom: 1px solid gray; ">
        	
        	<c:if test="${ empty list }">
	            <tr>
	                <td></td>
	                <td id="boardtitle"><b>조회 가능한 게시글이 없습니다.</b></td>
	                <td></td>
	                <td></td>
	                <td></td>
	            </tr>
        	</c:if>
       		 <c:if test="${ not empty list }">
       		 	<c:forEach var="qna" items="${ list }" >
		            <tr>
		                <td>${ qna.no }</td>
		                <td id="titlecolor"><a style="text-decoration: none; color:black" href="${ path }/board/qnaboard?no=${qna.no}">
									${ qna.title }</a></td>
		                <td>${ qna.date }</td>
		                <td>${ qna.writer }</td>
		                <c:choose>
		                	<c:when test="${ qna.check eq 'Y' }">
				                <td><img  width="20px" height="20px" src="../resources/images/qna_check.png"></td>
		                	</c:when>
		                	<c:when test="${ qna.check eq 'N'}">		                
		                	<td><img  width="20px" height="20px" src="../resources/images/qna_check_n.png"></td>
		                	</c:when>
		          		
		                </c:choose>

		            </tr>
       		    </c:forEach>
        	</c:if>
        	
            


            
        </tbody>
        
        
    </table>
    
    <table style="width: 100%; ">
        
            <tr>
                    <th style="width: 30%;">
                        <div id="search">
                            <select id="searchdropbox" name="searchType" >
                                <option value="searchtitle">제목</option>
                                <option value="searchwriter">작성자</option>    
                            </select>
                            <input type="text" id="typesearch" name="typesearch" >
                            <button type="submit" id="btnsearch">검색</button>
                        </div>
                    </th>
            
                    <th id="pageNumber"  style="width: 40%; text-align: center;">
                        <p >
                            <button type="button" class="btn btn-default btn-sm" onclick="location.href='${path}/board/qna?page=1'" >&lt;&lt;</button>
                            <button type="button" class="btn btn-default btn-sm" onclick="location.href='${path}/board/qna?page=${ pageInfo.prevPage }'" >&lt;</button>
                            <c:forEach begin="${ pageInfo.startPage }" end="${ pageInfo.endPage }" varStatus = "status" >
                				<c:choose>
	                			<c:when test="${ status.current == pageInfo.currentPage }">
									<button disabled class="btn btn-default btn-sm" >${ status.current }</button>
								</c:when>
								<c:otherwise>
		                			<button type="button" class="btn btn-default btn-sm" onclick="location.href='${path}/board/qna?page=${ status.current }'" >${ status.current }</button>
								</c:otherwise>
                				</c:choose>
                			</c:forEach>
                            <button type="button" class="btn btn-default btn-sm" onclick="location.href='${path}/board/qna?page=${ pageInfo.nextPage }'" >&gt;</button>
                			<button type="button" class="btn btn-default btn-sm" onclick="location.href='${path}/board/qna?page=${ pageInfo.maxPage }'" >&gt;&gt;</button>
                        </p>
                    </th>
                <td>
<%--                 	<c:if test="${ not empty loginMember }"> --%>
                    		<button id="btnwrite" style="width: 70px" onclick="location.href='${path}/board/writeqna'">글쓰기</button>
<%--                     </c:if> --%>
                </td>
        
            </tr>
    
    </table>






    </div>
</div>
</section>
<script>
	$(document).ready(()=>{
		$('#btnsearch').on('click', ()=>{
		var type = document.getElementById('searchdropbox');
		var searchType = type.options[type.selectedIndex].value;
		var searchText = document.getElementById('typesearch').value;
		
// 		alert(searchType);
// 		alert(searchText);

		location.href='${path}/board/qnasearch?searchType=' + searchType +'&searchText='+searchText;
		});
	});
</script>
<jsp:include page="/views/common/footer.jsp"/>
    