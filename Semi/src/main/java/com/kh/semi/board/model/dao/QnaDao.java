package com.kh.semi.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.board.model.vo.Qna;
import com.kh.semi.board.model.vo.QnaReply;
import com.kh.semi.board.model.vo.SearchQna;
import com.kh.semi.common.util.PageInfo;
import static com.kh.semi.common.jdbc.JDBCTemplate.close;
public class QnaDao {

	public int getQnaCount(Connection connection) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM QNA WHERE STATUS='Y'";
		
		try {
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		return count;
	}
		
	
	
	
	
	
	
	
	
	
	
	public List<Qna> findAll(Connection connection, PageInfo pageinfo) {
		List<Qna> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT RNUM, "
				+	  	"QNA_NO, "
				+     	"QNA_TITLE, "
				+	 	 "USER_ID, "
				+    	 "QNA_DATE, "
				+	 	 "STATUS,"
				+ "		QNA_CHECK "
				+ 	  "FROM ( "
				+    	"SELECT ROWNUM AS RNUM, "
				+           "QNA_NO, "
				+ 			"QNA_TITLE, "
				+ 			"USER_ID, "
				+ 			"QNA_DATE, "
				+			"STATUS,"
				+ "			QNA_CHECK "
				+ 		" FROM ( "
				+ 	  			"SELECT Q.QNA_NO, "
				+ 		 			"Q.QNA_TITLE, "
				+  		 			"M.USER_ID, "
				+ 		 			"Q.QNA_DATE, "
				+ 				    "Q.STATUS,"
				+ "					Q.QNA_CHECK  "
				+ 				"FROM QNA Q "
				+ 				"JOIN MEMBER_INFO M ON(Q.USER_NO = M.USER_NO) "
				+ 				"WHERE Q.STATUS = 'Y' ORDER BY Q.QNA_NO DESC "
				+ 			" ) "
				+ 		") WHERE RNUM BETWEEN ? and ? ";
		
				try {
					pstmt = connection.prepareStatement(query);
					pstmt.setInt(1, pageinfo.getStartList());
					pstmt.setInt(2, pageinfo.getEndList());
					
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						Qna qna = new Qna();
						qna.setRNum(rs.getInt("RNUM"));
						qna.setNo(rs.getInt("QNA_NO"));
						qna.setTitle(rs.getString("QNA_TITLE"));
						qna.setWriter(rs.getString("USER_ID"));
						qna.setDate(rs.getDate("QNA_DATE"));
						qna.setStatus(rs.getString("STATUS"));
						qna.setCheck(rs.getString("QNA_CHECK"));
						System.out.println(qna.getCheck());
						list.add(qna);
						
						
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(rs);
					close(pstmt);
				}
		
		
		
		return list;
	}











	public Qna findQnaByNo(Connection connection, int no) {
		Qna qna = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = 
				        "SELECT Q.QNA_NO, "
				      + "       Q.QNA_TITLE, "
				      + "       Q.QNA_CONTENT, "
				      +"        Q.QNA_DATE, "
				      + "       M.USER_ID, "
				      +"		Q.STATUS, "
				      +"		Q.QNA_CHECK "
				      + "FROM QNA Q  "
				      + "INNER JOIN MEMBER_INFO M ON(Q.USER_NO = M.USER_NO) "
				      + "WHERE Q.STATUS = 'Y' AND Q.QNA_NO=?";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				qna = new Qna();
				qna.setNo(rs.getInt("QNA_NO"));
				qna.setTitle(rs.getString("QNA_TITLE"));
				qna.setContent(rs.getString("QNA_CONTENT"));
				qna.setDate(rs.getDate("QNA_DATE"));
				qna.setWriter(rs.getString("USER_ID"));
				qna.setStatus(rs.getString("STATUS"));
				qna.setCheck(rs.getString("QNA_CHECK"));
				qna.setQnaReply(this.getQnaReplyByNo(connection, no));
				
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rs);
			close(pstmt);
		}
		
		
		return qna;
	}











	public int insertQna(Connection connection, Qna qna) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO QNA VALUES(SEQ_REV_NO.NEXTVAL,?,?,DEFAULT,1,'Y',DEFAULT)";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, qna.getTitle());
			pstmt.setString(2, qna.getContent());
//			pstmt.setInt(3, qna.getUser_no());  로그인 구현후 1 대신 들어감
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		
		
		
		
		
		
		
		
		
		return result;
	}











	public int updateQna(Connection connection, Qna qna) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE QNA SET QNA_TITLE=? , QNA_CONTENT=?  WHERE QNA_NO =?";
		
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, qna.getTitle());
			pstmt.setString(2, qna.getContent());
			pstmt.setInt(3, qna.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		
		
		return result;
	}











	public int updateQnaStatus(Connection connection, int no, String status) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query ="UPDATE QNA SET STATUS=? WHERE QNA_NO=?";
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, status);
			pstmt.setInt(2, no);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}











	public int insertQnaReply(Connection connection, QnaReply qnareply) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO QNA_REPLY VALUES(SEQ_QNA_REPLY_NO.NEXTVAL,?,?,DEFAULT,?,DEFAULT)";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, qnareply.getNo());
			pstmt.setString(2, qnareply.getReply_con());
