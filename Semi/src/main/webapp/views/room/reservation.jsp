<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>


<%--
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<%
    String name = (String)request.getAttribute("name");
    String email = (String)request.getAttribute("email");
    String phone = (String)request.getAttribute("phone");
    String address = (String)request.getAttribute("address");
    int totalPrice = (int)request.getAttribute("totalPrice");    
%>
--%>




<jsp:include page="/views/common/header.jsp" />

<style>

/* 섹션 영역 */
#section {
    width: 1200px;
	height: auto;
    /* text-align: center; */
    margin: auto;
    /* margin-top: 20px; */
    margin-bottom: 100px;
    /* border: 1px solid rgb(255, 153, 0); */
}

.rsvInfoBack1 {
    background-color: rgb(245, 245, 245);
}

#rsvInfoTitle {
    font-size: 32px;
    margin-top: 100px;
    margin-bottom: 50px;
}

.rsvInfo {
    display: flex;
}
.rsvInfo > div {
/*     border: 1px solid rgb(0, 51, 253); */
	width: 100px;
	height: auto;
}

.rsvInfo > #a {
    flex: 1;
    margin: 30px;
    margin-right: 0;
    color: gray;
}
.rsvInfo > #b {
    width: 50px;
}
.rsvInfo > #c {
    flex: 1;
    margin: 30px 30px 30px 0px;
    margin-left: 0;
    color: gray;
}
#d {
    display: flex;
}

#inputName, #inputTel, #inputEmail {
    border: 1px solid gray;
    height: 40px;
    width: 96%;
    padding-left: 20px;
}

.rsvInfo > #c > #c2 {
    display: flex;
}
.rsvInfo > #c > #c2 > form{
    flex: 1;
    border: 0;
    padding: 0;
}
form {
    border: 0;
    padding: 0;
}

/* 투숙인원 버튼 */
#number {
    border: 1px solid gainsboro;
    height: 40px;
    width: 50px;
    margin-left: 5px;
    margin-right: 5px;
}

.rsvInfo > #a > div {
    height: 40px;
    margin-bottom: 10px;
}
.rsvInfo > #c > div {
    height: 40px;
    margin-bottom: 10px;
}

#rsvHint {
    font-size: 14px;
    font-weight: 300;
    padding: 5px;
}

/* 인원수 border값 0 */
.field {
    margin: 0;
    padding: 0;
    border: 0;
}
.fieldP {
    margin: 0;
    padding: 0;

}


/* 예약 정보 영역 */
.rsvInfoBack2 {
    /* border: 1px dotted; */
    display: flex;
    background-color: rgb(245, 245, 245);
}

.optionLeft {
    padding: 30px 0px 30px 30px;
    /* border: 1px solid orange; */
    flex: 50%;
}
.optionRight {
    padding: 30px 30px 30px 0px;
    /* border: 1px solid orange; */
    flex: 50%;
}

/* 하늘색 테두리 영역 */
.RightLine {
    background-color: rgb(229, 244, 255);
    padding: 25px 20px 25px 20px;
}
.optionMiddle {
    margin-left: 30px;
}

#left1 {
    display: flex;
    height: 40px;
}
#left1 > #lA {
    font-size: 24px;
    font-weight: 700;
    flex: 100;
}
#left1 > #lB {
    color: gray;
    line-height: 50px;
    flex: auto;
    text-align: right;
}
#left2 {
    display: flex;
    height: 40px;
    margin-bottom: 10px;
}
#left2 > #lC {
    font-size: 18px;
    font-weight: 700;
    line-height: 35px;
    flex: 100;
}
#left2 > #lD {
    color: gray;
    line-height: 40px;
    flex: auto;
    text-align: right;
}
#left3 {
    display: flex;
    height: 40px;
}
#left3 > #lE {
    font-weight: 700;
    margin-right: 5px;
    line-height: 40px;
}
#left3 > #lF {
    color: gray;
    flex: 100;
    line-height: 40px;
}
#left3 > BBQNum2 {
    color: gray;
}
#BBQNum2 {
    height: 40px;
}
#left4 {
    display: flex;
    height: 40px;
    font-weight: 700;
}
#left5 {
    display: flex;
    width: 100%;
}
#right1 > #rA {
    height: 40px;
    font-weight: 700;
    font-size: 18px;

}
#right2 {
    display: flex;
    height: 40px;
}
#right2 > #rB {
    padding-left: 10px;
    flex: auto;
}
#right2 > #rC {
    font-weight: 700;
}
#right3 {
    height: 40px;
    font-weight: 700;
    font-size: 18px;
}
#right4 {
    height: 40px;
}
#right5 {
    display: flex;
    height: 40px;
}
#right5 > #rE {
    padding-left: 10px;
    flex: auto;
}
#right5 > #rF {
    font-weight: 700;
}
#right6 {
    display: flex;
    height: 40px;
}
#right6 > #rG {
    flex: auto;
}
#right6 > #rH {
    font-weight: 700;
}
#right7 {
    display: flex;
    height: 40px;
    font-weight: 700;
}
#right7 > #rI {
    flex: auto;
    font-size: 24px;
}
#right7 > #rJ {
    font-weight: 700;
    font-size: 24px;
}
#right8 {
    display: flex;
    height: 40px;
}



