package com.mphasis.moveon.daos;

import java.util.List;

import com.mphasis.moveon.entities.Driver;

public interface DriverDao 
{
	public void insertDriver(Driver driver);
	public void updateDriver(Driver driver);
	public void deleteDriver(int driver_Id);
	public List<Driver> getAll();

}
