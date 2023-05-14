package com.kh.semi.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.jasper.tagplugins.jstl.core.Choose;

import com.kh.semi.common.util.PageInfo;
import com.kh.semi.board.model.vo.Review;
import com.kh.semi.board.model.vo.ReviewReply;
import com.kh.semi.board.model.vo.SearchReview;
import com.kh.semi.board.model.vo.SearchReview;

import static com.kh.semi.common.jdbc.JDBCTemplate.close;

public class ReviewDao{
	

	public int getReviewCount(Connection connection) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) FROM REV WHERE STATUS='Y'";
		
		
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

	public List<Review> findAll(Connection connection, PageInfo pageinfo) {
		List<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query ="SELECT RNUM, "
				+	  	"REV_NO, "
				+     	"REV_TITLE, "
				+	 	 "USER_ID, "
				+    	 "REV_DATE, "
				+	 	 "STATUS, "
				+	 	 "ROOM_NAME, "
				+		 "REV_RATE, "
				+		 "REV_VIEW "
				+ 	  "FROM ( "
				+    	"SELECT ROWNUM AS RNUM, "
				+           "REV_NO, "
				+ 			"REV_TITLE, "
				+ 			"USER_ID, "
				+ 			"REV_DATE, "
				+			"STATUS, "
				+			"ROOM_NAME, "
				+			"REV_RATE, "
				+			"REV_VIEW "
				+ 		" FROM ( "
				+ 	  			"SELECT R.REV_NO, "
				+ 		 			"R.REV_TITLE, "
				+  		 			"M.USER_ID, "
				+ 		 			"R.REV_DATE, "
				+ 				    "R.STATUS,  "
				+					"R.ROOM_NAME, "
				+					"R.REV_RATE, "
				+					"R.REV_VIEW "
				+ 				"FROM REV R "
				+ 				"JOIN MEMBER_INFO M ON(R.USER_NO = M.USER_NO) "
				+ 				"WHERE R.STATUS = 'Y' ORDER BY R.REV_NO DESC "
				+ 			" ) "
				+ 		") WHERE RNUM BETWEEN ? and ? ";
				
		
		
		try {
			pstmt = connection.prepareStatement(query);
			
			System.out.println(pageinfo.getStartList());
			System.out.println(pageinfo.getEndList());
			pstmt.setInt(1, pageinfo.getStartList());
			pstmt.setInt(2, pageinfo.getEndList());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Review review = new Review();
				
				review.setNo(rs.getInt("REV_NO"));
				review.setRNum(rs.getInt("RNUM"));
				review.setTitle(rs.getString("REV_TITLE"));
				review.setDate(rs.getDate("REV_DATE"));
				review.setRate(rs.getString("REV_RATE"));
				review.setStauts(rs.getString("STATUS"));
				review.setRoom_name(rs.getString("ROOM_NAME"));
				review.setWriter(rs.getString("USER_ID"));
				review.setRevivewview(rs.getInt("REV_VIEW"));
				list.add(review);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rs);
			close(pstmt);
			
			
		}
		
		return list;
	}

	public int insertReview(Connection connection, Review review) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO REV VALUES(SEQ_REV_NO.NEXTVAL,?,?,DEFAULT,?,1,'Y',?, DEFAULT)";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, review.getTitle());
			pstmt.setString(2, review.getContent());
			pstmt.setString(3, review.getRate());
