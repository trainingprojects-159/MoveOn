package com.mphasis.moveon.service;

import com.mphasis.moveon.entities.Customer;
import com.mphasis.moveon.exceptions.BusinessException;

public interface CustomerService {

	public Customer loginService(String email,String password)throws BusinessException;
	public Customer registerService(Customer customer) throws BusinessException;
}
