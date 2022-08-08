package com.hms.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
	
	
	@Autowired
	RoomService service;
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/showRooms")
	public List<Room> showRooms(){
		return service.showRooms();
		
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addNewRoom")
	private int saveProduct(@RequestBody Room room)
	{
		service.saveOrUpdate(room);
		return room.getRoomId();
	}
	@CrossOrigin(origins = "http://localhost:3000")
	 @PutMapping("/updateRoom")
	    private Room update(@RequestBody Room room)
	    {
	     service.saveOrUpdate(room);
	     return room;
	    }
	@CrossOrigin(origins = "http://localhost:3000")
	    @DeleteMapping("deleteRoom/{roomId}")
	    public void deleteProduct(@PathVariable("roomId") int roomId)
	    {
	    	service.delete(roomId);
	    }

}
