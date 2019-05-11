package com.mphasis.moveon.daos;

import java.util.List;


import com.mphasis.moveon.entities.Passenger;
import com.mphasis.moveon.exceptions.BusinessException;

public interface PassengerDao {
	
	public void insertPassenger(Passenger passenger);
	public void updatePassenger(Passenger passenger);
	public void deletePassenger(String id_Proof) throws BusinessException;
	public List<Passenger> getAllPassenger();
	
}
