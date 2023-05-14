<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>

<jsp:include page="/views/common/header.jsp" />

<style>

#section {
    width: 1200px;
	height: auto;
    align: center;
    margin: auto;
    /* margin-top: 20px; */
    margin-bottom: 100px;
    /* border: 1px solid rgb(255, 153, 0); */
}

/* 펜션명 들어갈곳 */
.panNameKo {
    /* border: 1px solid tomato; */
    margin: auto;
    margin-top: 100px;
    width: 1200px;
    text-align: right;
    font-weight: 700;
    font-size: 32px
}
.panNameEn {
    /* border: 1px solid; */
    margin: auto;
    margin-bottom: 10px;
    width: 1200px;
    text-align: right;
    color: gray;
    font-size: 18px
}

/* 컨텐츠 위 이미지 영역1 */
#contents1 {
    margin: auto;
    height: 500px;
    width: 1200px;
    /* border: 1px solid rgb(26, 174, 16); */
}
#hr1 {
    margin-bottom: 0;
    margin-top: 0;
    margin-left: auto;
    margin-right: auto;
    width: 1200px;
    height: 5px;
    background-color: gray;
}

/* 컨텐츠 전체 영역2 */
#contents2 {
    /* border: 1px solid rgb(255, 230, 0); */
    /* border-bottom: 1px solid rgb(255, 230, 0); */
    padding-left: 20px;
    padding-right: 20px;
}
/* 컨텐츠 분리된 영역2 */
#content1 {
    /* border: 1px solid black; */
    height: auto;
    margin: 80px;
}

/* 이용안내 아래 큰글씨 영역 */
#content2 {
    /* border: 1px solid black; */
    height: auto;
    margin: 80px;
    margin-top: 200px;
    margin-bottom: 200px;
}



/* 펜션인기있는이유 원 사진영역 */
.guideTop2 {
    /* border: 1px solid rgb(178, 196, 242); */
    height: auto;
    margin-bottom: 20px;
    font-size: 24px;
    font-weight: 700;
    text-align: center;
}
.guideBottom2 {
    /* border: 1px solid rgb(255, 112, 184); */
    height: auto;
    width: 100%;
    display: flex;
}
.gBottomGrid {
    /* border: 1px solid rgb(247, 214, 131); */
    margin: auto;
}
#gBottom1 {
    /* border: 1px solid blue; */
    border-radius: 70%;
    margin-bottom: 20px;
    width: 200px;
    height: 200px;
}
#gBottom2 {
    /* border: 1px solid rgb(171, 171, 213); */
    width: 200px;
    font-size: 20px;
    text-align: center;
}

/* 세부정보 이름 */
.guideTop {
    /* border: 1px solid hotpink; */
    height: auto;
    margin-bottom: 20px;
    font-size: 20px;
    font-weight: 500;
    color: gray;
}
/* 세부정보 내용 */
.guideBottom {
    /* border: 1px solid hotpink; */
    height: auto;
    display: flex;
}
#BottomLeft {
    /* border: 1px solid rgb(38, 254, 22); */
    margin-right: 20px;
    line-height: 30px;
    color: gray;
}
#BottomRight {
    /* border: 1px solid rgb(38, 254, 22); */
    line-height: 30px;
    color: gray;
}

#gBottom3 {
    font-size: 20px;
    text-align: center;
}

/* 구매하기 */
.priceTagL {
    width:85%;
}
.priceTagR {
    border: 0;
    background-color: transparent;
}
.priceTagR > a {
    display: inline-block;
    background-color: hsl(24, 86%, 55%);
    border-radius: 5px;
    padding: 7px 25px;
    text-decoration-line: none;
    margin: 0;
    font-weight: 500;
    font-size: 18px;
    color: #FFF;
    border: 0;
}
#priceBottom {
    display: flex;
}


</style>



<script type="text/javascript">
rs.getString("roomname")
</script>






