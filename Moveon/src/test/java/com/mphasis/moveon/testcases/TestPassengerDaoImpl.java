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
import com.mphasis.moveon.daos.PassengerDao;
import com.mphasis.moveon.entities.Passenger;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
@WebAppConfiguration
@Transactional
public class TestPassengerDaoImpl {


	@Autowired
	PassengerDao passengerDao;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Passenger passenger=new Passenger();
		passenger.setPassenger_Name("Dinesh");
		passengerDao.insertPassenger(passenger);
		//assertNotNull(driverDao.getbyid(1));
		
		List<Passenger> passengers=passengerDao.getAllPassenger();
		assertEquals(passengers.size(),5);	
	}

}
