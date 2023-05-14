package com.kh.semi.room.model.service;

import java.sql.Connection;
import java.util.List;

import static com.kh.semi.common.jdbc.JDBCTemplate.getConnection;

import com.kh.semi.common.util.DateParseUtil;
import com.kh.semi.room.model.dao.RoomDao;
import com.kh.semi.room.model.vo.Room;

public class RoomService {
	// 객실 목록 조회
	public List<Room> getRoomList() {
		Connection connection = getConnection();

		List<Room> list = null;
		
		list = new RoomDao().findlistDate(connection);
		
		return list;
	}

	// 날짜 선택 후 객실 검색
	public List<Room> getRoomListDate() {
		Connection connection = getConnection();

		List<Room> listDate = null;
		
		listDate = new RoomDao().findlistDate(connection);
		
		return listDate;
	}


	
	// 결제할 객실 정보 조회
	public List<Room> getReservation() {
		Connection connection = getConnection();

		List<Room> list = null;
		
		list = new RoomDao().reservation(connection);
		
		return list;
	}
	
	
	





	public String[] getcheckDays() {

		return null;
	}

	
	
	



	
}
