package com.mphasis.moveon.daos;

import java.util.List;

import com.mphasis.moveon.entities.Vehicle;
import com.mphasis.moveon.exceptions.BusinessException;

public interface VehicleDao 
{
    public void insertVehicle(Vehicle vehicle);
    public void updateVehicle(Vehicle vehicle);
    public Vehicle deleteVehicle(String vehicle_Id) throws BusinessException;
    public List<Vehicle> getAll();
    public List<Vehicle> getAllByType(String vehicle_Type);
}
