package com.hms.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {
	
	@Autowired
	private VendorService vendorservice;
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/showVendors")
	public List<Vendor> showVendors(){
		return vendorservice.getall();
	}

}
