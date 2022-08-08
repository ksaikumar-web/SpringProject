package com.hms.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class WalletDAO {

	@Autowired  
    JdbcTemplate jdbc;  
	
	public String refundWallet(String cid, String walType, double walAmount) {
		String cmd = "Update Wallet set WALLET_AMOUNT=WALLET_AMOUNT+? "
				+ " WHERE EMAIL_ID=? AND wallet_source=?";
		jdbc.update(cmd, new Object[] {walAmount,cid,walType});
		return "Amount Debited from Wallet...";
	}
	
	public String updateWallet(String emailId, String walType, double walAmount) {
		String cmd = "Update Wallet set WALLET_AMOUNT=WALLET_AMOUNT-? "
				+ " WHERE EMAIL_ID=? AND wallet_source=?";
		jdbc.update(cmd, new Object[] {walAmount,emailId,walType});
		return "Amount Debited from Wallet...";
	}
	
	public Wallet showCustomerWallet(String emailId,String walType) {
		String cmd = "select * from Wallet where email_id=? AND wallet_source=?";
		List<Wallet> wallets=null;
		wallets=jdbc.query(cmd,new Object[] {emailId,walType}, new RowMapper<Wallet>() {

			@Override
			public Wallet mapRow(ResultSet rs, int rowNum) throws SQLException {
				Wallet wallet = new Wallet();
				wallet.setWalletId(rs.getInt("WALLET_ID"));
				wallet.setEmailId(rs.getString("EMAIL_ID"));
				wallet.setWalletAmount(rs.getDouble("WALLET_AMOUNT"));
				wallet.setWalletSource(rs.getString("WALLET_SOURCE"));
				return wallet;
			}
			
		});
		return wallets.get(0);
	}
	public List<Wallet> showCustomerWallets(String emailId) {
		String cmd = "select * from Wallet where email_id=?";
		List<Wallet> wallets=null;
		wallets=jdbc.query(cmd,new Object[] {emailId}, new RowMapper<Wallet>() {

			@Override
			public Wallet mapRow(ResultSet rs, int rowNum) throws SQLException {
				Wallet wallet = new Wallet();
				wallet.setWalletId(rs.getInt("WALLET_ID"));
				wallet.setEmailId(rs.getString("EMAIL_ID"));
				wallet.setWalletAmount(rs.getDouble("WALLET_AMOUNT"));
				wallet.setWalletSource(rs.getString("WALLET_SOURCE"));
				return wallet;
			}
			
		});
		return wallets;
	}
}
