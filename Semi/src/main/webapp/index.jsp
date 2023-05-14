<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/views/common/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>

    <section>
        <div id="previewtext">Preview</div>
        <div id="preview">
                <a href="#" style="text-decoration: none; color: black;">
                    <div id="imgwrap1">
                        <div id="imgdiv1">
                            <img id="preimg1" src="${ path }/resources/images/AdobeStock_335968727.jpeg">
                        </div>
                        <div id="pdiv1">
                            <p style="font-weight: bold; font-size: larger;">예약하러 가기</p>
                        </div>
                    </div>
                </a>
                <a href="#" style="text-decoration: none; color: black;">
                    <div id="imgwrap2">
                        <div id="imgdiv2">
                            <img id="preimg2" src="${ path }/resources/images/AdobeStock_335968727.jpeg">
                        </div>
                        <div id="pdiv2">
                            <p style="font-weight: bold; font-size: larger;">예약하러 가기</p>
                        </div>
                    </div>
                </a>
                <a href="#" style="text-decoration: none; color: black;">
                    <div id="imgwrap3">
                        <div id="imgdiv3">
                            <img id="preimg3" src="${ path }/resources/images/AdobeStock_335968727.jpeg">
                        </div>
                        <div id="pdiv3">
                            <p style="font-weight: bold; font-size: larger;">예약하러 가기</p>
                        </div>
                    </div>
                </a>
        </div>
    </section>

<jsp:include page="/views/common/footer.jsp"/>


