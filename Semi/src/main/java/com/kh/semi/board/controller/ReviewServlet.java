package com.kh.semi.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.board.model.service.ReviewService;
import com.kh.semi.board.model.vo.Review;
import com.kh.semi.common.util.PageInfo;


@WebServlet(name = "review", urlPatterns = { "/board/review" })
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ReviewServlet() {
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 0;
		int listCount = 0;
		PageInfo pageinfo = null;
		List<Review> list = null;
		
    	
    	try {
    		page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			page = 1;
		}
    	
    	
		listCount = new ReviewService().getReviewCount();
    	pageinfo = new PageInfo(page, 5, listCount, 5);
    	list = new ReviewService().getReviewList(pageinfo);
		
//    	System.out.println(list);
    	
    	request.setAttribute("pageInfo", pageinfo);
    	request.setAttribute("list", list);
		request.getRequestDispatcher("/views/board/review.jsp").forward(request, response);
		
		
		
		
	}

}
