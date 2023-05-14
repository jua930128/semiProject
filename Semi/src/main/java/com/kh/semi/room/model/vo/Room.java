package com.kh.semi.room.model.vo;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
	// ROOM(객실 유형 및 정보)
	private int roomNo; // 객실번호
	
	private String roomEnName; // 객실이름(한글)
	
	private String roomKrName; // 객실이름(영어)
	
	private int roomPrice; // 객실가격 (30만, 40만, 50만)
	
	private String roomInfo; // 객실 뷰, 평수 정보
	
	
	
	// RSV(예약)
	private int rsvNo; // 예약번호
	
	private int rsvPrice; // 객실금액 (옵션 추가인원 추가전)
	
	private int rsvCount; // 예약인원
	
	private String rsvReq; // 요청사항
	
//	private int roomNo; // 객실번호
	
	private int optId; // 바비큐 추가코드(SEQ)
	
	private int userNo; // 회원번호

	
	
	// RSV_DATE(예약 날짜 정보)
//	private int roomNo; // 객실번호
	
	private Date checkIn; // 예약 시작일
	
	private Date checkOut; // 예약 종료일

	
	
	// RSV_INFO(예약자 정보)
//	private int rsvNo; // SEQ
	
	private String userName; // 예약자 이름

	private String phone; // 예약자 연락처
	
	private String email; // 예약자 이메일
	
	private String rsvYN; // 예약완료 여부
	
	
	
	// PAY(결제 정보 및 현황)
//	private int rsvNo; // 예약번호
	
//	private int roomNo; // 객실번호
	
	private Date payDate; // 결제일자
	
	private String payMethod; // 결제수단
	
	private int totalrsvPrice; // 결제금액
	
	private String payStatus; // 결제상태
	
	
	
	// ADD_PRICE(연령대 별 객실 추가인원요금)
//	private int rsvNo; // 예약번호(SEQ)
	
	private int adult; // 성인 (1인당 20,000원)
	
	private int child; // 어린이 (1인당 10,000원)
	
	private int baby; // 유아 (1인당 5,000원)
	
	private int addPrice; // 추가인원 총 금액
	
	
	
	// OPTION(바비큐 추가옵션)
//	private int optId; // 옵션코드(바비큐 추가코드)
	
	private int roptionCount; // 옵션 인원수
	
	private int optPrice; // 옵션금액 (1인당 50,000원)
	
}


