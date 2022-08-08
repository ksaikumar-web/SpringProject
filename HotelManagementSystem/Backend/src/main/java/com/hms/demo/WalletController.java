package com.hms.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

	@Autowired
	WalletService service;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "showwallets")
	public List<Wallet> showWallets() {
		return service.showWallets();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "searchwallets/{id}")
	public List<Wallet> searchWalletByCustomerId(@PathVariable int id) {
		return service.showCustomerWallet(id);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "searchwallet/{id}/{source}")
	public ResponseEntity<Wallet> searchWalletByCustomerIdAndWalletSource(@PathVariable int id, @PathVariable String source) {
		try {
			Wallet wallet = service.searchWalletByCustomerIdAndWalletSource(id, source);
			return new ResponseEntity<Wallet>(wallet, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Wallet>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "showamount/{id}/{source}")
	public ResponseEntity<String> showWalletAmount(@PathVariable int id, @PathVariable String source) {
		try {
			String amount = service.showWalletAmount(id, source);
			return new ResponseEntity<String>(amount, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "getallwalletsource/{customerId}")
	public List<String> getAllWalletSource(@PathVariable String customerId) {
		return service.getAllWalletTypes(customerId);
	}
}
