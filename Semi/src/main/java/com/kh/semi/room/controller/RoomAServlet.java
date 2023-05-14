package com.kh.semi.room.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.room.model.service.RoomService;
import com.kh.semi.room.model.vo.Room;

@WebServlet(name = "roomA", urlPatterns = { "/room/roomA" })
public class RoomAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RoomAServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	String str = null;
		List<Room> listDate = null;
		listDate = new RoomService().getRoomListDate();
		
		System.out.println("A룸 정보!" + listDate);
		
		request.setAttribute("listDate", listDate);
		request.getRequestDispatcher("/views/room/roomA.jsp").forward(request, response);
		
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
