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
public class Route 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="route_seq")
	 @GenericGenerator(
		        name = "route_seq", 
		        strategy = "com.mphasis.moveon.util.StringPrefixedSequenceIdGenerator", 
		        parameters = {
		            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
		            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "RO"),
		            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	private String route_Id;
	
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
	
	public String getRoute_Id() {
		return route_Id;
	}
	public void setRoute_Id(String route_Id) {
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