<%-- <form action="${ path }/room/roomA" method="get"> --%>
	    <div class="panNameKo">
	    	${ roomData["roomKrName"] } <br>
	    	
	    </div>
	    <div class="panNameEn">
	        ${ roomData.roomEnName }
	    </div>

    <hr id="hr1" />
    <div id="contents1">
        <img src="${ path }/resources/images/AdobeStock_397718225.jpeg"  style="width: 1200px; height: 500px;">
    </div>
    <hr id="hr1" />

    <!-- 섹션영역 -->
    <section id="section">
        <div id="contents2">
            <div id="content2">
                <div class="guideTop2">
                    그곳에 오직'우리'만을 위한 초대형 프라이빗 펜션
                    <c:out value="${ roomData.roomEnName }"></c:out>
                </div>
                <div class="guideBottom">
                    <div id="gBottom3">
                        이곳 세미네펜션은 3개의 방과 실내 자쿠지, 넓은 부엌이 있고 모든 방은 오션뷰로 이뤄져 있습니다. <br>
                        바로 앞에는 이곳의 자랑인 수심1m 길이12m의 수영장이 있는데 성인 10명이 함께 즐길수있는 큼직한 크기를 자랑합니다. <br>
                        넓은 정원에서 불멍도 빠질 수 없고, 노을이 지는 시간의 불멍 타임은 감히 작품이라고 자부합니다. <br>
                        기준 8명 최대 12명 까지 이용 가능한 세미네펜션은 가족모임 뿐만아니라 회사워크샵 이나 워케이션 등 다양한 장소로도 활용 가능합니다.
                    </div>
                </div>
            </div>
            <hr/>
            <div id="content2">
                <div class="guideTop2">
                    세미네펜션이 인기 있는 이유
                </div>
                <div class="guideBottom2">
                    <div class="gBottomGrid">
                        <div id="gBottom1">
                            <img src="${ path }/resources/images/AdobeStock_290080291.jpeg" width="200px" height="200px" style="border-radius: 70%;">
                        </div>
                        <div id="gBottom2">
                            전용 출입구
                        </div>
                    </div>
                    <div class="gBottomGrid">
                        <div id="gBottom1">
                            <img src="${ path }/resources/images/AdobeStock_484701177.jpeg" width="200px" height="200px" style="border-radius: 70%;">
                        </div>
                        <div id="gBottom2">
                            모임을 위한 공용 공간
                        </div>
                    </div>
                    <div class="gBottomGrid">
                        <div id="gBottom1">
                            <img src="${ path }/resources/images/AdobeStock_202394922.jpeg" width="200px" height="200px" style="border-radius: 70%;">
                        </div>
                        <div id="gBottom2">
                            전용 부엌/주방
                        </div>
                    </div>
                    <div class="gBottomGrid">
                        <div id="gBottom1">
                            <img src="${ path }/resources/images/AdobeStock_182826800.jpeg" width="200px" height="200px" style="border-radius: 70%;">
                        </div>
                        <div id="gBottom2">
                            넓은 바비큐 공간
                        </div>
                    </div>
                </div>
            </div>
            <hr/>
            <div id="content2">
                <div class="guideTop2">
                    “가족/그룹 여행객에게 강추합니다”
                </div>
                <div class="guideBottom3">
                    <div id="gBottom3">
                        “ 매우 깨끗하고 아늑한 숙소입니다. 호스트분이 잘 도와주시고 친절하시며 연락하기도 쉽습니다. <br>
                        숙소가 편리한 위치에 있어 레스토랑 및 상점들과도 5분 거리입니다. 전반적으로 매우 만족스러운 숙박이었고, <br>
                        가족 여행에 강추하는 숙소입니다!!! 꺄르륵꺄륵 ”
                    </div>
                </div>
            </div>
            <hr/>
            <div id="content1">
                <div class="guideTop">
                    이용안내
                </div>
                <div class="guideBottom">
                    <div id="BottomLeft">
                        본 상품은 프로모션 상품으로, 타 할인 혜택이 적용되지 않습니다. <br>
                        객실 상황에 따라 일부 날짜는 조기 마감 될 수 있습니다. <br>
                        상기 금액은 최대 8인 기준 객실이며, 객실 타입에 따라 금액이 변경 될 수 있습니다. <br>
                        체크인은 오후 3시 이후, 체크아웃은 정오까지 입니다. <br>
                        모든 이용금액의 부가가치세는 별도입니다. <br>
                        피트니스 센터는 안전상의 이유로 16세 이상 입장 가능합니다. <br>
                        국내 거주하는 내 외국인에게 판매됩니다.
                    </div>
                </div>
            </div>
            <hr/>
            <div id="content1">
                <div class="guideTop">
                    이용 및 집기시설
                </div>
                <div class="guideBottom">
                    <div id="BottomLeft">
                        60인치 FullHD TV &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        비스포크 냉장고 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        전기밥솥 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        인덕션 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        무풍 에어컨 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        선풍기 3대 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br>
                        전기포트 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        후라이팬 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        식기류(8인) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        오션뷰 대형 욕조 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        다이슨 드라이기 / 고데기 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        바비큐 파티용 정원
                    </div>
                </div>
            </div>
            <hr/>
            <div id="content1">
                <div class="guideTop">
                    금액안내
                </div>
                <div class="guideBottom">
                    <div id="BottomLeft">
                        객실금액 <br><br><br><br>
                        추가인원금액 <br><br><br><br>
                        바비큐 파티 옵션
                    </div>
                    <div id="BottomRight">
	                    <c:forEach var="roomDate" items="${ listDate }">
							${ roomDate.roomKrName }
							<fmt:formatNumber value="${ roomDate.roomPrice }"
											  type="currency"/> 원<br>

	
	                    </c:forEach>
	                    <br>
                        성인 1인당 20,000 원 <br>
                        어린이 1인당 10,000 원 <br>
                        유아 1인당 5,000 원 <br><br>
                        1인당 50,000 원(유아 제외)
                    </div>
                </div>
            </div>
            <hr/>
            <div id="content1">
                <div class="guideTop">
                    취소규정
                </div>
                <div class="guideBottom">
                    <div id="BottomLeft">
                        이용자가 이용일 기준  5일 전까지 예약 취소 시 납부액 전액 환불 가능합니다. <br>
                        전액환불 기준일부터 이용일 이전 취소 시 총액 10 ~ 40%만 위약금 상한으로 적용합니다. <br>
                        환불 사유 발생 시 특별한 사정이 없는 한 3일 ~ 5일 이내 반환 처리합니다. <br>
                        정당한 사유로 상기 조건의 적용이 곤란하더라도 ⌜소비자분쟁해결기준⌟의 위약금 기준선 또는 그 보다 소비자에게 유리한 규정을 적용합니다.

                    </div>
                </div>
            </div>

        </div>
        <hr/>
        <div id="priceBottom">
            <div class="priceTagL">
            </div>
            <button class="priceTagR">
                <a href="${ path }/room/reservation">결제페이지로</a>
            </button>
        </div>

            

    </section>
    
    
    
<jsp:include page="/views/common/footer.jsp" />