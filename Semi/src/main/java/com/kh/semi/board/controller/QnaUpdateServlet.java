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



@WebServlet(name = "qnaUpdate", urlPatterns = { "/board/qnaupdate" })
public class QnaUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public QnaUpdateServlet() {


    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Member loginMember = (session == null) ? null : (Member)session.getAttribute("loginMember");
		int no = 0;
//		System.out.println((request.getParameter("no")));
     	no = Integer.parseInt(request.getParameter("no"));
		if(true) {
			
			
			Qna qna = new QnaService().getQnaByNo(no);
			
//			if(review != null && loginMember.getId() == review.getUser_id())
			if(true) {
				request.setAttribute("qna", qna);
				request.getRequestDispatcher("/views/board/qnaupdate.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "잘못된 접근입니다.");
				request.setAttribute("location", "/board/qna");
				request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
				
			}
			
		} else {
			request.setAttribute("msg", "로그인후 수정해 주세요.");
			request.setAttribute("location", "/board/qna");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		

		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		Member loginMember = (session == null) ? null : (Member)session.getAttribute("loginMember");
		
		
//		if(loginMember != null) {
		if(true) {
			Qna qna = new Qna();
			
			qna.setNo(Integer.parseInt(request.getParameter("no")));
			qna.setTitle(request.getParameter("title"));
			qna.setContent(request.getParameter("content"));
			
			
			
			
			int result = new QnaService().save(qna);
			
			if( result > 0) {
				request.setAttribute("msg", "게시글이 수정되었습니다.");
				request.setAttribute("location", "/board/qnaboard?no=" + qna.getNo());
			}else {
				request.setAttribute("msg", "게시글 수정에 실패했습니다.");
				request.setAttribute("location", "/board/qnaupdate?no=" + qna.getNo());
			}
		} else {
		
		request.setAttribute("msg", "로그인후 수정해 주세요.");
		request.setAttribute("location", "/");
			
			
			
		}
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}
	

}
