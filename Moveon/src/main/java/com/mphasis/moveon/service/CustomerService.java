package com.mphasis.moveon.service;

import com.mphasis.moveon.entities.Customer;

public interface CustomerService {

	public boolean loginService(String email,String password);
	public Customer registerService(Customer customer);
}
