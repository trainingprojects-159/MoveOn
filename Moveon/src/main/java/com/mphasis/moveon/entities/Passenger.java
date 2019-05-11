package com.mphasis.moveon.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

@Entity
public class Passenger 
{
	
	@Id
	private String id_Proof;
	private String id_proof_type;
	private String passenger_Name;
	private String gender;
	private int age;
	private String source;
	private String destination;
	private String journey_Date;
	
	@ManyToOne
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getPassenger_Name() {
		return passenger_Name;
	}
	public void setPassenger_Name(String passenger_Name) {
		this.passenger_Name = passenger_Name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId_Proof() {
		return id_Proof;
	}
	public void setId_Proof(String id_Proof) {
		this.id_Proof = id_Proof;
	}
	public String getId_proof_type() {
		return id_proof_type;
	}
	public void setId_proof_type(String id_proof_type) {
		this.id_proof_type = id_proof_type;
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
	public String getJourney_Date() {
		return journey_Date;
	}
	public void setJourney_Date(String journey_Date) {
		this.journey_Date = journey_Date;
	}
	

}
