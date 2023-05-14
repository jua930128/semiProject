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
import com.kh.semi.board.model.vo.Qna;
import com.kh.semi.board.model.vo.Review;
import com.kh.semi.member.model.vo.Member;


@WebServlet(name = "writeqna", urlPatterns = { "/board/writeqna" })
public class WriteQnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public WriteQnaServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		Member loginMember = (session == null) ? null : (Member)session.getAttribute("loginMember");
		
		if(true) {
			
			request.getRequestDispatcher("/views/board/writeqna.jsp").forward(request, response);
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
			
			
			Qna qna = new Qna();
			
			qna.setTitle(request.getParameter("title"));
			qna.setWriter(request.getParameter("writer"));
			qna.setContent(request.getParameter("content"));

			
		

			
			int result = new QnaService().save(qna);
			
			if(result > 0) {
				
				request.setAttribute("msg", "게시글 등록 성공");
				request.setAttribute("location", "/board/qna");
			} else {
				
				request.setAttribute("msg", "게시글 등록 실패");
				request.setAttribute("location", "/board/qna");
			}

			
		
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
		
		} else {
			request.setAttribute("msg", "로그인후 작성해 주세요.");
			request.setAttribute("location", "/board/qba");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			
		}
		
		
		
	}
	    	


 	}


