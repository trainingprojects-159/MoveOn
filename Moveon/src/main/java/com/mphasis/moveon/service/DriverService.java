package com.mphasis.moveon.service;

import java.util.List;

import com.mphasis.moveon.entities.Driver;
import com.mphasis.moveon.exceptions.BusinessException;

public interface DriverService {
	public void addDriver(Driver driver);
	public void editDriver(Driver driver);
	public Driver removeDriver(String driver_Id) throws BusinessException;
	public List<Driver> getAllDriver();

}
