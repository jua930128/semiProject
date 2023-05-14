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


@WebServlet(name = "writereview", urlPatterns = { "/board/writereview" })
public class WriteReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public WriteReviewServlet() {
  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Member loginMember = (session == null) ? null : (Member)session.getAttribute("loginMember");
		
		if(true) {
			
			request.getRequestDispatcher("/views/board/writereview.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "로그인후 작성해 주세요.");
			request.setAttribute("location", "/board/review");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			
		}
		
		
		
	}
	
	
	
		
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		Member loginMember = (session == null) ? null : (Member)session.getAttribute("loginMember");
		
		if(true) {
			
			
			Review review = new Review();
			
			review.setTitle(request.getParameter("title"));
			review.setWriter(request.getParameter("writer"));
			review.setContent(request.getParameter("content"));
			review.setRate(request.getParameter("rate"));
			review.setRoom_name(request.getParameter("room_name"));
			
		

			
			int result = new ReviewService().save(review);
			
			if(result > 0) {
				
				request.setAttribute("msg", "게시글 등록 성공");
				request.setAttribute("location", "/board/review");
			} else {
				
				request.setAttribute("msg", "게시글 등록 실패");
				request.setAttribute("location", "/board/review");
			}

			
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
		
		} else {
			request.setAttribute("msg", "로그인후 작성해 주세요.");
			request.setAttribute("location", "/board/review");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			
		}
		
		
		
	}
	    	


 	}


