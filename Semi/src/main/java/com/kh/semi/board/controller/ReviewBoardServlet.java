package com.kh.semi.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.board.model.service.ReviewService;
import com.kh.semi.board.model.vo.Review;


@WebServlet(name = "reviewboard", urlPatterns = { "/board/reviewboard" })
public class ReviewBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReviewBoardServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Review review = null;
		Review preReview = null;
		Review nextReview = null;
		
		
		int no = Integer.parseInt(request.getParameter("no"));
	    int preReviewNo = ( no - 1 );
	    int nextReviewNo = ( no + 1 );
		
		
		
		// 쿠키에 게시글을 조회한 이력이 있는지 확인 
		 Cookie[] cookies = request.getCookies();
		 String boardHistory = "";
		 boolean hasRead = false;
		 
		 if(cookies != null) {
			 for (Cookie cookie : cookies) {
				 if (cookie.getName().equals("boardHistory")) {
					 boardHistory = cookie.getValue();
					 if (boardHistory.contains("|" +no+ "|")) {
						hasRead = true;
						break;
					}	
				}
			}
		 } else {
			 
		 }
		 
		 // 읽지 않은 게시글일시 쿠키에 기록
		 if(!hasRead) {
			 Cookie cookie = new Cookie("boardHistory", boardHistory + "|" + no + "|");
			 
			 cookie.setMaxAge(-1);
			 response.addCookie(cookie);
		 }
		 
		 
		 
		
		review = new ReviewService().getReviewByNo(no, hasRead);
	    preReview = new ReviewService().getReviewByNoPre(preReviewNo);
	    nextReview = new ReviewService().getReviewByNoNext(nextReviewNo);


	    	
	    	
		   request.setAttribute("review", review);
		   request.setAttribute("preReview", preReview);
		   request.setAttribute("nextReview", nextReview);
	       request.getRequestDispatcher("/views/board/reviewboard.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
