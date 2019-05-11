package com.mphasis.moveon.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.moveon.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Schedule 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="schedule_seq")
	 @GenericGenerator(
		        name = "schedule_seq", 
		        strategy = "com.mphasis.moveon.util.StringPrefixedSequenceIdGenerator", 
		        parameters = {
		            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
		            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "SC"),
		            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	private String schedule_Id;
	
	@ManyToOne
	private Admin admin;
	
	@OneToOne
	private Vehicle vehicle;
	
	@OneToOne
	private Route route;
	
	private String schedule_Date;

	public String getSchedule_Id() {
		return schedule_Id;
	}

	public void setSchedule_Id(String schedule_Id) {
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
