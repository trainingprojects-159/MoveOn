package com.mphasis.moveon.daos;

import com.mphasis.moveon.entities.Admin;
import com.mphasis.moveon.exceptions.BusinessException;

public interface AdminDao 
{
	public Admin login(String email,String password) throws BusinessException;
	
}
