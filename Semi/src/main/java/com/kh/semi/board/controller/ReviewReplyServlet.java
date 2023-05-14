package com.kh.semi.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.board.model.service.ReviewService;
import com.kh.semi.board.model.vo.ReviewReply;
import com.kh.semi.member.model.vo.Member;



@WebServlet(name = "reviewReply", urlPatterns = { "/board/reviewreply" })
public class ReviewReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public ReviewReplyServlet() {


    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		Member loginMember = (session == null) ? null : (Member)session.getAttribute("loginMember");
		int result = 0;
		
		
		
		
		int review_no = Integer.parseInt(request.getParameter("review_no"));
		String commentbox = request.getParameter("commentbox");
		
		ReviewReply reviewreply = new ReviewReply();
		
		reviewreply.setRevNo(review_no);
//		reviewreply.setUserNo(loginMember.getNo());
		reviewreply.setReplyContent(commentbox);
		
		result = new ReviewService().saveRevReply(reviewreply);
		
		if( result > 0 ) {
			request.setAttribute("msg", "댓글이 작성되었습니다..");
			request.setAttribute("location", "/board/reviewboard?no=" + review_no);
			
		} else {
			request.setAttribute("msg", "댓글 등록이 실패하였습니다.");
			request.setAttribute("location", "/board/reviewboard?no=" + review_no);
			
		}
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

}
