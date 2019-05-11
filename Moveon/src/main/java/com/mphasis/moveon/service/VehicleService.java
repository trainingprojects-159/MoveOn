package com.mphasis.moveon.service;

import java.util.List;

import com.mphasis.moveon.entities.Vehicle;
import com.mphasis.moveon.exceptions.BusinessException;

public interface VehicleService {
	 public void addVehicle(Vehicle vehicle);
	    public void editVehicle(Vehicle vehicle);
	    public Vehicle removeVehicle(String vehicle_Id) throws BusinessException;
	    public List<Vehicle> getAll();
	    public List<Vehicle> getAllByType(String vehicle_Type);
}
