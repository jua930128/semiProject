package com.kh.semi.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.board.model.service.ReviewService;
import com.kh.semi.board.model.vo.Review;
import com.kh.semi.member.model.vo.Member;



@WebServlet(name = "reviewUpdate", urlPatterns = { "/board/reviewupdate" })
public class ReviewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public ReviewUpdateServlet() {



    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Member loginMember = (session == null) ? null : (Member)session.getAttribute("loginMember");
		int no = 0;
		no = Integer.parseInt(request.getParameter("no"));
		if(true) {
			
			
			Review review = new ReviewService().getReviewByNo(no, true);
			
//			if(review != null && loginMember.getId() == review.getUser_id())
			if(true) {
				request.setAttribute("review", review);
				request.getRequestDispatcher("/views/board/reviewupdate.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "잘못된 접근입니다.");
				request.setAttribute("location", "/board/review");
				request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
				
			}
			
		} else {
			request.setAttribute("msg", "로그인후 수정해 주세요.");
			request.setAttribute("location", "/board/review");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		

		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		Member loginMember = (session == null) ? null : (Member)session.getAttribute("loginMember");
		
		
//		if(loginMember != null) {
		if(true) {
			Review review = new Review();
			
			review.setNo(Integer.parseInt(request.getParameter("no")));
			review.setRate(request.getParameter("rate"));
			review.setRoom_name(request.getParameter("room_name"));
			review.setTitle(request.getParameter("title"));
			review.setContent(request.getParameter("content"));
			
			
			
			
			int result = new ReviewService().save(review);
			
			if( result > 0) {
				request.setAttribute("msg", "게시글이 수정되었습니다.");
				request.setAttribute("location", "/board/reviewboard?no=" + review.getNo());
			}else {
				request.setAttribute("msg", "게시글 수정에 실패했습니다.");
				request.setAttribute("location", "/board/reviewupdate?no=" + review.getNo());
			}
		} else {
		
		request.setAttribute("msg", "로그인후 수정해 주세요.");
		request.setAttribute("location", "/");
			
			
			
		}
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

}
