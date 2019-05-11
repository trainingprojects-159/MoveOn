package com.mphasis.moveon.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.moveon.daos.CustomerDao;
import com.mphasis.moveon.entities.Customer;
import com.mphasis.moveon.exceptions.BusinessException;
import com.mphasis.moveon.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public Customer loginService(String email, String password) throws BusinessException 
	{
		Customer customer = null;
		if(email != null && email.matches("[a-zA-Z0-9]{4,15}@gmail.com"))
		{
			if(password != null && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$"))
			{
				customer= customerDao.login(email, password);
			}
			else {
				throw new BusinessException("Entered password " + password + " is invalid");
			}
		}
		else {
			throw new BusinessException("Entered email " + email + " is invalid");
		}
		
		return customer;
	}

	public Customer registerService(Customer customer) throws BusinessException 
	{
		Customer customer1 = null;
		if (customer.getCustomer_Name() != null && customer.getCustomer_Name().matches("[a-zA-Z]{1,}"))
		{
			
		}
			 
		
		
		
		return customerDao.register(customer);
	}
	
	

}
