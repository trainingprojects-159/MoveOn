package com.mphasis.moveon.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.moveon.util.StringPrefixedSequenceIdGenerator;


@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="customer_seq")
	 @GenericGenerator(
		        name = "customer_seq", 
		        strategy = "com.mphasis.moveon.util.StringPrefixedSequenceIdGenerator", 
		        parameters = {
		            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
		            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CU"),
		            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	private String customer_Id;
	
	private String customer_Name;
	private String email;
	private String password;
	private String gender;
	private String dob;
	private long contact_Num;
	private String address;
	
	@OneToMany
	List<Passenger> passenger;
	
	@OneToMany
	private Booking_Details booking_Details;
	
	
	
	public void setBooking_Details(Booking_Details booking_Details) {
		this.booking_Details = booking_Details;
	}
	public List<Passenger> getPassenger() {
		return passenger;
	}
	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}
	
	public String getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(String customer_Id) {
		this.customer_Id = customer_Id;
	}
	public String getCustomer_Name() {
		return customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getContact_Num() {
		return contact_Num;
	}
	public void setContact_Num(long contact_Num) {
		this.contact_Num = contact_Num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
