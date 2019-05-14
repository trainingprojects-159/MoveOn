package com.mphasis.moveon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.moveon.daos.DriverDao;
import com.mphasis.moveon.entities.Driver;
import com.mphasis.moveon.exceptions.BusinessException;
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

	public Driver removeDriver(String driver_Id) throws BusinessException 
	{
		Driver driver = null;
		if(driver.getDriver_Id().equals(driver_Id))
		{
			driver = driverDao.deleteDriver(driver_Id);

		}
		else
		{
			throw new BusinessException("Enter Driver ID is not present" + driver_Id);
		}
		return driver;
		
		
	}

	public List<Driver> getAllDriver() {
		
		return driverDao.getAllDriver();
	}

}
