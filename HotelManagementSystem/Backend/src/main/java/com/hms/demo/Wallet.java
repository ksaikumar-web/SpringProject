package com.hms.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wallet")
public class Wallet {

	@Id
	private int walletId;
	private String emailId;
	private String walletSource;
	private double walletAmount;
	
	public int getWalletId() {
		return walletId;
	}
	
	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}
	
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getWalletSource() {
		return walletSource;
	}
	
	public void setWalletSource(String walletSource) {
		this.walletSource = walletSource;
	}
	
	public double getWalletAmount() {
		return walletAmount;
	}
	
	public void setWalletAmount(double walletAmount) {
		this.walletAmount = walletAmount;
	}
	
	
}
