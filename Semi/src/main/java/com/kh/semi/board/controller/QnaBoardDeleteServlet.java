package com.kh.semi.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.board.model.service.QnaService;
import com.kh.semi.board.model.service.ReviewService;



@WebServlet(name = "qnaBoardDelete", urlPatterns = { "/qnaboard/delete" })
public class QnaBoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public QnaBoardDeleteServlet() {


    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		int result = 0;
		
		result = new QnaService().qnaDelete(no);
		
		if ( result > 0) {
			request.setAttribute("msg", "게시글이 삭제 되었습니다.");
			request.setAttribute("location", "/board/qna");
		} else {
			request.setAttribute("msg", "게시글 삭제에 실패했습니다.");
			request.setAttribute("location", "/board/qnaboard?no=" +no);
		}
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}




}
