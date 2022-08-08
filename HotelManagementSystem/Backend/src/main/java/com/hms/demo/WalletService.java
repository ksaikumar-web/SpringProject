package com.hms.demo;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class WalletService {

	@Autowired
	WalletRepository repository;
	
	public List<Wallet> showWallets() {
		return repository.findAll();
	}
	
	public List<Wallet> showCustomerWallet(int id) {
		return repository.searchWalletsByCustomerId(id);
	}
	
	public Wallet searchWalletByCustomerIdAndWalletSource(int id, String source) {
		return repository.searchWalletByCustomerIdAndWalletSource(id, source);
	}
	
	public String showWalletAmount(int id, String source) {
		Wallet wallet = repository.showWalletAmount(id, source);
		Double amount = wallet.getWalletAmount();
		return amount.toString();
	}
	
	public List<String> getAllWalletTypes(String emailId) {
		return repository.allWalletTypes(emailId);
	}
	
}
