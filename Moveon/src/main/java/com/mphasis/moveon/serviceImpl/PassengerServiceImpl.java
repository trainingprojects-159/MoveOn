package com.mphasis.moveon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.moveon.daos.PassengerDao;
import com.mphasis.moveon.entities.Passenger;
import com.mphasis.moveon.exceptions.BusinessException;
import com.mphasis.moveon.service.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService{

	@Autowired
	PassengerDao passengerDao;
	
	public void setPassengerDao(PassengerDao passengerDao) {
		this.passengerDao = passengerDao;
	}

	public void addPassenger(Passenger passenger) {
	   passengerDao.insertPassenger(passenger);
		
	}

	public void editPassenger(Passenger passenger) {
		passengerDao.updatePassenger(passenger);
		
	}

	public void removePassenger(String id_Proof) throws BusinessException 
	{
		passengerDao.deletePassenger(id_Proof);
		
	}
	public List<Passenger> getAllPassenger() {
		
		return passengerDao.getAllPassenger();
	}

	

}
