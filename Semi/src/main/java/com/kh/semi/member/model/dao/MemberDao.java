package com.kh.semi.member.model.dao;


import com.kh.semi.member.model.vo.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.semi.member.model.vo.Member;

import static com.kh.semi.common.jdbc.JDBCTemplate.close;

public class MemberDao {

	public int updateMemberPassword(Connection connection, int userNo, String pwd1) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE MEMBER_INFO SET USER_PWD=? WHERE USER_NO=?";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, pwd1);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public Member findMemberById(Connection connection, String userId) {
		Member member = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		String query = "SELECT * FROM MEMBER_INFO WHERE USER_ID=? ";
		
		try {

			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				
				member.setNo(rs.getInt("USER_NO"));
				member.setId(rs.getString("USER_ID"));
				member.setPassword(rs.getString("USER_PWD"));
				member.setName(rs.getString("USER_NAME"));
				member.setRrn(rs.getInt("USER_RRN"));
				member.setEmail(rs.getString("USER_EMAIL"));
				member.setPhone(rs.getString("USER_PHONE"));
				member.setAccess(rs.getString("USER_ACCESS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
		}
		
		
		return member;
	}

	public int updateMember(Connection connection, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE MEMBER_INFO SET USER_NAME=?,USER_ID=?,PHONE=?,EMAIL=?, WHERE NO=?";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getEmail());
			pstmt.setInt(5, member.getNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}


	
}
