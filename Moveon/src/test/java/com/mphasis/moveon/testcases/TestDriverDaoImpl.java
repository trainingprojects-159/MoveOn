package com.mphasis.moveon.testcases;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mphasis.moveon.configurations.AppConfig;
import com.mphasis.moveon.daos.DriverDao;
import com.mphasis.moveon.entities.Driver;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
@WebAppConfiguration
@Transactional
public class TestDriverDaoImpl {


	@Autowired
	DriverDao driverDao;
	

	@Test
	public void test() {
		
			Driver driver=new Driver();
		/*	driver.setDriver_Id("DR004");
		driver.setDriver_Name("Rohan");
		driverDao.insertDriver(driver);
		
		assertEquals(driver.getDriver_Name(),"Rohan");*/
		
		List<Driver> drivers=driverDao.getAllDriver();
		assertEquals(drivers.size(),1);
		
	}

}
