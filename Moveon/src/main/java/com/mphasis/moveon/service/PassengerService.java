package com.mphasis.moveon.service;

import java.util.List;

import com.mphasis.moveon.entities.Passenger;

public interface PassengerService {

	public void addPassenger(Passenger passenger);
	public void editPassenger(Passenger passenger);
	public void removePassenger(String id_Proof);
	public List<Passenger> getAllPassenger();
}
