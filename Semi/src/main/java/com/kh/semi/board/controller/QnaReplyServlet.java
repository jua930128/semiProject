package com.kh.semi.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.board.model.service.QnaService;
import com.kh.semi.board.model.service.ReviewService;
import com.kh.semi.board.model.vo.QnaReply;
import com.kh.semi.board.model.vo.ReviewReply;
import com.kh.semi.member.model.vo.Member;



@WebServlet(name = "qnaReply", urlPatterns = { "/board/qnareply" })
public class QnaReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public QnaReplyServlet() {


    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		Member loginMember = (session == null) ? null : (Member)session.getAttribute("loginMember");
		int result = 0;
		
		
		
		
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		String commentbox = request.getParameter("commentbox");
		
		QnaReply qnareply = new QnaReply();
		
		qnareply.setNo(qna_no);
//		qnareply.setUserNo(loginMember.getNo());
		qnareply.setReply_con(commentbox);
		
		result = new QnaService().saveQnaReply(qnareply);
		
		if( result > 0 ) {
			request.setAttribute("msg", "답변이 작성되었습니다.");
			request.setAttribute("location", "/board/qnaboard?no=" + qna_no);
			
		} else {
			request.setAttribute("msg", "답변 등록이 실패하였습니다.");
			request.setAttribute("location", "/board/qnaboard?no=" + qna_no);
			
		}
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

		
	}