//			pstmt.setInt(4, review.getUser_no()); 로그인 구현후 1 대신 들어감
			pstmt.setString(4, review.getRoom_name());
			
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

	public int updateReview(Connection connection, Review review) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE REV SET REV_TITLE=?, REV_CONTENT=?, REV_RATE=?, ROOM_NAME=? WHERE REV_NO =?";
		
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, review.getTitle());
			pstmt.setString(2, review.getContent());
			pstmt.setString(3, review.getRate());
			pstmt.setString(4, review.getRoom_name());
			pstmt.setInt(5, review.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		
		
		return result;
	}
	
	
	public Review findReviewByNo(Connection connection, int no) {
		Review review = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = 
				        "SELECT "
				        + "R.REV_NO, "
				      + "       R.REV_TITLE, "
				      + "       M.USER_ID, "
				      + "       R.REV_CONTENT, "
				      + "       R.ROOM_NAME,  "
				      +"        R.REV_DATE, "
				      +"		R.REV_RATE, "
				      +"        R.REV_VIEW "
				      + "FROM REV R "
				      + "INNER JOIN MEMBER_INFO M ON(R.USER_NO = M.USER_NO) "
				      + "WHERE R.STATUS = 'Y' AND R.REV_NO=?";
		
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				review = new Review();
				review.setNo(rs.getInt("REV_NO"));
				review.setTitle(rs.getString("REV_TITLE"));
				review.setWriter(rs.getString("USER_ID"));
				review.setContent(rs.getString("REV_CONTENT"));
				review.setRoom_name(rs.getString("ROOM_NAME"));
				review.setDate(rs.getDate("REV_DATE"));
				review.setRate(rs.getString("REV_RATE"));
				review.setRevivewview(rs.getInt("REV_VIEW"));
				review.setReviewReply(this.getReviewReplyByNo(connection, no));
				
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rs);
			close(pstmt);
		}

		return review;
	}

	
	 
	public List<ReviewReply> getReviewReplyByNo(Connection connection, int no){
		List<ReviewReply> reviewreply = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT R.REV_REPLY_NO, "
				+ "      	   R.REV_NO, "
				+ "       	   M.USER_ID, "
				+ "       	   R.CONTENT, "
				+ "      	   R.REV_REPLY_DATE "
				+ "FROM REV_REPLY R "
				+ "INNER JOIN MEMBER_INFO M ON( R.USER_NO = M.USER_NO ) "
				+ "WHERE R.STATUS ='Y' AND REV_NO=? "
				+ "ORDER BY R.REV_NO DESC";
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewReply reply = new ReviewReply();
				
				reply.setReplyNo(rs.getInt("REV_REPLY_NO"));
				reply.setRevNo(rs.getInt("REV_NO"));
				reply.setUserId(rs.getString("USER_ID"));
				reply.setReplyContent(rs.getString("CONTENT"));
				reply.setReplyDate(rs.getDate("REV_REPLY_DATE"));
				
				reviewreply.add(reply);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		
		
		return reviewreply;
	}

