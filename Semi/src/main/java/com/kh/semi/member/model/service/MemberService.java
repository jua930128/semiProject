package com.kh.semi.member.model.service;

import java.sql.Connection;

import static com.kh.semi.common.jdbc.JDBCTemplate.getConnection;
import static com.kh.semi.common.jdbc.JDBCTemplate.close;
import static com.kh.semi.common.jdbc.JDBCTemplate.commit;
import static com.kh.semi.common.jdbc.JDBCTemplate.rollback;

import com.kh.semi.common.jdbc.JDBCTemplate;
import com.kh.semi.member.model.dao.MemberDao;
import com.kh.semi.member.model.vo.Member;

public class MemberService {


	public Member login(String userId, String userPwd) {
		Connection connection = getConnection();
		Member member = null;
		
		member = new MemberDao().findMemberById(connection, userId);
		
		return member;
		
		
	}

	public int updatePassword(int userNo, String pwd1) {
		int result = 0;
		Connection connection = getConnection();
		
		result = new MemberDao().updateMemberPassword(connection, userNo ,pwd1);
		
		if(result >0) {
			commit(connection);
		}else {
			rollback(connection);
		}
		
		close(connection);
		
		
		return result;
	}

	public int save(Member member) {
		int result = 0;
		Connection connection = getConnection();
		
//		if(member.getNo()>0) {
			//update 작업
//			result =  new MemberDao().updateMember(connection, member);
//		}else {
			//insert작업
//			result = new MemberDao().insertMember(connection,member);
//		}
		
		if(result >0) {
			commit(connection);
		}else {
			rollback(connection);
		}
		close(connection);
		return result;
	}

	public Member findMemberById(String userId) {
		Connection connection = getConnection();
		
		Member member = new MemberDao().findMemberById(connection, userId);
		
		close(connection);
		 
		return member;
	}

}