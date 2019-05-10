package com.mphasis.moveon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.moveon.daos.VehicleDao;
import com.mphasis.moveon.entities.Vehicle;
import com.mphasis.moveon.service.VehicleService;
@Service
public class VehicleServiceImpl implements VehicleService {
		
	@Autowired
	public VehicleDao vehicleDao;
	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	public void addVehicle(Vehicle vehicle) {
		System.out.println("vehicle values in service"+vehicle.getVehicle_Name());
		vehicleDao.insertVehicle(vehicle);

	}

	public void editVehicle(Vehicle vehicle) {
		vehicleDao.updateVehicle(vehicle);

	}

	public void removeVehicle(String vehicle_Id) {
		vehicleDao.deleteVehicle(vehicle_Id);

	}

	public List<Vehicle> getAll() {
		return  vehicleDao.getAll();
	}

	public List<Vehicle> getAllByType(String vehicle_Type) {
		return vehicleDao.getAllByType(vehicle_Type);
	}

}