/*
	review.setNo(rs.getInt("REV_NO"));
	review.setRNum(rs.getInt("RNUM"));
	review.setTitle(rs.getString("REV_TITLE"));
	review.setDate(rs.getDate("REV_DATE"));
	review.setRate(rs.getString("REV_RATE"));
	review.setStauts(rs.getString("STATUS"));
	review.setRoom_name(rs.getString("ROOM_NAME"));
	review.setWriter(rs.getString("USER_ID"));
*/


	public int insertReviewReply(Connection connection, ReviewReply reviewreply) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO REV_REPLY VALUES(SEQ_REV_REPLY_NO.NEXTVAL,?,?,?,DEFAULT,DEFAULT)";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, reviewreply.getRevNo());
			pstmt.setInt(2, 1);
			pstmt.setString(3, reviewreply.getReplyContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		return result;
	}

	public int updateReviewStatus(Connection connection, int no, String status) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query ="UPDATE REV SET STATUS=? WHERE REV_NO=?";
		
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

	public List<SearchReview> findSearch(Connection connection, PageInfo searchpageinfo, SearchReview searchreview) {
		List<SearchReview> searchreviewlist = new ArrayList<>();
		PreparedStatement pstmt = null;
//		String Text = "'%" + searchreview.getSearchText()+ "%'";
		String Text = searchreview.getSearchText();
		ResultSet rs = null;
		
		String query ="SELECT RNUM, "
					+		"REV_NO, "
					+	    "REV_TITLE, "
					+       "USER_ID, "
					+       "REV_DATE, "
					+       "STATUS, "
					+       "ROOM_NAME, "
					+       "REV_RATE,"
					+       "REV_CONTENT, "
					+		"REV_VIEW "
					+   "FROM ( "
				    +           " SELECT ROWNUM AS RNUM, "
				    +       			"REV_NO, "
				    +        "REV_TITLE, "
				    +        "USER_ID, "
				    +        "REV_DATE, "
				    +        "STATUS, "
				    +        "ROOM_NAME, "
				    +        "REV_RATE, "
				    +        "REV_CONTENT, "
				    +		 "REV_VIEW "
				    +        " FROM ( "
					+                "SELECT R.REV_NO, "
					+                "R.REV_TITLE, "
					+                "M.USER_ID, "
					+                "R.REV_DATE, "
					+                "R.STATUS,  "
					+                "R.ROOM_NAME, "
					+                "R.REV_RATE, "
					+                "R.REV_CONTENT, "
					+				 "R.REV_VIEW "
					+                "FROM REV R "
					+                "INNER JOIN MEMBER_INFO M ON(R.USER_NO = M.USER_NO) "
					+                "WHERE R.STATUS = 'Y' ORDER BY R.REV_NO DESC ) "
					+		 "	) "
					+ 		" WHERE RNUM BETWEEN ? and ? " ;
//					+ 		" WHERE RNUM BETWEEN ? and ?  " ;
					try {
						if(searchreview.getSearchType() != null && searchreview.getSearchType().equals("searchwriter")) {
							query += " AND USER_ID LIKE ? " ;
							System.out.println(Text);
						} else if(searchreview.getSearchType() != null && searchreview.getSearchType().equals("searchtitle")) {

							query += " AND REV_TITLE LIKE ? ";
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
							SearchReview sr = new SearchReview();
							
							sr.setNo(rs.getInt("REV_NO"));
							sr.setRNum(rs.getInt("RNUM"));
							sr.setTitle(rs.getString("REV_TITLE"));
							sr.setDate(rs.getDate("REV_DATE"));
							sr.setRate(rs.getString("REV_RATE"));
							sr.setStauts(rs.getString("STATUS"));
							sr.setRoom_name(rs.getString("ROOM_NAME"));
							sr.setWriter(rs.getString("USER_ID"));
							sr.setContent(rs.getString("REV_CONTENT"));
							sr.setReviewview(rs.getInt("REV_VIEW"));
							searchreviewlist.add(sr);
						}

					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						close(rs);
						close(pstmt);
					}
		
		
		
		
					System.out.println(searchreviewlist);
		return searchreviewlist;
		

		

	}

	public int updateReadCount(Connection connection, Review review) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE REV SET REV_VIEW=? WHERE REV_NO=?";
		
		try {
			pstmt = connection.prepareStatement(query);
			
			review.setRevivewview(review.getRevivewview() +1);
			
			pstmt.setInt(1, review.getRevivewview());
			pstmt.setInt(2, review.getNo());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection);
		}
		
		
		
		
		
		
		
		
		return result;
	}

	public Review findReviewByNoPre(Connection connection, int preReviewNo) {
		Review review = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = 
				        "SELECT "
				        + "R.REV_NO, "
				      + "       R.REV_TITLE, "
				      + "       M.USER_ID, "
				      + "       R.REV_CONTENT, "
				      + "       R.ROOM_NAME,  "
				      +"        R.REV_DATE, "
				      +"		R.REV_RATE, "
				      +"        R.REV_VIEW "
				      + "FROM REV R "
				      + "INNER JOIN MEMBER_INFO M ON(R.USER_NO = M.USER_NO) "
				      + "WHERE R.STATUS = 'Y' AND R.REV_NO=?";
		
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, preReviewNo);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				review = new Review();
				review.setNo(rs.getInt("REV_NO"));
				review.setTitle(rs.getString("REV_TITLE"));
				review.setWriter(rs.getString("USER_ID"));
				review.setContent(rs.getString("REV_CONTENT"));
				review.setRoom_name(rs.getString("ROOM_NAME"));
				review.setDate(rs.getDate("REV_DATE"));
				review.setRate(rs.getString("REV_RATE"));
				review.setRevivewview(rs.getInt("REV_VIEW"));
				review.setReviewReply(this.getReviewReplyByNo(connection, preReviewNo));
				
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rs);
			close(pstmt);
		}

		return review;
		
	}

	public Review findReviewByNoNext(Connection connection, int nextReviewNo) {
		Review review = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = 
				        "SELECT "
				        + "R.REV_NO, "
				      + "       R.REV_TITLE, "
				      + "       M.USER_ID, "
				      + "       R.REV_CONTENT, "
				      + "       R.ROOM_NAME,  "
				      +"        R.REV_DATE, "
				      +"		R.REV_RATE, "
				      +"        R.REV_VIEW "
				      + "FROM REV R "
				      + "INNER JOIN MEMBER_INFO M ON(R.USER_NO = M.USER_NO) "
				      + "WHERE R.STATUS = 'Y' AND R.REV_NO=?";
		
		
		try {
			pstmt = connection.prepareStatement(query);
			
			pstmt.setInt(1, nextReviewNo);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				review = new Review();
				review.setNo(rs.getInt("REV_NO"));
				review.setTitle(rs.getString("REV_TITLE"));
				review.setWriter(rs.getString("USER_ID"));
				review.setContent(rs.getString("REV_CONTENT"));
				review.setRoom_name(rs.getString("ROOM_NAME"));
				review.setDate(rs.getDate("REV_DATE"));
				review.setRate(rs.getString("REV_RATE"));
				review.setRevivewview(rs.getInt("REV_VIEW"));
				review.setReviewReply(this.getReviewReplyByNo(connection, nextReviewNo));
				
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rs);
			close(pstmt);
		}

		return review;
	}

	public int updateReviewReplyStatus(Connection connection, int replyno, String status) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query ="UPDATE REV_REPLY SET STATUS=? WHERE REV_REPLY_NO=?";
		
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, status);
			pstmt.setInt(2, replyno);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
}



