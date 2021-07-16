package com.smca.Company.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "User1")
public class User1 {
	
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Username")
	private String username;
	

	@Column(name = "Password")
	private String password;
	
	
	@Column(name = "Usertype")
	private String usertype;
	
    
	@Column(name = "Email")
	private String email;
	

	@Column(name = "Mobile_Number")
	private int mobilenumber;
	

	@Column(name = "Confirmed")
	private Boolean confirmed;
	
	@Column(name = "Admin")
	private Boolean admin;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(int mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}
	
	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public User1() {
		super();
	}
	
	public User1(Long id, String username, String password, String usertype, String email, int mobilenumber,
			Boolean confirmed) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.confirmed = confirmed;
	}
	
}
