package com.kh.semi.board.model.service;

import java.sql.Connection;
import java.util.List;

import static com.kh.semi.common.jdbc.JDBCTemplate.close;
import static com.kh.semi.common.jdbc.JDBCTemplate.commit;
import static com.kh.semi.common.jdbc.JDBCTemplate.rollback;
import static com.kh.semi.common.jdbc.JDBCTemplate.getConnection;

import com.kh.semi.board.model.dao.ReviewDao;
import com.kh.semi.board.model.vo.Review;
import com.kh.semi.board.model.vo.ReviewReply;
import com.kh.semi.board.model.vo.SearchReview;
import com.kh.semi.common.util.PageInfo;
import com.kh.semi.common.jdbc.JDBCTemplate;

public class ReviewService {

	

	public int getReviewCount() {
		int count = 0;

		Connection connection = getConnection();
		
		count = new ReviewDao().getReviewCount(connection);
		
		
		close(connection);
		return count;
	}

//	public List<Review> getReivewList(PageInfo pageinfo) {
//		List<Review> list = null;
//		Connection connection = getConnection();
//		
//		list = new ReviewDao().findAll(connection, pageinfo);
//		
//		
//		
//		
//		
//		
//		close(connection);
//		
//		return list;
//	}

	public List<Review> getReviewList(PageInfo pageinfo) {
		List<Review> list = null;
		Connection connection = getConnection();
		
		list = new ReviewDao().findAll(connection, pageinfo);
		
		
		
		
		
		
		close(connection);
		
		return list;
	}

	public int save(Review review) {
		int result = 0;
		Connection connection = getConnection();
		
		if(review.getNo() > 0) {
			// update 작업
			result = new ReviewDao().updateReview(connection, review);
			
			
		} else {
			// insert 작업
			
			result = new ReviewDao().insertReview(connection, review);
			
			
		}
		
		
		if( result > 0 ) {
			commit(connection);
		} else {
			rollback(connection);
		} 
		
		
		
		
		
		
		close(connection);
		return result;
	}

	public Review getReviewByNo(int no, boolean hasRead) {
		Review review = null;
		int result = 0;
		Connection connection = getConnection();
		
		review = new ReviewDao().findReviewByNo(connection, no);
		
		if (review != null && !hasRead) {			
			// 게시글 조회수
			result = new ReviewDao().updateReadCount(connection, review);
			
			if (result > 0) {
				
				commit(connection);
			} else {
				
				rollback(connection);
			}
		}
		
		
		
		
		
		
		close(connection);
		
		return review;
	}
	
	

	public int saveRevReply(ReviewReply reviewreply) {
		int result = 0;
		Connection connection = getConnection();
		result = new ReviewDao().insertReviewReply(connection, reviewreply);
		
		
		
		
		
		close(connection);
		return result;
	}

	public int reviewDelete(int no) {
		Connection connection = getConnection();
		int result = 0;
		
		result = new ReviewDao().updateReviewStatus(connection, no, "N");
		
		if (result > 0) {
			
			commit(connection);
		} else {
			
			rollback(connection);
		}
		
		
		
		close(connection);
		return result;
	}

	public List<SearchReview> getSearchReviewList(PageInfo searchpageinfo, SearchReview searchreview) {
		List<SearchReview> searchreviewlist = null;
		Connection connection = getConnection();
		
		searchreviewlist = new ReviewDao().findSearch(connection, searchpageinfo, searchreview);
		
		
		
		
		
		
		close(connection);
		
		return searchreviewlist;
		

	}

	public Review getReviewByNoPre(int preReviewNo) {
		Review review = null;
		Connection connection = getConnection();
		
		review = new ReviewDao().findReviewByNoPre(connection, preReviewNo);
		
		
		
		
		
		
		
		close(connection);
		
		return review;
		

	}

	public Review getReviewByNoNext(int nextReviewNo) {
		
		Review review = null;
		Connection connection = getConnection();
		
		review = new ReviewDao().findReviewByNoNext(connection, nextReviewNo);
		
		
		
		
		
		
		
		close(connection);
		
		return review;
	}


	public int reviewReplyDelete(int replyno) {
		Connection connection = getConnection();
		int result = 0;
		
		result = new ReviewDao().updateReviewReplyStatus(connection, replyno, "N");
		
		if (result > 0) {
			
			commit(connection);
		} else {
			
			rollback(connection);
		}
		
		
		
		close(connection);
		return result;
	}

}
