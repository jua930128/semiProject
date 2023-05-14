package com.kh.semi.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.board.model.service.QnaService;
import com.kh.semi.board.model.service.ReviewService;
import com.kh.semi.board.model.vo.Qna;
import com.kh.semi.board.model.vo.Review;



@WebServlet(asyncSupported = true, name = "qnaboard", urlPatterns = { "/board/qnaboard" })
public class QnaBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public QnaBoardServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Qna qna = null;

		
		
		int no = Integer.parseInt(request.getParameter("no"));
		qna = new QnaService().getQnaByNo(no);



	    	
	    	
		   request.setAttribute("qna", qna);
	       request.getRequestDispatcher("/views/board/qnaboard.jsp").forward(request, response);
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
