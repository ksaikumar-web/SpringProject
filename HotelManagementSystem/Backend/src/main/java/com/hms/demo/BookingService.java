package com.hms.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookrepo;
	@Autowired
	private RoomRepository roomrepo;
	@Autowired
	private MenuDAO mdao;
	@Autowired
	private WalletDAO wdao;
	@Autowired
	private RoomDAO rdao;
	@Autowired
	JdbcTemplate template;
	
	public List<Booking> showall(){
		return bookrepo.findAll();
	}
	
	public Room showroomid(int roomId) {
		return roomrepo.findById(roomId).get();
	}

	public String saveOrUpdate(Booking Booking)
	{
		System.out.println(Booking.getBookingDate());
		Menu menu = mdao.searchMenu(Booking.getMenuId());
		Wallet wall = wdao.showCustomerWallet(Booking.getEmailId(), Booking.getWalletSource());
		Room room=rdao.searchRoom(Booking.getRoomId());
		System.out.println(room.getRoom_status());
		if((room.getRoom_status()).equals("Available")) {
			double balance = wall.getWalletAmount();
			double billAmount = Booking.getDays()*(menu.getMenuPrice()+room.getPrice());
			System.out.println(balance);
			System.out.println(billAmount);
			if(balance-billAmount > 0) {
				Booking.setBookingStatus("Booked successfully");
				Booking.setBillAmount(Booking.getDays()*menu.getMenuPrice());
				bookrepo.save(Booking);
				rdao.updateRoom(Booking.getRoomId(),"BOOKED");
				wdao.updateWallet(Booking.getEmailId(), Booking.getWalletSource(), billAmount);
				return "Room Booking done Successfully";
			}
			return "Insuffiecient Funds....";
		}
		return "Room is not available currently";
		
		
	}

	public List<Booking> showCustomerOrders(String emailId) {
		return rdao.showCustomerOrders(emailId);
	}
		
	
	
	
}
