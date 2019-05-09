package com.mphasis.moveon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.moveon.daos.DriverDao;
import com.mphasis.moveon.entities.Driver;
import com.mphasis.moveon.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverDao driverDao;
	
	public void setDriverDao(DriverDao driverDao) {
		this.driverDao = driverDao;
	}

	public void addDriver(Driver driver) {
		driverDao.insertDriver(driver);
		
	}

	public void editDriver(Driver driver) {
		driverDao.updateDriver(driver);
		
	}

	public void removeDriver(int driver_Id) {
		driverDao.deleteDriver(driver_Id);
		
	}

	public List<Driver> getAll() {
		
		return driverDao.getAll();
	}

}
