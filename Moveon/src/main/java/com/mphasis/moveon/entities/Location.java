package com.mphasis.moveon.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Location {
	@Id
	
	private String location_Id;
	private String location_Name;
	private String stop;
	
	@ManyToOne
	@JoinColumn(name="admin_Id")
	private Admin admin;

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String getLocation_Id() {
		return location_Id;
	}
	public void setLocation_Id(String location_Id) {
		this.location_Id = location_Id;
	}
	public String getLocation_Name() {
		return location_Name;
	}
	public void setLocation_Name(String location_Name) {
		this.location_Name = location_Name;
	}
	public String getStop() {
		return stop;
	}
	public void setStop(String stop) {
		this.stop = stop;
	}

}