.priceTag3 {
    border: 0;
    background-color: transparent;
    /* width: 80px; */
}
.priceTag3 > a {
    display: inline-block;
    background-color: hsl(0, 0%, 27%);
    border-radius: 5px;
    padding: 7px 25px;
    text-decoration-line: none;
    /* margin-right: 15px; */
    font-weight: 500;
    font-size: 18px;
    color: #FFF;
    border: 0;
}

/* 유의사항 */
.rsvInfomation1 {
    /* border: 1px dotted; */
    display: flex;
}
.rsvInfomation2 {
    /* border: 1px dotted; */
    display: flex;
    background-color: rgb(245, 245, 245);
    padding: 30px;
}
.rsvDanger {
    padding: 30px;
}
#Dtitle1, #Dtitle2, #Dtitle3 {
    font-weight: 700;
    line-height: 50px;
    font-size: 18px;
}
#rsvHr {
    margin: 0;
}
#Dtitle2, #Dtitle3 {
    margin-top: 30px;
}
#Ddetail {
    padding-left: 20px;
}


.rsvLast1, .rsvLast2 {
    /* display: flex; */
    /* border: 1px solid rgb(94, 140, 3); */
}
#last1 {
    /* display: flex; */
    width: 1200px;
}
#last1A {
    /* background-color: red; */
    display: flex;
    margin: 30px;
}
#a1 {
    /* border: 1px solid rgb(76, 238, 109); */
    display: flex;
    width: 600px;
}
#aa1L {
    /* border: 2px dotted; */
    width: 30%;
    color: gray;
}
#aa1R {
    /* background-color: aquamarine; */
    width: 70%;
}
#a2 {
    /* border: 1px solid rgb(0, 21, 255); */
    display: flex;
    width: 600px;
}

/* 결제 총금액 */
#last2 {
    display: flex;
    height: 54px;
    /* border: 1px dotted rebeccapurple; */
}
#dsvPriceL {
    color: gray;
    text-align: center;
    width: 200px;
    /* border: 1px dotted rebeccapurple; */
}
#dsvPriceM {
    color: red;
    text-align: right;
    width: 200px;
    font-size: 30px;
    font-weight: 700;
    /* border: 1px dotted rebeccapurple; */
}
#dsvPriceR {
    width: 20px;
    text-align: center;
    line-height: 75px;
    /* border: 1px dotted rebeccapurple; */
}
#last3 {
    display: flex;
    margin-top: 20px;
    margin-bottom: 20px;
    /* border: 1px dotted rebeccapurple; */
}
#terms11, #terms22, #terms33 {
    color: gray;
    font-size: 14px;
}
#sel1 {
    color: red;
    font-size: 14px;
}
#sel2 {
    font-size: 14px;
    
}
#last30 {
    margin-right: 70px;
}

/* 취소 / 예약하기 */
#last4 {
    display: flex;
    margin: 70px 0px 150px 0px;
    /* border: 1px dotted rebeccapurple; */
}
.last4L {
    border: 0;
    background-color: transparent;
    /* flex: 1; */
    margin-left: auto;
    
}
.last4L > a {
    display: inline-block;
    background-color: gray;
    border-radius: 5px;
    padding: 7px 100px;
    text-decoration-line: none;
    margin: 0;
    font-weight: 500;
    font-size: 24px;
    color: #FFF;
    border: 0;
}
.last4M {
    /* border: 1px solid; */
    /* flex: 1; */
    margin: 5px;
}
.last4R {
    border: 0;
    background-color: transparent;
    /* flex: 1; */
    margin-right: auto;

}
.last4R > a {
    display: inline-block;
    background-color: hsl(24, 86%, 55%);
    border-radius: 5px;
    padding: 7px 100px;
    text-decoration-line: none;
    margin: 0;
    font-weight: 500;
    font-size: 24px;
    color: #FFF;
    border: 0;
}


