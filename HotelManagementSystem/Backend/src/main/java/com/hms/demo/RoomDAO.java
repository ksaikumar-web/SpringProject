package com.hms.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDAO {
	
	@Autowired
	JdbcTemplate jdbc;

	public Room searchRoom(int roomId) {
		String cmd="select * from room where room_id=?";
		List<Room> roomList=jdbc.query(cmd,new Object[] {roomId},new RowMapper<Room>() {
			@Override
			public Room mapRow(ResultSet rs,int arg1) throws SQLException{
				Room room=new Room();
				room.setRoomId(rs.getInt("ROOM_ID"));
				room.setRoom_type(rs.getString("ROOM_TYPE"));
				room.setPrice(rs.getInt("PRICE"));
				room.setRoom_status(rs.getString("ROOM_STATUS"));
				return room;
			}
		});
		return roomList.get(0);
	}

	public String updateRoom(int roomId,String status) {
		String cmd = "Update Room set ROOM_STATUS=?"
				+ " WHERE ROOM_ID=?";
		jdbc.update(cmd, new Object[] {status,roomId});
		return "Updated room status";
		
	}
	public List<Booking> showCustomerOrders(String emailId) {
		String cmd = "select * from booking where  email_id=?";
		List<Booking> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {emailId}, new RowMapper<Booking>() {

			@Override
			public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
				Booking orders = new Booking();
				orders.setBookingId(rs.getInt("BOOKING_ID"));
				orders.setEmailId(rs.getString("EMAIL_ID"));
				orders.setMenuId(rs.getInt("MENU_ID"));
				orders.setWalletSource(rs.getString("WALLET_SOURCE"));
				orders.setDays(rs.getInt("DAYS"));
				orders.setRoomId(rs.getInt("ROOM_ID"));
				orders.setBookingDate(rs.getDate("BOOKING_DATE"));
				orders.setBillAmount(rs.getDouble("BILL_AMOUNT"));
				orders.setBookingStatus(rs.getString("BOOKING_STATUS"));
				return orders;
			}
			
		});
		return ordersList;
	}
	
	

}
