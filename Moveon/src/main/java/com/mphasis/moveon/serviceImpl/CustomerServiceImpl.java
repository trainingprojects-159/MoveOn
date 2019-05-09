package com.mphasis.moveon.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.moveon.daos.CustomerDao;
import com.mphasis.moveon.entities.Customer;
import com.mphasis.moveon.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public boolean loginService(String email, String password) {
		
		return customerDao.login(email, password);
	}

	public Customer registerService(Customer customer) {
		
		return customerDao.register(customer);
	}
	
	

}