</style>




    <!-- 섹션영역 -->
    <section id="section">



        <!-- 투숙자 정보 입력 -->
        <div id="rsvInfoTitle">
            투숙자 정보 입력
        </div>
        <div class="rsvInfoBack1">
            <div class="rsvInfo">
                <div id="a">
                    <div id="d">
                        <div style="color: red;">
                            *
                        </div>
                        <div>
                            예약자 이름
                        </div>
                    </div>
                    <div>
                        <input type="text" id="inputName" placeholder="이름">
                    </div>
                </div>
                <div id="b">
                    
                </div>
                <div id="c">
                    <div id="d">
                        <div style="color: red;">
                            *
                        </div>
                        <div>
                            휴대전화 번호
                        </div>
                    </div>
                    <div>
                        <input type="tel" id="inputTel" placeholder="'-' 제외하고 숫자만 입력">
                    </div>
                </div>
            </div>
            <div class="rsvInfo">
                <div id="a">
                    <div>
                        이메일 (선택)
                    </div>
                    <div>
                        <input type="email" id="inputEmail" placeholder="이메일 주소">
                    </div>
                    <div id="rsvHint">
                        이메일 주소 입력 시 '예약확정' 메일이 발송됩니다.
                    </div>
                </div>
                <div id="b">
                    
                </div>
                <div id="c">
                    <div>
                        투숙 인원
                    </div>
                    <div id="c2">
                        <form action="">
                            <fieldset class="field">
                                <p class="fieldP"><label for="number"></label>성인 <input type="number" min="2"  max="12" step="1" value="2" id="number" style="text-align: center;"/> 인</p>
                            </fieldset>
                        </form>
                        <form action="">
                            <fieldset class="field">
                                <p class="fieldP"><label for="number"></label>어린이 <input type="number" min="0"  max="12" step="1" value="0" id="number" style="text-align: center;"/> 인</p>
                            </fieldset>
                        </form>
                        <form action="">
                            <fieldset class="field">
                                <p class="fieldP"><label for="number"></label>유아 <input type="number" min="0"  max="12" step="1" value="0" id="number" style="text-align: center;"/> 인</p>
                            </fieldset>
                        </form>
                    </div>
                    <div id="rsvHint">
                        객실 정원을 준수해 주시기 바랍니다. (추가인원 포함 최대 12명) <br>
                        객실 정원은 영유아 포함입니다.
                    </div>
                </div>
            </div>
        </div>

