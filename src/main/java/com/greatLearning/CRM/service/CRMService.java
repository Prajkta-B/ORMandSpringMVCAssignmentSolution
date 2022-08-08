package com.greatLearning.CRM.service;

import java.util.List;

import com.greatLearning.CRM.entity.CustomerDetails;

public interface CRMService {

	public List<CustomerDetails> findAll();
	public CustomerDetails findById(int theId);
	public void save(CustomerDetails customerDetails);
	public void deleteById(int theId);
	
}
