package com.mphasis.moveon.daos;

import java.util.List;

import com.mphasis.moveon.entities.Driver;
import com.mphasis.moveon.exceptions.BusinessException;

public interface DriverDao 
{
	public void insertDriver(Driver driver);
	public void updateDriver(Driver driver);
	public Driver deleteDriver(String driver_Id) throws BusinessException;
	public List<Driver> getAll();

}
