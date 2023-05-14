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
import com.kh.semi.board.model.vo.SearchReview;
import com.kh.semi.common.util.PageInfo;



@WebServlet(name = "reviewSearch", urlPatterns = { "/board/reviewsearch" })
public class ReviewSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public ReviewSearchServlet() {


    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 0;
		int listCount = 0;
		PageInfo searchpageinfo = null;
		List<SearchReview> searchreviewlist = null;
		String searchType = request.getParameter("searchType");
		String searchText = request.getParameter("searchText");
		
		
		
    	try {
    		page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			page = 1;
		}
    	SearchReview searchreview = new SearchReview();
    	
    	searchreview.setSearchType(searchType);
    	searchreview.setSearchText(searchText);
		listCount = new ReviewService().getReviewCount();
    	searchpageinfo = new PageInfo(page, 5, listCount, 5);
    	searchreviewlist = new ReviewService().getSearchReviewList(searchpageinfo, searchreview);
    	System.out.println(searchType);
//		System.out.println(searchText);
		
    	
    	
    	request.setAttribute("pageInfo", searchpageinfo);
    	request.setAttribute("searchreviewlist", searchreviewlist);
		request.getRequestDispatcher("/views/board/reviewsearch.jsp").forward(request, response);
		
		
		
		
	}

}
