package com.ssa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")

public class Login {
	
	@Column(name="admin")
	private int admin;
	@Column(name="password")
	private String password;
	@Id
	@Column(name="id")
	private String id;

	
	public Login(){}
	
	public Login(String password, String id) {
	}

	public Login(int admin, String password, String id) {
		this.admin = admin;
		this.password = password;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}


	

	

}
