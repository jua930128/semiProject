package com.kh.semi.room.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.common.util.DateParseUtil;
import com.kh.semi.room.model.service.RoomService;
import com.kh.semi.room.model.vo.Room;

@WebServlet(name = "roomReservation", urlPatterns = { "/room/reservation" })
public class RoomReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RoomReservationServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Room> listDate = null;
		listDate = new RoomService().getReservation();
		
//		
//		List list = new ArrayList();
//			
//		for (int i=1;i<=31;i++){
//			Map listMap = new HashMap();
//			
//			listMap.put("day",i); //일수 입력
//			listMap.put("useAt", "Y");//사용여부 입력
////			listMap.put("info", "user01"); //예약자ID 입력
//			listMap.put("bean", list.add(listMap));
//		}

	    
	    
	    System.out.println(listDate);
	    

		request.getRequestDispatcher("/views/room/reservation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
