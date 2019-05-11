package com.mphasis.moveon.service;

import com.mphasis.moveon.entities.Admin;
import com.mphasis.moveon.exceptions.BusinessException;

public interface AdminService {

	public Admin login(String email,String password) throws BusinessException;
}
