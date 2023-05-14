package com.kh.semi.board.model.vo;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Qna {
	private int rNum;
	
	private int no;
	
	private String title;
	
	private String content;
	
	private String writer;
		
	private Date date;
	
	private String status;
	
	private String check;
	
	private int user_no;

	private List<QnaReply> qnaReply;
	
}
