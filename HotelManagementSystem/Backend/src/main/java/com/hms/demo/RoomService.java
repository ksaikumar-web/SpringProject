package com.hms.demo;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoomService {
	
	@Autowired
	RoomRepository repository;
	
	public List<Room> showRooms(){
		return repository.findAll();
	}
	
	public void saveOrUpdate(Room room)
	{
		repository.save(room);
	}
	
	public void update(Room room, int roomId)
	{
		repository.save(room);
	}
	public void delete(int roomId)
	{
		repository.deleteById(roomId);
	}
}
