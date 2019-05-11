package com.mphasis.moveon.daos;

import com.mphasis.moveon.entities.Customer;
import com.mphasis.moveon.exceptions.BusinessException;

public interface CustomerDao {

	public Customer login(String email,String password) throws BusinessException;
	public Customer register(Customer customer) throws BusinessException;

}
