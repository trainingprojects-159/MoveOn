package com.mphasis.moveon.service;

import java.util.List;

import com.mphasis.moveon.entities.Driver;

public interface DriverService {
	public void addDriver(Driver driver);
	public void editDriver(Driver driver);
	public void removeDriver(int driver_Id);
	public List<Driver> getAll();

}
