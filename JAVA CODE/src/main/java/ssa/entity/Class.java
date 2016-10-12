package ssa.entity;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "class")
public class Class {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="section")
	private int section;
	
	@Column(name="instructor_id")
	private Integer instructor_id;

	@Column(name="semester")
	private String semester;
	
	@Column(name="year")
	private Integer year;
	
	public Class() {
		
	}
	
	public Class(String subject, int section, Integer instructor_id) {
		super();
		this.subject = subject;
		this.section = section;
		this.instructor_id = instructor_id;
	}
	
	@Override
	public String toString() {
		return (String.format("%4d %-20s %4d %4d %-20s %4d", this.id, this.subject, this.section, this.instructor_id, this.semester, this.year));
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public Integer getInstructor_id() {
		return instructor_id;
	}
	public void setInstructor_id(Integer instructor_id) {
		this.instructor_id = instructor_id;
	}
	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
}