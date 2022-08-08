package com.hms.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WalletRepository extends JpaRepository<Wallet, Integer>{
	
	@Query("from Wallet where customerId=:cusId")
	public List<Wallet> searchWalletsByCustomerId(@Param("cusId") int cusId);
	
	@Query("from Wallet where customerId=:cusId and walletSource=:source")
	public Wallet showWalletAmount(@Param("cusId") int cusId, @Param("source") String source);
	
	@Query("from Wallet where customerId=:cusId and walletSource=:source")
	public Wallet searchWalletByCustomerIdAndWalletSource(@Param("cusId") int cusId, @Param("source") String source);
	
	@Query("select distinct walletSource from Wallet where emailId=:emailId")
	public List<String> allWalletTypes(@Param("emailId") String emailId);
}