package com.hms.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
	@Autowired
	private MenuService menuservice;
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/showMenu")
	public List<Menu> showmenu(){
		return menuservice.show();
	}
	

}
