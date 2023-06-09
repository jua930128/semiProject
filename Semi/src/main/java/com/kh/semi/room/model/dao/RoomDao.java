
package com.kh.semi.room.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.room.model.vo.Room;
import com.kh.semi.common.util.DateParseUtil;
import static com.kh.semi.common.jdbc.JDBCTemplate.close;

public class RoomDao {

	public List<Room> findAll(Connection connection) {
		List<Room> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT RSV.RSV_NO, "
				+ "       RSV.CHECK_IN, "
				+ "       RSV.CHECK_OUT, "
				+ "       RSV.RSV_PRICE, "
				+ "       RSV.RSV_COUNT, "
				+ "       RSV.RSV_REQ, "
				+ "       RSV.ROOM_NO, "
				+ "       RSV.OPT_ID, "
				+ "       RSV.USER_NO, "
				+ "       ROOM.ROOM_KRNAME, "
				+ "       ROOM.ROOM_PRICE, "
				+ "       ROOM.ROOM_INFO, "
				+ "       ROOM.ROOM_ENNAME "
				+ "FROM RSV RSV "
				+ "INNER JOIN ROOM ROOM ON (RSV.ROOM_NO = ROOM.ROOM_NO) ";
		
		try {
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Room room = new Room();
				
				room.setRsvNo(rs.getInt("RSV_NO"));
				room.setCheckIn(rs.getDate("CHECK_IN"));
				room.setCheckOut(rs.getDate("CHECK_OUT"));
				room.setRsvPrice(rs.getInt("RSV_PRICE"));
				room.setRsvNo(rs.getInt("RSV_COUNT"));
				room.setRsvReq(rs.getString("RSV_REQ"));
				room.setRoomNo(rs.getInt("ROOM_NO"));
				room.setOptId(rs.getInt("OPT_ID"));
				room.setUserNo(rs.getInt("USER_NO"));
				room.setRoomKrName(rs.getString("ROOM_KRNAME"));
				room.setRoomEnName(rs.getString("ROOM_ENNAME"));
				room.setRoomPrice(rs.getInt("ROOM_PRICE"));
				room.setRoomInfo(rs.getString("ROOM_INFO"));
				
				list.add(room);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				close(rs);
				close(pstmt);
		}
		
		return list;
	}
	
