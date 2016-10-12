package ssa.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="years_experience")
	private int years_experience;
	
	@Column(name="is_tenured")
	private int is_tenured;
	
	@Column(name="role_id")
	private int role_id;
	
	public Employee() {	}
	
	public Employee(String first_name, String last_name, int years_experience, int is_tenured, int role_id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.years_experience = years_experience;
		this.is_tenured = is_tenured;
		this.role_id = role_id;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public int getYears_experience() {
		return years_experience;
	}


	public void setYears_experience(int years_experience) {
		this.years_experience = years_experience;
	}


	public int getIs_tenured() {
		return is_tenured;
	}


	public void setIs_tenured(int is_tenured) {
		this.is_tenured = is_tenured;
	}


	public int getRole_id() {
		return role_id;
	}


	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}


	@Override
	public String toString() {
		return (String.format("%4d %-20s %-20s %4d %4d %4d", this.id, this.first_name, this.last_name, this.years_experience, this.is_tenured, this.role_id));
	}

}
