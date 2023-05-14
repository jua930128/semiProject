<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="path" value="${ pageContext.request.contextPath }" />


<jsp:include page="/views/common/header.jsp" />
<script src="${ path }/resources/js/jquery-3.6.3.js"></script>
<script src="${ path }/resources/js/room.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

<script type="text/javascript">
	
</script>
<script>
	$(function() {
		$("#checkInDate").datepicker({
			minDate : 0,
			maxDate : "+1M"
		});
		$("#checkOutDate").datepicker({
			minDate : +1,
			maxDate : "+1M"
		});

		console.log(checkInDate);

	});
</script>


<style>
#section {
	width: 1200px;
	height: auto;
	align: center;
	margin: auto;
	margin-top: 50px;
	margin-bottom: 100px;
	/* border: 1px solid rgb(255, 153, 0); */
}

/* 컨텐츠 전체 영역1 */
#contents1 {
	/* border: 1px solid; */
	height: auto;
	width: 1100px;
	margin: 0px 40px 0px 40px;
}

#content1 {
	/* border: 3px solid yellowgreen; */
	display: flex;
}
/* 컨텐츠 분리된 영역1 */
.containerL {
	flex: 80%;
}

.containerR {
	margin-top: 5px;
}

.conUp {
	/* border: 1px solid brown; */
	height: 70px;
}

.con1, .con2 {
	/* border: 1px solid hotpink; */
	height: 35px;
	width: 100%;
	display: flex;
}

.con1>div {
	/* border: 1px solid rgb(166, 166, 239); */
	text-align: center;
	color: gray;
	font-size: 14px;
}

.con2>div {
	/* border: 1px solid rgb(166, 166, 239); */
	text-align: center;
	font-size: 18px;
	font-weight: 600;
	line-height: 40px
}

.con1>#conList1, #conList3 {
	width: 70%;
	padding-left: 10px;
	padding-right: 10px;
}

.con2>#conList1, #conList3 {
	width: 70%;
	padding-left: 10px;
	padding-right: 10px;
}

.con1>#conList2, #conList4, #conList5, #conList6, #conList7 {
	width: 30%;
}

.con2>#conList2, #conList4, #conList5, #conList6, #conList7 {
	width: 30%;
}

/* 객실 인원 날짜 검색 버튼 */
#conSearch {
	margin-left: 50px;
	border: 0;
	background-color: transparent;
}

#conSearch>a {
	display: inline-block;
	background-color: hsl(0, 0%, 27%);
	border-radius: 5px;
	text-decoration-line: none;
	padding: 7px 35px;
	margin: 0;
	font-size: 16px;
	color: #FFF;
	border: 0;
}

.conDown {
	/* border: 1px solid rgb(34, 241, 203); */
	display: flex;
}

#dayCount {
	border: 0px solid gainsboro;
	height: 30px;
	width: 50px;
	margin-left: 5px;
	margin-right: 5px;
	font-size: 18px;
}

#dayCount:hover {
	border: 2px solid gainsboro;
	/* background-color: gainsboro; */
	height: 30px;
	width: 50px;
	margin-left: 5px;
	margin-right: 5px;
	font-size: 18px;
}

/* 검색창 */
#containerD1, #containerD3 {
	/* border: 1px solid rgb(62, 120, 58); */
	flex: 1;
}

#containerD2 {
	width: 500px;
	height: auto;
	padding-left: 10px;
	border: 1px solid gray;
	border-radius: 5px;
}

#downSearch {
	width: 420px;
	height: 20px;
	padding: 5px;
	outline: none;
	float: left;
	border: 0;
}

#downSearchBtn {
	width: 60px;
	height: 34px;
	float: right;
	border: 0;
	border-radius: 0px 4px 4px 0px;
	background-color: gray;
	color: #FFF;
}

/* 체크인 체크아웃 박스 */
#checkInDate, #checkOutDate {
	height: 30px;
	font-size: 16px;
	border: 0px;
}

#checkInDate:hover, #checkOutDate:hover {
	border: 2px solid gainsboro;
	/* background-color: gainsboro; */
	height: 30px;
	margin-left: 5px;
	margin-right: 5px;
}

/* 인원수 늘어나는 블럭 공백 없애기 */
.field {
	margin: 0;
	padding: 0;
	border: 0;
}

.fieldP {
	margin-bottom: 0;
	margin: 0;
	padding: 0;
}

#number {
	border: 0px solid gainsboro;
	height: 30px;
	width: 50px;
	margin-left: 5px;
	margin-right: 5px;
	font-size: 18px;
}

#number:hover {
	border: 2px solid gainsboro;
	/* background-color: gainsboro; */
	height: 30px;
	width: 50px;
	margin-left: 5px;
	margin-right: 5px;
	font-size: 18px;
}

