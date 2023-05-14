package com.kh.semi.board.model.vo;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SearchReview {
	
	private int no;
	
	private int rNum;
	
	private String title;
	
	private String content;
	
	private Date date;
	
	private String rate;
	
	private int user_no;
	
	private String Stauts;
	
	private String room_name;
	
	private String writer;
	
	private List<ReviewReply> reviewReply;
	
	private String searchType;
	
	private String searchText;
	
	private int reviewview;

}
