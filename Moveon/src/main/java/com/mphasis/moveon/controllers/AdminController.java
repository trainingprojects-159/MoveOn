package com.mphasis.moveon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.moveon.entities.Admin;
import com.mphasis.moveon.entities.Driver;
import com.mphasis.moveon.entities.Location;
import com.mphasis.moveon.entities.Passenger;
import com.mphasis.moveon.entities.Route;
import com.mphasis.moveon.entities.Schedule;
import com.mphasis.moveon.entities.Vehicle;
import com.mphasis.moveon.exceptions.BusinessException;
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
	
	@RequestMapping(value="/login/{email}/{password}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Admin login(@PathVariable("email") String email, @PathVariable("password") String password) throws BusinessException 
	{
		return this.adminService.login(email,password);
	}
	
	@Autowired
	VehicleService vehicleService;
	

	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}
	
	@RequestMapping(value="/vehicle/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addVehicle(@RequestBody Vehicle vehicle)
	{
		this.vehicleService.addVehicle(vehicle);
	}
	
	@RequestMapping(value="/vehicle/edit",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void editVehicle(@RequestBody Vehicle vehicle)
	{
		this.vehicleService.editVehicle(vehicle);
	}
	
	@RequestMapping(value="/vehicle/{vehicle_Id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void removeVehicle(@PathVariable("vehicle_Id")String  vehicle_Id) throws BusinessException 

	{
		this.vehicleService.removeVehicle(vehicle_Id);
	}
	
	@RequestMapping(value="/vehicles",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vehicle> listVehicle()
	{
		return vehicleService.getAllVehicles();
	}
	
	@RequestMapping(value="/vehicle/{vehicle_Type}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vehicle> listVehicleType(@PathVariable(name="vehicle_Type")String vehicle_Type)
	{
		return vehicleService.getAllByType(vehicle_Type);
	}
	
	@Autowired
	DriverService driverService;
	
	public void setDriverService(DriverService driverService) {
		this.driverService = driverService;
	}
	
	@RequestMapping(value="/driver/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addDriver(@RequestBody Driver driver)
	{
		this.driverService.addDriver(driver);
	}
	
	@RequestMapping(value="/driver/edit",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void editDriver(@RequestBody Driver driver)
	{
		this.driverService.editDriver(driver);
	}
	
	@RequestMapping(value="/driver/{driver_Id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void removeDriver(@PathVariable("driver_Id")String  driver_Id) throws BusinessException 

	{
		this.driverService.removeDriver(driver_Id);
	}
	
	@RequestMapping(value="/drivers",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Driver> listDriver()
	{
		return driverService.getAllDriver();
	}
	
	@Autowired
	RouteService routeService;

	public void setRouteService(RouteService routeService) {
		this.routeService = routeService;
	}
	
	@RequestMapping(value="/route/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addRoute(@RequestBody Route route)
	{
		this.routeService.addRoute(route);
	}
	
	@RequestMapping(value="/route/edit",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void editRoute(@RequestBody Route route)
	{
		this.routeService.editRoute(route);
	}
	
	@RequestMapping(value="/route/{route_Id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void removeRoute(@PathVariable("route_Id")String  route_Id) throws BusinessException 

	{
		this.routeService.removeRoute(route_Id);
	}

	@RequestMapping(value="/routes",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Route> listRoute()
	{
		return routeService.getAllRoute();
	}
	
	@RequestMapping(value="/routes/search/{source}/{destination}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vehicle> listRoutes(@PathVariable("source")String source,@PathVariable("destination")String destination)
	{
		return routeService.getAllBySourceAndDestination(source, destination);
	}
	
	@Autowired
	LocationService locationService;
	
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	@RequestMapping(value="/location/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addLocation(@RequestBody Location location)
	{
		this.locationService.addLocation(location);
	}
	
	@RequestMapping(value="/location/edit",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void editLocation(@RequestBody Location location)
	{
		this.locationService.editLocation(location);
	}
	
	@RequestMapping(value="/location/{location_Id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void removeLocation(@PathVariable("location_Id")String  location_Id) throws BusinessException 

	{
		this.locationService.removeLocation(location_Id);
	}
	

	@RequestMapping(value="/locations",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Location> listLocation()
	{
		return locationService.getLocations();
	}
	
	@Autowired
	ScheduleService scheduleService;
	
	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
	
	@RequestMapping(value="/schedule/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addSchedule(@RequestBody Schedule schedule)
	{
		this.scheduleService.addSchedule(schedule);
	}
	
	@RequestMapping(value="/schedule/{schedule_Id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void removeSchedule(@PathVariable("schedule_Id")String  schedule_Id) throws BusinessException 

	{
		this.scheduleService.removeSchedule(schedule_Id);
	}
	
	@RequestMapping(value="/schedules",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Schedule> listSchedule()
	{
		return scheduleService.getAllSchedule();
	}

	
	
}
