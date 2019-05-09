package com.mphasis.moveon.daos;

import com.mphasis.moveon.entities.Passenger;

public interface PassengerDao {
	
	public void addPassenger(Passenger passenger);
	public Passenger getAllPassenger();
}
