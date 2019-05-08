package com.mphasis.moveon.daos;

import java.util.List;

import com.mphasis.moveon.entities.Vehicle;

public interface VehicleDao 
{
    public void insertVehicle(Vehicle vehicle);
    public void updateVehicle(Vehicle vehicle);
    public void deleteVehicle(int vehicle_id);
    public List<Vehicle> getAll();
    public List<Vehicle> getAllByType(String vehicle_Type);
}
