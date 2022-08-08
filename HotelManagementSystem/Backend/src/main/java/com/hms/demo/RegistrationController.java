package com.hms.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
	@Autowired
	private RegistrationService RegistrationService;
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/newRegistration")
	public String saveCustomer(@RequestBody Registration Registration) {
		RegistrationService.saveOrupdate(Registration);
		return Registration.getPassword();
	}
	
	

}
