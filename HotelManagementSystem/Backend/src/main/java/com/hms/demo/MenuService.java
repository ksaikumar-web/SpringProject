package com.hms.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menurepository;
	
	public List<Menu> show(){
		return menurepository.findAll();
		
	}

}