<!--         <hr/> -->
        <!-- 예약정보 -->
        <div id="rsvInfoTitle">
            예약 정보
        </div>
        <div class="rsvInfoBack2">
            <!-- ㅇㄹㅇㄹ 속마진 30 -->
            <div class="optionLeft">
                <div id="left1">
                    <div id="lA">
                        방제목넘어오게해야함
                    </div>
                    <div id="lB">
                        투숙인원 : 성인 ?인, 어린이 ?인, 유아 ?인
                    </div>
                </div>
                <hr/>
                <div id="left2">
                    <div id="lC">
                        추가 옵션(성인)
                    </div>
                    <div id="lD">
                        모든 투숙일에 적용됩니다.
                    </div>
                </div>
                <div id="left3">
                    <div id="lE">
                        바비큐 파티 ?? 원
                    </div>
                    <div id="lF">
                        / 1인, 1박 기준
                    </div>
                    <form action="">
                        <fieldset class="field">
                            <p class="fieldP"><label for="number"></label><input type="number" min="0" max="12" step="1" value="0" id="BBQNum2" style="text-align: center; "/> <a style="color: gray;">인</a></p>
                        </fieldset>
                    </form>
                </div>
                <hr/>
                <div id="left4">
                    추가요청
                </div>
                <div id="left5">
                    <textarea name="left5Text" id="" cols="60" rows="5" placeholder="예시) 추가 배드를 요청합니다." style="resize: none; border-color: gainsboro; padding-left: 10px;"></textarea>
                </div>
            </div>
            <div class="optionMiddle">
                <!-- 공백 -->
            </div>
            <div class="optionRight">
                <div class="RightLine">
                    <hr/>
                    <div id="right1">
                        <div id="rA">
                            객실 요금
                        </div>
                    </div>
                    <div id="right2">
                        <div id="rB">
                            - sysdate.00월 00일
                        </div>
                        <div id="rC">
                            객실순수금액 원
                        </div>
                    </div>
                    <div id="right3">
                        옵션요금
                    </div>
                    <div id="right4">
                        바비큐 파티 신청(성인)
                    </div>
                    <div id="right5">
                        <div id="rE">
                            - 성인 바비큐 2 인 x 1 박
                        </div>
                        <div id="rF">
                            (바비큐 갯수당 금액 1인 5만원)
                        </div>
                    </div>
                    <div id="right6">
                        <div id="rG">
                            세금 및 봉사료
                        </div>
                        <div id="rH">
                            (객실순수금액)+(바비큐추가금액)+15%금액
                        </div>
                    </div>
                    <hr/>
                    <div id="right7">
                        <div id="rI">
                            (객실명) 총 금액
                        </div>
                        <div id="rJ">
                            978,028 KRW
                        </div>
                    </div>
                    <div id="right8">
                        <div>
                            
                        </div>
                        <div id="k">
                            <button class="priceTag3" onclick="location.href='${ path }/views/room/roomDetail.jsp'">
                                <a href="#">결제하기</a>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        

        <div id="rsvInfoTitle">
            유의사항
        </div>
        <hr/>
        <div class="rsvInfomation">
            <!-- ㅇㄹㅇㄹ 속마진 30 -->
            <div class="rsvDanger">
                <div id="Dtitle1">
                    요금 정책
                </div>
                <div id="Ddetail">
                    모든 요금에는 세금과 봉사료가 포함되어 있습니다. <br>
                    객실 요금은 현장에서 투숙자 정보에 따라 달라질 수 있습니다. <br>
                    기준인원 초과 시 인원추가 비용이 발생하며 최대인원 초과 시 입실이 제한됩니다. <br>
                </div>
                <div id="Dtitle2">
                    취소 규정
                </div>
                <div id="Ddetail">
                    비회원 예약 취소 및 변경은 주중 2일 전 17시, 주말 5일 전 17시까지 가능하며, 분양회원의 경우 7일 전 17시까지 가능합니다. 이후 취소 및 변경 시 위약금 또는 페널티가 부과됩니다. <br>
                    자세한 내용은 '예약 규정 확인 및 동의'를 통해 확인해주세요. (※ 주말 위약규정 적용일: 금,토,연휴,펜션 지정일) <br>
                    예약하신 일자에 체크인 되지 않거나 또는 위의 지정 시간 이후에 예약을 취소했을 경우에는 노-쇼(No-Show) 처리되며, 이에 따른 위약금 또는 페널티가 부과됩니다. <br>
                </div>
                <div id="Dtitle3">
                    체크인 안내
                </div>
                <div id="Ddetail">
                    15시(오후 3시)부터 가능하며, 밤 10시 이후 입실시 반드시 사전 연락하여 주시기 바랍니다. <br>
                    체크인 대기 고객의 편의를 위해 카카오톡 대기번호 알림 서비스를 시행합니다. <br>
                    로비 태블릿 박스에 휴대전화 번호 입력 > 대기번호 발급 > 순번 해당 시 카카오톡 알림톡 발송 <br>
                    -12월 부분 운영 (영하권 날씨 이용 불가) / 1 , 2월 미운영
                </div>
            </div>
        </div>

        <hr/>
        
        <div id="rsvInfoTitle">
            결제 정보
        </div>
        
        <hr id="rsvHr"/>

        <div class="rsvInfomation1">
            <!-- ㅇㄹㅇㄹ 속마진 30 -->
            <div class="rsvLast1">
                <div id="last1">
                    <div id="last1A">
                        <div id="a1">
                            <div id="aa1L">
                                투숙객실
                            </div>
                            <div id="aa1R">
                                프론트가 머무는 곳
                            </div>
                        </div>
                        <div id="a2">
                            <div id="aa1L">
                                투숙기간
                            </div>
                            <div id="aa1R">
                                00월 00일 / 00박
                            </div>
                        </div>
                    </div>
                    <div id="last1A">
                        <div id="a1">
                            <div id="aa1L">
                                객실 수
                            </div>
                            <div id="aa1R">
                                1 실
                            </div>
                        </div>
                        <div id="a2">
                            <div id="aa1L">
                                쿠폰적용
                            </div>
                            <div id="aa1R">
                                0 매
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="rsvInfomation2">
            <div class="rsvLast2">
                <div id="last2">
                    <div id="dsvPriceL">
                        총 금액 <br>
                        (VAT 포함)
                    </div>
                    <div id="dsvPriceM">
                        800,000
                    </div>
                    <div id="dsvPriceR">
                        원
                    </div>
                </div>
            </div>
        </div>
                <hr id="rsvHr"/>
        <div id="last3">
            <div id="last30">
                <input type="checkbox" name="terms1" id="terms1">
                <span id="sel1">(필수)</span>
                <label for="terms1" id="terms11">개인정보 수집 및 이용동의</label>
            </div>
            <div id="last30">
                <input type="checkbox" name="terms2" id="terms2">
                <span id="sel1">(필수)</span>
                <label for="terms2" id="terms22">예약 규정 확인 및 동의</label>
            </div>
            <div id="last30">
                <input type="checkbox" name="terms3" id="terms3">
                <span id="sel2">(선택)</span>
                <label for="terms3" id="terms33">개인정보 수집 및 이용동의</label>
            </div>
        </div>

        <div id="last4">
            <button class="last4L">
                <a href="#">취소</a>
            </button>
            <div class="last4M">
            </div>
            <button class="last4R">
                <a href="#">예약하기</a>
            </button>
        </div>




    </section>
    
    
    
<jsp:include page="/views/common/footer.jsp" />