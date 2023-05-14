package com.kh.semi.board.model.service;

import static com.kh.semi.common.jdbc.JDBCTemplate.close;
import static com.kh.semi.common.jdbc.JDBCTemplate.commit;
import static com.kh.semi.common.jdbc.JDBCTemplate.getConnection;
import static com.kh.semi.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.board.model.dao.QnaDao;
import com.kh.semi.board.model.dao.ReviewDao;
import com.kh.semi.board.model.vo.Qna;
import com.kh.semi.board.model.vo.QnaReply;
import com.kh.semi.board.model.vo.Review;
import com.kh.semi.board.model.vo.SearchQna;
import com.kh.semi.board.model.vo.SearchReview;
import com.kh.semi.common.util.PageInfo;

public class QnaService {
	
	public int getQnaCount() {
		int count = 0;

		Connection connection = getConnection();
		
		count = new QnaDao().getQnaCount(connection);
		
		
		close(connection);
		return count;
	}
	
	
	public List<Qna> getQnaList(PageInfo pageinfo) {
		List<Qna> list = null;
		Connection connection = getConnection();
		
		list = new QnaDao().findAll(connection, pageinfo);
		
		
		
		
		
		
		
		close(connection);
		return list;
	}


	public Qna getQnaByNo(int no) {
		Qna qna = null;
		Connection connection = getConnection();
		
		qna = new QnaDao().findQnaByNo(connection, no);
		
		
		close(connection);
		
		return qna;

	}


	public int save(Qna qna) {
		int result = 0;
		Connection connection = getConnection();
		
		if(qna.getNo() > 0) {
			// update 작업
			result = new QnaDao().updateQna(connection, qna);
			
			
		} else {
			// insert 작업
			
			result = new QnaDao().insertQna(connection, qna);
			
			
		}
		
		
		if( result > 0 ) {
			commit(connection);
		} else {
			rollback(connection);
		} 
		
		
		
		
		
		
		close(connection);
		return result;
	}


	public int qnaDelete(int no) {
		Connection connection = getConnection();
		int result = 0;
		
		result = new QnaDao().updateQnaStatus(connection, no, "N");
		
		if (result > 0) {
			
			commit(connection);
		} else {
			
			rollback(connection);
		}
		
		
		
		close(connection);
		return result;
	}


	public int saveQnaReply(QnaReply qnareply) {
		int result = 0;
		Connection connection = getConnection();
		result = new QnaDao().insertQnaReply(connection, qnareply);
		
		if( result > 0) {
			int check = 0;
			check = new QnaDao().checkQna(connection, qnareply);
			
			
//			if( check > 0) {
//				commit(connection);
//			} else {
//				rollback(connection);
//			}
		}
		
		
		
		close(connection);
		return result;
	}


	public List<SearchQna> getSearchQnaList(PageInfo searchpageinfo, SearchQna searchqna) {
		List<SearchQna> searchqnalist = null;
		Connection connection = getConnection();
		
		searchqnalist = new QnaDao().findSearch(connection, searchpageinfo, searchqna);
		
		
		
		
		
		
		close(connection);
		
		return searchqnalist;
		
	}
	}



