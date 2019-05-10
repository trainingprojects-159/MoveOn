package com.mphasis.moveon.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Route 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int route_Id;
	
	@OneToOne
	@JoinColumn(name="location_Id")
	private Location location;
	

	public Admin getAdmin() {
		return admin;
	}
	private String source;
	private String destination;
	private int distance;
	private int duration;
	
	
	@ManyToOne
	@JoinColumn(name="admin_Id")
	private Admin admin;
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public int getRoute_Id() {
		return route_Id;
	}
	public void setRoute_Id(int route_Id) {
		this.route_Id = route_Id;
	}
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	
}