#hr1 {
	height: 5px;
	background-color: gray;
}

/* 컨텐츠 전체 영역2 */
#contents2 {
	/* border-top: 1px solid rgb(255, 230, 0); */
	/* border-bottom: 1px solid rgb(255, 230, 0); */
	padding-left: 20px;
	padding-right: 20px;
}
/* 컨텐츠 분리된 영역2 */
#content2, #content3, #content4 {
	/* border: 1px solid black; */
	height: auto;
	display: flex;
	/* padding: 20px; */
	margin: 50px;
}

/* 컨테이너 왼쪽 */
.container1, .container3, .container5 {
	/* border: 1px solid rgb(34, 0, 255); */
	height: 300px;
	width: 30%;
	display: flex;
	flex: 1;
	text-align: center;
}

/* 컨테이너 오른쪽 */
.container2, .container4, .container6 {
	/* border: 1px solid rgb(255, 0, 0); */
	height: 300px;
	flex: 2;
	/* background-color: rgb(221, 253, 226); */
	text-align: center;
	/* margin-left: 20px; */
}

/* 컨테이너 공백 영역 gap1(위) gap2(중간) gap3(아래) */
.gap1 {
	display: flex;
	height: 25%;
}

.gap2 {
	height: 75%;
	display: flex;
}

.gap3 {
	flex: auto;
}

.gap3 {
	flex: auto;
}

/* 시크릿 특가 태그(상자) */
.priceTag1 {
	display: inline-block;
	background-color: hsl(24, 86%, 55%);
	padding-left: 20px;
	padding-right: 20px;
	margin: 20px;
	margin-left: 80px;
	font-weight: 600;
	font-size: 14px;
	line-height: 35px;
	color: #FFF;
	clear: both;
}

/* 시크릿 특가 오른쪽 공백 */
#star1 {
	flex: 60%;
}

/* 시크릿 특가 오른쪽 즐겨찾기버튼 */
#star2 {
	flex: auto;
	/* border: 1px solid black; */
}

.heart1 {
	font-size: 24px;
	color: gray;
	text-decoration: none;
	line-height: 50px;
}

.heart1:active {
	color: red;
}

/* 객실 이름 (왼쪽 영역) */
.leftName {
	/* border: 1px solid; */
	padding-left: 80px;
	padding-top: 30px;
	width: 45%;
	height: 100%;
	font-weight: 700;
	text-align: left;
}

.leftName_roomNameKo {
	font-weight: 800;
	font-size: 24px
}

.leftName_roomNameEn {
	color: rgb(70, 70, 70);
	font-size: 18px
}

.leftName_roomArea {
	/* border: 1px solid; */
	margin-top: 25px;
	font-weight: 100;
	font-size: 14px
}

/* 객실 이름 (오른쪽 영역) */
.rightName {
	/* border: 1px solid; */
	height: 100%;
	flex: auto;
}

/* 오른쪽 객실 공백 + 가격 */
.rightName_gap {
	height: 75%;
	/* border: 1px solid; */
}

.rightName_price {
	/* padding: 10px; */
	text-align: right;
	display: flex;
}

/* 가격 태그 */
.priceTag2 {
	width: 53%;
	text-align: center;
	font-size: 22px;
	font-weight: 900;
	line-height: 40px;
}

/* 예약하기 버튼 */
.priceTag3 {
	border: 0;
	background-color: transparent;
}

.priceTag3>a {
	display: inline-block;
	background-color: hsl(0, 0%, 27%);
	border-radius: 5px;
	padding: 10px 30px;
	text-decoration-line: none;
	/* margin-right: 15px; */
	font-weight: 500;
	font-size: 20px;
	color: #FFF;
	border: 0;
}

#heightBottom {
	height: 100px;
}
</style>











