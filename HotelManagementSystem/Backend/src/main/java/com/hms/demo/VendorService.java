package com.hms.demo;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class VendorService {
	
	@Autowired
	private VendorRepository vendorrepo;
	
	public List<Vendor> getall(){
		List<Vendor> vendor = new ArrayList<Vendor>();
		vendorrepo.findAll().forEach(vendor1->vendor.add(vendor1));
		return vendor;
	}

}
