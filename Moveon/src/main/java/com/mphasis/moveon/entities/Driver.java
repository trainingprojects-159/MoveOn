package com.mphasis.moveon.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.moveon.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Driver 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="driver_seq")
	 @GenericGenerator(
		        name = "driver_seq", 
		        strategy = "com.mphasis.moveon.util.StringPrefixedSequenceIdGenerator", 
		        parameters = {
		            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
		            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "DR"),
		            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	private String driver_Id;
	private String driver_Name;
	private String license_Num;
	private long contact_Num;
	@ManyToOne
	private Admin admin;
	@OneToOne
	private Vehicle vehicle;
	
	@OneToOne
	private Schedule schedule;

	public String getDriver_Id() {
		return driver_Id;
	}

	public void setDriver_Id(String driver_Id) {
		this.driver_Id = driver_Id;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getDriver_Name() {
		return driver_Name;
	}

	public void setDriver_Name(String driver_Name) {
		this.driver_Name = driver_Name;
	}

	public String getLicense_Num() {
		return license_Num;
	}

	public void setLicense_Num(String license_Num) {
		this.license_Num = license_Num;
	}

	public long getContact_Num() {
		return contact_Num;
	}

	public void setContact_Num(long contact_Num) {
		this.contact_Num = contact_Num;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	


	
	

}