<section id="section">
	<div id="contents1">
		<div id="content1">
			<div class="containerL">
				<div class="conUp">
					<div class="con1">
						<div id="conList1">체크인</div>
						<div id="conList2">▪</div>
						<div id="conList3">체크아웃</div>
						<div id="conList4">객실</div>
						<div id="conList5">성인</div>
						<div id="conList6">어린이</div>
						<div id="conList7">유아</div>
					</div>
					<form action="${ path }/room/roomList" method="get">
						<div class="con2">
							<div id="conList1">

								<input type="text" id="checkInDate" option value="yy-mm-dd"
									style="text-align: center;" eadonly="readonly">
								<!-- 								<label for="date"> <input type="date" id="checkInDate" name="checkInDate" max="2025-01-01" required> -->
								<!-- 								</label> -->
							</div>
							<div id="conList2">
								<fieldset class="field">
									<p class="fieldP">
										<label for="number"></label><input type="number" id="dayCount"
											readonly style="text-align: center;" />박
									</p>
								</fieldset>
							</div>
							<div id="conList3">
								<input type="text" id="checkOutDate" option value="yy-mm-dd"
									style="text-align: center;" eadonly="readonly">
								<!-- 								<label for="date"> <input type="date" id="checkOutDate" name="checkOutDate" max="2025-01-01" required> -->
								<!-- 								</label> -->
							</div>
							<div id="conList4">1</div>
							<div id="conList5">
								<fieldset class="field">
									<p class="fieldP">
										<label for="number"></label><input type="number" min="2"
											max="12" step="1" value="2" id="number"
											style="text-align: center;" />
									</p>
								</fieldset>
							</div>
							<div id="conList6">
								<fieldset class="field">
									<p class="fieldP">
										<label for="number"></label><input type="number" min="0"
											max="12" step="1" value="0" id="number"
											style="text-align: center;" />
									</p>
								</fieldset>
							</div>
							<div id="conList7">
								<fieldset class="field">
									<p class="fieldP">
										<label for="number"></label><input type="number" min="0"
											max="12" step="1" value="0" id="number"
											style="text-align: center;" />
									</p>
								</fieldset>
							</div>
						</div>
				</div>
			</div>
			<div class="containerR">
				<button type="search" id="conSearch">
					<a>검 색</a> <input type="submit" hidden>
				</button>
				</form>
			</div>
		</div>
		<hr id="hr1" />
		<div class="conDown">
			<div id="containerD1"></div>
			<div id="containerD2">
				<button id="downSearchBtn" type=submit>검색</button>
				<input type="text" id="downSearch" placeholder="객실명을 입력하세요.">
			</div>
			<div id="containerD3">검색창3</div>
		</div>

	</div>
	<hr />
	<div id="contents2">


		<c:forEach var="roomDate" items="${ listDate }">
			<div id="content2">
				<div class="container1">
					<c:choose>
						<c:when test="${ roomDate.roomPrice == 300000 }">
							<img id="roomImg1"
								src="${ path }/resources/images/AdobeStock_446772551.jpeg"
								style="width: 400px">
						</c:when>
						<c:when test="${ roomDate.roomPrice == 400000 }">
							<img id="roomImg1"
								src="${ path }/resources/images/AdobeStock_353147504.jpeg"
								style="width: 400px">
						</c:when>
						<c:when test="${ roomDate.roomPrice == 500000 }">
							<img id="roomImg1"
								src="${ path }/resources/images/AdobeStock_300373068.jpeg"
								style="width: 400px">
						</c:when>
					</c:choose>
				</div>
				<div class="container2">
					<div class="gap1">
						<div class="priceTag1">시크릿 특가</div>
						<div id="star1"></div>
						<div id="star2">
							<p>
								<a class="heart1" href="#">♡</a>
							</p>
						</div>
					</div>
					<div class="gap2">

						<div class="leftName">
							<div class="leftName_roomNameKo">
								<c:out value="${ roomDate.roomKrName }"></c:out>
							</div>
							<div class="leftName_roomNameEn">
								<c:out value="${ roomDate.roomEnName }"></c:out>
							</div>
							<div class="leftName_roomArea">
								<c:out value="${ roomDate.roomInfo }"></c:out>
							</div>
						</div>
						<div class="rightName">
							<div class="rightName_gap">
								<!-- 공백~~~~ -->
							</div>
							<div class="rightName_price">
								<div class="priceTag2">
									<!-- 돈단위 바꿈 -->
									<fmt:formatNumber value="${ roomDate.roomPrice }"
										type="currency" currencySymbol="KRW " />
								</div>
								<button class="priceTag3">
									<c:choose>
										<c:when test="${ roomDate.roomPrice == 300000 }">
											<a href="${ path }/room/roomA">예약하기</a>
										</c:when>
										<c:when test="${ roomDate.roomPrice == 400000 }">
											<a href="${ path }/room/roomB">예약하기</a>
										</c:when>
										<c:when test="${ roomDate.roomPrice == 500000 }">
											<a href="${ path }/room/roomC">예약하기</a>
										</c:when>
									</c:choose>
								</button>
							</div>
						</div>

					</div>
					<div class="gap3">
						<!-- 공백~~~~ -->
					</div>
				</div>
			</div>
			<hr />
		</c:forEach>



	</div>
	<div class="gap3">
		<!-- 공백~~~~ -->
	</div>






	<hr />
	<div id="heightBottom"></div>



</section>













<jsp:include page="/views/common/footer.jsp" />