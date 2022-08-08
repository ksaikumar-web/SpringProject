package com.hms.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrationService {

	@Autowired
	private RegistrationRepository repo;
	
	public void saveOrupdate(Registration Registration) {
		repo.save(Registration);
	}
}
