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
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="location_seq")
	 @GenericGenerator(
		        name = "location_seq", 
		        strategy = "com.mphasis.moveon.util.StringPrefixedSequenceIdGenerator", 
		        parameters = {
		            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
		            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "LO"),
		            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	private String location_Id;
	private String location_Name;
	
	@OneToOne
	private Route route;
	


	public Admin getAdmin() {
		return admin;
	}
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
	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

}
