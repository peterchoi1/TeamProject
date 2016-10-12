package ssa.entity;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_class_relationship")
public class SCR {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="student_id")
	private int student_id;
	
	@Column(name="class_id")
	private int class_id;
	
	@Column(name="grade")
	private String grade;
	
	@Column(name="status")
	private String status;
	
	public SCR() {
		
	}
	public SCR(int student_id, int class_id, String grade) {
		super();
		this.student_id = student_id;
		this.class_id = class_id;
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return (String.format("%5d %5d %5d %-10s", this.id, this.student_id, this.class_id, this.grade));
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
