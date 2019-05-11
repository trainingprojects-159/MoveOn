package com.mphasis.moveon.service;

import java.util.List;

import com.mphasis.moveon.entities.Passenger;
import com.mphasis.moveon.exceptions.BusinessException;

public interface PassengerService {

	public void addPassenger(Passenger passenger);
	public void editPassenger(Passenger passenger);
	public void removePassenger(String id_Proof) throws BusinessException;
	public List<Passenger> getAllPassenger();
}
