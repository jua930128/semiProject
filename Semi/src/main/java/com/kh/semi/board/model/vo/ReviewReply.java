package com.kh.semi.board.model.vo;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewReply {
	
	private int replyNo;
	
	private int revNo;
	
	private int userNo;
	
	private String userId;
	
	private String replyContent;
	
	private Date replyDate;
	
	private String status;
	
	
	
	
}
