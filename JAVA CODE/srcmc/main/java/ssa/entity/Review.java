package ssa.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="review")

public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="professor_review") 
	private String professor_review;
	@Column(name="class_review")
	private String class_review;
	@Column(name="login_id")
	private int login_id;
	@Column(name="class_id")
	private int class_id;
	@Column(name="review_date")
	private Date review_date;
	@Column(name="year")
	private int year;
	@Column(name="semester")
	private int semester;
	@Column(name="class_rating")
	private int class_rating;
	@Column(name="professor_rating")
	private int professor_rating;
	
	public Review() {};
	
	public Review(int id, String professor_review, String class_review, int login_id, int class_id, Date review_date, int year,
			int semester, int class_rating, int professor_rating) {
		super();
		this.id = id;
		this.professor_review = professor_review;
		this.class_review = class_review;
		this.login_id = login_id;
		this.class_id = class_id;
		this.review_date = review_date;
		this.year = year;
		this.semester = semester;
		this.class_rating = class_rating;
		this.professor_rating = professor_rating;
	}
	
	public Review(String professor_review, String class_review, int login_id, int class_id, Date review_date, int year,
			int semester, int class_rating, int professor_rating) {
		super();
		this.professor_review = professor_review;
		this.class_review = class_review;
		this.login_id = login_id;
		this.class_id = class_id;
		this.review_date = review_date;
		this.year = year;
		this.semester = semester;
		this.class_rating = class_rating;
		this.professor_rating = professor_rating;
	}
	
	

	
	
	
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	public String getProfessor_review() {
		return professor_review;
	}
	public void setProfessor_review(String professor_review) {
		this.professor_review = professor_review;
	}
	public String getClass_review() {
		return class_review;
	}
	public void setClass_review(String class_review) {
		this.class_review = class_review;
	}
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public Date getReview_date() {
		return review_date;
	}
	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getClass_rating() {
		return class_rating;
	}
	public void setClass_rating(int class_rating) {
		this.class_rating = class_rating;
	}
	public int getProfessor_rating() {
		return professor_rating;
	}
	public void setProfessor_rating(int professor_rating) {
		this.professor_rating = professor_rating;
	}
	
	

	
	
}
	
	
