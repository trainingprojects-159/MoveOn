package com.mphasis.moveon.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Schedule 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int schedule_Id;
	
	@ManyToOne
	@JoinColumn(name="admin_Id")
	private Admin admin;
	
	@OneToOne
	@JoinColumn(name="vehicle_Id")
	private Vehicle vehicle;
	
	@OneToOne
	@JoinColumn(name="route_Id")
	private Route route;
	
	private String schedule_Date;

	public int getSchedule_Id() {
		return schedule_Id;
	}

	public void setSchedule_Id(int schedule_Id) {
		this.schedule_Id = schedule_Id;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public String getSchedule_Date() {
		return schedule_Date;
	}

	public void setSchedule_Date(String schedule_Date) {
		this.schedule_Date = schedule_Date;
	}



}
