package com.kh.semi.room.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.common.util.DateParseUtil;
import com.kh.semi.room.model.service.RoomService;
import com.kh.semi.room.model.vo.Room;


@WebServlet(name = "roomList", urlPatterns = { "/room/roomList" })
public class RoomListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RoomListServlet() {
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Room> listDate = null;
//		String[] getcheckDays = null;
		
		listDate = new RoomService().getRoomListDate();
		String[] checkDays = new RoomService().getcheckDays();
//		todayPlus = new RoomService().getTodayPlus(1);
		
		System.out.println(listDate);


		
		request.getParameterValues("checkDays");
		request.setAttribute("checkDays", checkDays);
		request.setAttribute("listDate", listDate);
		request.getRequestDispatcher("/views/room/roomList.jsp").forward(request, response);
	}

}
