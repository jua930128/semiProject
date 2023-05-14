package com.kh.semi.board.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QnaReply {
	private int reply_no;
	
	private int no;
	
	private String reply;
	
	private int userNo;
	
	private String userId;
	
	private Date reply_date;
	
	private String reply_con;
	
	private String check;
	
	private String searchType;
	
	private String searchText;

	private String status;
	
}
