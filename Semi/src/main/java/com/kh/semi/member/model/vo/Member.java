package com.kh.semi.member.model.vo;


import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private int no;
	
	private String id;
	
	private String password;
	
	private String name;
	
	private int rrn;
	
	private String email;
	
	private String phone;
	
	private String  access;

}