//			2번 컬럼은 로그인 구현후 1 대신 작성자 아아디 들어가야 함
			pstmt.setInt(3, 1);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		return result;
	}











	public int checkQna(Connection connection, QnaReply qnareply) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query ="UPDATE QNA SET QNA_CHECK=? WHERE QNA_NO=?";
		
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, "Y");
			System.out.println(qnareply.getNo());
			pstmt.setInt(2, qnareply.getNo());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}


	
	


public List<QnaReply> getQnaReplyByNo(Connection connection, int no){
	List<QnaReply> qnareply = new ArrayList<>();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = "SELECT Q.QNA_REPLY_NO, "
			+ "      	   Q.QNA_NO, "
			+ "       	   M.USER_ID, "
			+ "       	   Q.REPLY_CONTENT, "
			+ "      	   Q.REPLY_DATE "
			+ "FROM QNA_REPLY Q "
			+ "INNER JOIN MEMBER_INFO M ON( Q.USER_NO = M.USER_NO ) "
			+ "WHERE Q.STATUS ='Y' AND QNA_NO=? "
			+ "ORDER BY Q.QNA_NO DESC";
	try {
		pstmt = connection.prepareStatement(query);
		
		pstmt.setInt(1, no);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			QnaReply reply = new QnaReply();
			
			reply.setReply_no(rs.getInt("QNA_REPLY_NO"));
			reply.setNo(rs.getInt("QNA_NO"));
			reply.setUserId(rs.getString("USER_ID"));
			reply.setReply_con(rs.getString("REPLY_CONTENT"));
			reply.setReply_date(rs.getDate("REPLY_DATE"));
			
			qnareply.add(reply);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}
	
	
	
	
	
	return qnareply;

	}











public List<SearchQna> findSearch(Connection connection, PageInfo searchpageinfo, SearchQna searchqna) {
	List<SearchQna> searchqnalist = new ArrayList<>();
	PreparedStatement pstmt = null;
	String Text = searchqna.getSearchText();
	ResultSet rs = null;
	
	String query ="SELECT RNUM, "
			+		"QNA_NO, "
			+	    "QNA_TITLE, "
			+       "USER_ID, "
			+       "QNA_DATE, "
			+       "STATUS, "
			+       "QNA_CHECK, "
			+       "QNA_CONTENT "
			+   "FROM ( "
		    +           " SELECT ROWNUM AS RNUM, "
		    +       			"QNA_NO, "
		    +        "QNA_TITLE, "
		    +        "USER_ID, "
		    +        "QNA_DATE, "
		    +        "STATUS, "
		    +        "QNA_CHECK, "
		    +        "QNA_CONTENT "
		    +        " FROM ( "
			+                "SELECT Q.QNA_NO, "
			+                "Q.QNA_TITLE, "
			+                "M.USER_ID, "
			+                "Q.QNA_DATE, "
			+                "Q.STATUS,  "
			+                "Q.QNA_CONTENT, "
			+				 "Q.QNA_CHECK "
			+                "FROM QNA Q "
			+                "INNER JOIN MEMBER_INFO M ON(Q.USER_NO = M.USER_NO) "
			+                "WHERE Q.STATUS = 'Y' ORDER BY Q.QNA_NO DESC ) "
			+		 "	) "
			+ 		" WHERE RNUM BETWEEN ? and ? " ;
			
		System.out.println(Text);
		try {
			if(searchqna.getSearchType() != null && searchqna.getSearchType().equals("searchwriter")) {
				query += " AND USER_ID LIKE ? " ;
				System.out.println(Text);
		} else if(searchqna.getSearchType() != null && searchqna.getSearchType().equals("searchtitle")) {

			query += " AND QNA_TITLE LIKE ? ";
			System.out.println(Text);
		} 
			
			System.out.println(searchpageinfo.getStartList());
			System.out.println(searchpageinfo.getEndList());
			System.out.println(Text);
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, searchpageinfo.getStartList());
			pstmt.setInt(2, searchpageinfo.getEndList());
			pstmt.setString(3, "%"+Text+"%");
			
			
			rs = pstmt.executeQuery();	
	
			while(rs.next()) {
				SearchQna qr = new SearchQna();
				
				
				qr.setNo(rs.getInt("QNA_NO"));
				qr.setRNum(rs.getInt("RNUM"));
				qr.setTitle(rs.getString("QNA_TITLE"));
				qr.setDate(rs.getDate("QNA_DATE"));
				qr.setWriter(rs.getString("USER_ID"));
				qr.setContent(rs.getString("QNA_CONTENT"));
				qr.setCheck(rs.getString("QNA_CHECK"));
				searchqnalist.add(qr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

	
	
	
	
	
	
	
	
	
	
	
	System.out.println(searchqnalist);
	
	return searchqnalist;
}













}