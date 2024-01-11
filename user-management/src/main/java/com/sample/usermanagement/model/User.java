package com.sample.usermanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdetail")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String userName;
	private String fullName;
	private String email;
	private String mobile;
	private String dob;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String fullName, String email, String mobile, String dob) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.mobile = mobile;
		this.dob = dob;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", fullName=" + fullName + ", Email=" + email + ", Mobile="
				+ mobile + ", dob=" + dob + "]";
	}
	
	

}