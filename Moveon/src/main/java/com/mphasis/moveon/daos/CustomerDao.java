package com.mphasis.moveon.daos;

import com.mphasis.moveon.entities.Customer;

public interface CustomerDao {

	public boolean login(String username,String password);
	public Customer register(Customer customer);
	
}
