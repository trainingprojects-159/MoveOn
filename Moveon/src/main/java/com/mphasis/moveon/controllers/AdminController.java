package com.mphasis.moveon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.moveon.entities.Driver;
import com.mphasis.moveon.entities.Location;
import com.mphasis.moveon.entities.Passenger;
import com.mphasis.moveon.entities.Route;
import com.mphasis.moveon.entities.Schedule;
import com.mphasis.moveon.entities.Vehicle;
import com.mphasis.moveon.service.AdminService;
import com.mphasis.moveon.service.DriverService;
import com.mphasis.moveon.service.LocationService;
import com.mphasis.moveon.service.RouteService;
import com.mphasis.moveon.service.ScheduleService;
import com.mphasis.moveon.service.VehicleService;

@RestController
@RequestMapping("/admin")
public class AdminController
{
	@Autowired
	AdminService adminService;
	
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@RequestMapping(value="/admin/login",method=RequestMethod.POST)
	public void login(@RequestBody String email,String password) 
	{
		 this.adminService.login(email,password);
	}
	
	@Autowired
	VehicleService vehicleService;
	

	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}
	
	@RequestMapping(value="/admin/add",method=RequestMethod.POST)
	public void addVehicle(@RequestBody Vehicle vehicle)
	{
		this.vehicleService.addVehicle(vehicle);
	}
	
	@RequestMapping(value="/admin/edit",method=RequestMethod.PUT)
	public void editVehicle(@RequestBody Vehicle vehicle)
	{
		this.vehicleService.editVehicle(vehicle);
	}
	
	@RequestMapping(value="/admin/{vehicle_Id}",method=RequestMethod.DELETE)
	public void removeVehicle(@PathVariable("vehicle_Id")String  vehicle_Id) 

	{
		this.vehicleService.removeVehicle(vehicle_Id);
	}
	
	@RequestMapping(value="/vehicles",method=RequestMethod.GET)
	public List<Vehicle> listVehicle()
	{
		return vehicleService.getAll();
	}
	
	@RequestMapping(value="/vehicles/{vehicletype}",method=RequestMethod.GET)
	public List<Vehicle> listVehicleType(@PathVariable(name="vehicle_Type")String vehicle_Type)
	{
		return vehicleService.getAllByType(vehicle_Type);
	}
	
	@Autowired
	DriverService driverService;
	
	public void setDriverService(DriverService driverService) {
		this.driverService = driverService;
	}
	
	@RequestMapping(value="/admin/add",method=RequestMethod.POST)
	public void addDriver(@RequestBody Driver driver)
	{
		this.driverService.addDriver(driver);
	}
	
	@RequestMapping(value="/admin/edit",method=RequestMethod.PUT)
	public void editDriver(@RequestBody Driver driver)
	{
		this.driverService.editDriver(driver);
	}
	
	@RequestMapping(value="/admin/{driver_Id}",method=RequestMethod.DELETE)
	public void removeDriver(@PathVariable("driver_Id")String  driver_Id) 

	{
		this.driverService.removeDriver(driver_Id);
	}
	
	@RequestMapping(value="/drivers",method=RequestMethod.GET)
	public List<Driver> listDriver()
	{
		return driverService.getAll();
	}
	
	@Autowired
	RouteService routeService;

	public void setRouteService(RouteService routeService) {
		this.routeService = routeService;
	}
	
	@RequestMapping(value="/admin/add",method=RequestMethod.POST)
	public void addRoute(@RequestBody Route route)
	{
		this.routeService.addRoute(route);
	}
	
	@RequestMapping(value="/admin/edit",method=RequestMethod.PUT)
	public void editRoute(@RequestBody Route route)
	{
		this.routeService.editRoute(route);
	}
	
	@RequestMapping(value="/admin/{route_Id}",method=RequestMethod.DELETE)
	public void removeRoute(@PathVariable("route_Id")String  route_Id) 

	{
		this.routeService.removeRoute(route_Id);
	}

	@RequestMapping(value="/routes",method=RequestMethod.GET)
	public List<Route> listRoute()
	{
		return routeService.getAll();
	}
	
	@RequestMapping(value="/route/{source}/{destination}",method=RequestMethod.GET)
	public List<Vehicle> listRoutes(@PathVariable("source")String source,@PathVariable("destination")String destination)
	{
		return routeService.getAllBySourceAndDestination(source, destination);
	}
	
	@Autowired
	LocationService locationService;
	
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	@RequestMapping(value="/admin/add",method=RequestMethod.POST)
	public void addLocation(@RequestBody Location location)
	{
		this.locationService.addLocation(location);
	}
	
	@RequestMapping(value="/admin/edit",method=RequestMethod.PUT)
	public void editLocation(@RequestBody Location location)
	{
		this.locationService.editLocation(location);
	}
	
	@RequestMapping(value="/admin/{location_Id}",method=RequestMethod.DELETE)
	public void removeLocation(@PathVariable("location_Id")String  location_Id) 

	{
		this.locationService.removeLocation(location_Id);
	}
	

	@RequestMapping(value="/locations",method=RequestMethod.GET)
	public List<Location> listLocation()
	{
		return locationService.getLocations();
	}
	
	@Autowired
	ScheduleService scheduleService;
	
	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
	
	@RequestMapping(value="/admin/add",method=RequestMethod.POST)
	public void addSchedule(@RequestBody Schedule schedule)
	{
		this.scheduleService.addSchedule(schedule);
	}
	
	@RequestMapping(value="/admin/{schedule_Id}",method=RequestMethod.DELETE)
	public void removeSchedule(@PathVariable("schedule_Id")String  schedule_Id) 

	{
		this.scheduleService.removeSchedule(schedule_Id);
	}
	
	@RequestMapping(value="/schedules",method=RequestMethod.GET)
	public List<Schedule> listSchedule()
	{
		return scheduleService.getAll();
	}

	
	
}
