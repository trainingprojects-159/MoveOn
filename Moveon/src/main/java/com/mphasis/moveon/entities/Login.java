package com.mphasis.moveon.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Login 
{
	
	@Id
	private String login_Id;
	private String password;
	private String login_Type;
	public String getLogin_Type() {
		return login_Type;
	}
	public void setLogin_Type(String login_Type) {
		this.login_Type = login_Type;
	}
	public String getLogin_Id() {
		return login_Id;
	}
	public void setLogin_Id(String login_Id) {
		this.login_Id = login_Id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
