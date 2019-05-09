package com.mphasis.moveon.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mphasis.moveon.daos.AdminDao;
import com.mphasis.moveon.service.AdminService;

public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	public boolean login(String email, String password) {
		return login(email, password);
	}

}