	// 날짜 선택 후 객실 검색
	public List<Room> findlistDate(Connection connection) {
		List<Room> listDate = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT ROOM.ROOM_KRNAME, "
				+ "ROOM.ROOM_ENNAME, "
				+ "ROOM.ROOM_PRICE, "
				+ "ROOM.ROOM_INFO, "
				+ "RD.CHECK_IN, "
				+ "RD.CHECK_OUT "
				+ "FROM ROOM ROOM "
				+ "INNER JOIN RSV_DATE RD ON (ROOM.ROOM_NO = RD.ROOM_NO) "
				+ "WHERE RD.CHECK_OUT BETWEEN CHECK_IN AND CHECK_OUT ";
		
		try {
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Room roomDate = new Room();
				
				roomDate.setRoomKrName(rs.getString("ROOM_KRNAME"));
				roomDate.setRoomEnName(rs.getString("ROOM_ENNAME"));
				roomDate.setRoomPrice(rs.getInt("ROOM_PRICE"));
				roomDate.setRoomInfo(rs.getString("ROOM_INFO"));
				roomDate.setCheckIn(rs.getDate("CHECK_IN"));
				roomDate.setCheckOut(rs.getDate("CHECK_OUT"));
				
				
//				room.setCheckOut("DateParseUtil.strToDate("DateParseUtil.getTodayPlus(1)")");
				listDate.add(roomDate);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return listDate;
	}
	
	
	// 객실 상세정보 조회
	public List<Room> findDetail(Connection connection) {
		List<Room> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT ROOM_KRNAME, "
				+ "ROOM_ENNAME "
				+ "FROM ROOM ";
		
		try {
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Room room = new Room();
				
				room.setRoomKrName(rs.getString("ROOM_KRNAME"));
				room.setRoomEnName(rs.getString("ROOM_ENNAME"));
				
				
				list.add(room);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

	// 결제할 객실 정보 조회
	public List<Room> reservation(Connection connection) {
		List<Room> list = new ArrayList<>();
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//	    
//		String query = "SELECT ROOM_KRNAME, "
//				+ "ROOM_ENNAME, "
//				+ "ROOM_PRICE, "
//				+ "ROOM_INFO, "
//				+ "CHECK_IN, "
//				+ "CHECK_OUT "
//				+ "FROM ROOM ";
//		
//		try {
//			pstmt = connection.prepareStatement(query);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//
//				Room room = new Room();
//
//				room.setRoomKrName(rs.getString("ROOM_KRNAME"));
//				room.setRoomEnName(rs.getString("ROOM_ENNAME"));
//				room.setRoomPrice(rs.getInt("ROOM_PRICE"));
//				room.setRoomInfo(rs.getString("ROOM_INFO"));
//				room.setCheckIn(rs.getDate("CHECK_IN"));
//				room.setCheckOut(rs.getDate("CHECK_OUT"));
//				
//				list.add(room);
//				
//				
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//				close(rs);
//				close(pstmt);
//		}
		
		return list;
	}
	
	
	


	
//	package dao;
//
//	import java.sql.Connection;
//	import java.sql.DriverManager;
//	import java.sql.PreparedStatement;
//	import java.sql.ResultSet;
//	import java.time.LocalDate;
//	import java.util.ArrayList;
//
//	import javax.servlet.http.HttpServletRequest;
//	import javax.servlet.http.HttpServletResponse;
//	import javax.servlet.http.HttpSession;
//
//	import dto.ReserveDto;
//	import dto.RoomDto;
//
//	public class ReserveDao {
//
//		Connection conn;
//		PreparedStatement pstmt;
//		
//		public ReserveDao() throws Exception {
//			Class.forName("com.mysql.jdbc.Driver");
//			String db = "jdbc:mysql://localhost:3306/pension";
//			conn = DriverManager.getConnection(db, "root", "5032");
//		}
//		
//		public void close() throws Exception {
//			pstmt.close();
//			conn.close();
//		}
//		
//		public void getCalendar(HttpServletRequest request) {
//			/* 달력 => 1일의 요일, 총일수, 주수.. 를 구해서 request 영역에 저장 */
//			
//			// 매개변수 처리
//			int yy,mm;
//			if(request.getParameter("y") == null) {
//				// 오늘 날짜 정보 가져오기
//				LocalDate today = LocalDate.now();
//				yy = today.getYear();
//				mm = today.getMonthValue();	// 1-12
//			} else {
//				// 매개변수 값 저장
//				yy = Integer.parseInt(request.getParameter("y"));
//				mm = Integer.parseInt(request.getParameter("m"));
//			}
//			
//			
//			// 해당월의 1일에 대한 날짜객체 생성
//			LocalDate thisMonth = LocalDate.of(yy, mm, 1);
//			
//			// 1일의 요일
//			int yoil = thisMonth.getDayOfWeek().getValue();	// 1-7
//			if(yoil == 7)	 yoil = 0; // 월-일 => 일-토 변경
//			
//			// 해당월의 총일수
//			int total = thisMonth.lengthOfMonth();
//			
//			// 주수 계산 (몇 주인가)
//			int howManyWeeks = (int)Math.ceil((yoil+total)/7.0);
//			
//			request.setAttribute("yoil", yoil);
//			request.setAttribute("total", total);
//			request.setAttribute("weeks", howManyWeeks);
//			request.setAttribute("month", mm);
//			request.setAttribute("year", yy);
//		}
//		
//		public void getRoom(HttpServletRequest request) throws Exception {
//			
//			String sql = "select * from room where state=0 order by price asc";
//			pstmt = conn.prepareStatement(sql);
//			ResultSet rs = pstmt.executeQuery();
//			ArrayList<RoomDto> list = new ArrayList<RoomDto>();
//			
//			while(rs.next()) {
//				RoomDto dto = new RoomDto();
//				dto.setId(rs.getInt("id"));
//				dto.setBang(rs.getString("bang"));
//				dto.setPrice(rs.getInt("price"));
//				dto.setState(rs.getInt("state"));
//				dto.setMax(rs.getInt("max"));
//				dto.setMin(rs.getInt("min"));
//				list.add(dto);
//			}
//			request.setAttribute("list", list);
//			rs.close();
//		}
//		
//		public void reserve_next(HttpServletRequest request) throws Exception {
//			// JSP에 보내줄 내용 => 년, 월, 일, 방의 정보
//			int year,month,day;
//			year = Integer.parseInt(request.getParameter("y"));
//			month = Integer.parseInt(request.getParameter("m"));
//			day = Integer.parseInt(request.getParameter("d"));
//			String id = request.getParameter("bid");
//			
//			// 입실일
//			String checkIn = year +"-"+ month +"-"+ day;
//			
//			// 방의 정보
//			String sql = "select * from room where id=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			ResultSet rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				RoomDto dto = new RoomDto();
//				dto.setId(rs.getInt("id"));
//				dto.setBang(rs.getString("bang"));
//				dto.setContent(rs.getString("content"));
//				dto.setMin(rs.getInt("min"));
//				dto.setMax(rs.getInt("max"));
//				dto.setPrice(rs.getInt("price"));
//				dto.setState(rs.getInt("state"));
//				request.setAttribute("room", dto);
//				request.setAttribute("checkin", checkIn);
//			}
//			rs.close();
////			close();
//		}
//		
//		public void reserve_ok(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
//			request.setCharacterEncoding("utf-8");
//			
//			// 입실일자 날짜객체로 저장
//			String checkin = request.getParameter("checkin");
//			String[] inDate = checkin.split("-");
//			int inYear = Integer.parseInt(inDate[0]);
//			int inMonth = Integer.parseInt(inDate[1]);
//			int inDay = Integer.parseInt(inDate[2]);
//			LocalDate in = LocalDate.of(inYear, inMonth, inDay);
//			
//			// 퇴실일자 날짜객체로 저장
//			int howLong = Integer.parseInt(request.getParameter("howLong"));
//			LocalDate out = in.plusDays(howLong);
//			
//			String sql = "insert into reserve";
//			sql += "(checkin, checkout, userid, bangid, inwon, charcoal, bbq, total, writeday) ";
//			sql += "values(?,?,?,?,?,?,?,?,now())";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, checkin);
//			pstmt.setString(2, out.toString());
//			pstmt.setString(3, session.getAttribute("userid").toString());
//			pstmt.setString(4, request.getParameter("bangid"));
//			pstmt.setString(5, request.getParameter("howMany"));
//			pstmt.setString(6, request.getParameter("charcoal"));
//			pstmt.setString(7, request.getParameter("bbq"));
//			pstmt.setString(8, request.getParameter("total"));
//			pstmt.executeUpdate();
//			
//			close();
//			response.sendRedirect("reserve_view.jsp");
//
//		}
//		
//		public void reserve_view(HttpServletRequest request, HttpSession session) throws Exception {
//			//String sql = "select * from reserve where userid=?";
//			//String sql = "select * from reserve,room where reserve.userid=? and room.id=reserve.bangid";
//			//String sql = "select reserve.*,bang from reserve,room where reserve.userid=? and room.id=reserve.bangid";
//			String sql = "select A.*,bang from reserve A,room B where A.userid=? and B.id=A.bangid";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, session.getAttribute("userid").toString());
//			ResultSet rs = pstmt.executeQuery();
//			ArrayList<ReserveDto> list = new ArrayList<ReserveDto>();
//			while(rs.next()) {
//				ReserveDto dto = new ReserveDto();
//				dto.setId(rs.getInt("id"));
//				dto.setBangid(rs.getInt("bangid"));
//				dto.setBbq(rs.getInt("bbq"));
//				dto.setCharcoal(rs.getInt("charcoal"));
//				dto.setCheckin(rs.getString("checkin"));
//				dto.setCheckout(rs.getString("checkout"));
//				dto.setInwon(rs.getInt("inwon"));
//				dto.setTotal(rs.getInt("total"));
//				dto.setUserid(rs.getString("userid"));
//				dto.setWriteday(rs.getString("writeday"));
//				dto.setBang(rs.getString("bang"));
//				dto.setState(rs.getInt("state"));
//				list.add(dto);
//			}
//			request.setAttribute("reserve", list);
//			
//			rs.close();
//			close();
//		}
//		
//		public void getEmpty(HttpServletRequest request, String selectedDay, String bangid) throws Exception {
//			
//			String sql = "select count(*) cnt ";
//			sql += "from reserve ";
//			sql += "where checkin <= ? and ";
//			sql += "? < checkout and ";
//			sql += "bangid = ?";
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, selectedDay);
//			pstmt.setString(2, selectedDay);
//			pstmt.setString(3, bangid);
//			ResultSet rs = pstmt.executeQuery();
//			rs.next();
//			request.setAttribute("cnt", rs.getString("cnt"));
//			
//		}
//		
//		public void getAvail(HttpServletRequest request, String y, String m, String d) throws Exception {
//			int year = Integer.parseInt(y);
//			int month = Integer.parseInt(m);
//			int day = Integer.parseInt(d);
//			
//			LocalDate today = LocalDate.now();
//			LocalDate dday = LocalDate.of(year, month, day);
//			
//			if(today.isBefore(dday)) {
//				request.setAttribute("avail", 1);
//			} else if(today.isAfter(dday)) {			
//				request.setAttribute("avail", 0);
//			} else {
//				request.setAttribute("avail", 1);			
//			}
//		}
//		
//		public void getSuk(HttpServletRequest request) throws Exception {
//			
//			// 체크인 날짜 (String)
//			String ymd = request.getAttribute("checkin").toString();
//			// 예약하려는 객실 정보
//			RoomDto dto = (RoomDto)request.getAttribute("room");
//			
//			// 체크인 날짜 (String -> 날짜객체)
//			String[] checkin = ymd.split("-");
//			int year = Integer.parseInt(checkin[0]);
//			int month = Integer.parseInt(checkin[1]);
//			int day = Integer.parseInt(checkin[2]);
//			LocalDate dday = LocalDate.of(year, month, day);		
//			
//			// 숙박 가능 여부 체크
//			String sql = "";
//			int available = 0;	// 가능 일수
//			for(int i=1; i<=5; i++) {
//				available++;
//				LocalDate xday = dday.plusDays(i);
//				
//				sql = "select * from reserve where checkin<=? and ?<checkout and bangid=?";
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, xday.toString());
//				pstmt.setString(2, xday.toString());
//				pstmt.setInt(3, dto.getId());
//				ResultSet rs = pstmt.executeQuery();
//				//System.out.println(pstmt.toString());
//				if(rs.next())
//					break;
//			}
//			
//			request.setAttribute("available", available);
//		}
//		
//		public void state_change(HttpServletRequest request, HttpServletResponse response) throws Exception {
//			
//			String id = request.getParameter("id");
//			String state = request.getParameter("state");
//			String sql = "update reserve set state=? where id=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, state);
//			pstmt.setString(2, id);
//			pstmt.executeUpdate();
//			
//			close();
//			response.sendRedirect("reserve_view.jsp");
//		}
//		
//		
//		
//		
//	}
	
	
	
	
	
}
