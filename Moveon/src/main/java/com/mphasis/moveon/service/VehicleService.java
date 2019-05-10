package com.mphasis.moveon.service;

import java.util.List;

import com.mphasis.moveon.entities.Vehicle;

public interface VehicleService {
	 public void addVehicle(Vehicle vehicle);
	    public void editVehicle(Vehicle vehicle);
	    public void removeVehicle(String vehicle_Id);
	    public List<Vehicle> getAll();
	    public List<Vehicle> getAllByType(String vehicle_Type);
}
