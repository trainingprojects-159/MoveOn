package com.mphasis.moveon.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.moveon.daos.AdminDao;
import com.mphasis.moveon.entities.Admin;
import com.mphasis.moveon.exceptions.BusinessException;
import com.mphasis.moveon.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	public Admin login(String email, String password) throws BusinessException
	{
		Admin admin = null;
		if(email != null && email.matches("[a-zA-Z0-9]{4,15}@gmail.com"))
		{
			if(password != null && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$"))
			{
				admin=adminDao.login(email, password);
			}
			else 
			{
				throw new BusinessException("Entered password " + password + " is invalid");
			}
		}
		else 
		{
			throw new BusinessException("Entered email " + email + " is invalid");
		}
		return admin;
	}

}
