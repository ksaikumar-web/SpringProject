package com.hms.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
	@Autowired
	private BookingService bookservice;
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/showbookings")
	public List<Booking> showBookings(){
		return bookservice.showall();
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/showBooking/{cid}")
	public List<Booking> customerPendingOrders(@PathVariable String cid) {
		return bookservice.showCustomerOrders(cid);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/showById/{roomId}")
	public Room showrooms(@PathVariable int roomId) {
		return bookservice.showroomid(roomId);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addNewBooking")
	private String saveProduct(@RequestBody Booking Booking)
	{
		return bookservice.saveOrUpdate(Booking);
	}

}
