package com.mphasis.moveon.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Vehicle 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int vehicle_Id;
	private String vehicle_Name;
	private String vehicle_Type;
	private int seat_Capacity;
	private String vehicle_Num;
	private double fare;
	
	@ManyToOne
	@JoinColumn(name="admin_Id")
	private Admin admin;
	

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public int getVehicle_Id() {
		return vehicle_Id;
	}
	public void setVehicle_Id(int vehicle_Id) {
		this.vehicle_Id = vehicle_Id;
	}
	public String getVehicle_Name() {
		return vehicle_Name;
	}
	public void setVehicle_Name(String vehicle_Name) {
		this.vehicle_Name = vehicle_Name;
	}
	public String getVehicle_Type() {
		return vehicle_Type;
	}
	public void setVehicle_Type(String vehicle_Type) {
		this.vehicle_Type = vehicle_Type;
	}
	public int getSeat_Capacity() {
		return seat_Capacity;
	}
	public void setSeat_Capacity(int seat_Capacity) {
		this.seat_Capacity = seat_Capacity;
	}
	public String getVehicle_Num() {
		return vehicle_Num;
	}
	public void setVehicle_Num(String vehicle_Num) {
		this.vehicle_Num = vehicle_Num;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}

}
