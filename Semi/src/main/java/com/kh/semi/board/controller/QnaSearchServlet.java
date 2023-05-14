package com.kh.semi.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.board.model.service.QnaService;
import com.kh.semi.board.model.vo.SearchQna;
import com.kh.semi.common.util.PageInfo;



@WebServlet(name = "qnaSearch", urlPatterns = { "/board/qnasearch" })
public class QnaSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public QnaSearchServlet() {


    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 0;
		int listCount = 0;
		PageInfo searchpageinfo = null;
		List<SearchQna> searchqnalist = null;
		String searchType = request.getParameter("searchType");
		String searchText = request.getParameter("searchText");
		
		
		
    	try {
    		page = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			page = 1;
		}
    	SearchQna searchqna = new SearchQna();
    	
    	searchqna.setSearchType(searchType);
    	searchqna.setSearchText(searchText);
		listCount = new QnaService().getQnaCount();
    	searchpageinfo = new PageInfo(page, 5, listCount, 5);
    	searchqnalist = new QnaService().getSearchQnaList(searchpageinfo, searchqna);
    	System.out.println(searchType);
		System.out.println(searchText);
		
    	
    	
    	request.setAttribute("pageInfo", searchpageinfo);
    	request.setAttribute("searchqnalist", searchqnalist);
		request.getRequestDispatcher("/views/board/qnasearch.jsp").forward(request, response);
		
		
		
		
	}

		
		
	}




