package com.cwd.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name="student_table")
//@Data
public class Students {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stud_id;
	
	@Column(length = 50)
	private String stud_first_name;
	
	@Column(length = 50)
	private String stud_last_name;
	
	@Column(length = 50)
	private String stud_faculty;
	
	@Column(name ="Student_gender")
	private String stud_gender;
	
	@Column(length = 255 )
	private String stud_photo;
	
	@Column(unique = true)
	private String stud_email;
	
	@Column(length = 15)
	private String stud_phone;
	
	@Column(length = 50)
	private String stud_address;
	
	@Column(length = 50)
	private String stud_country;
	
	@Column(length = 50)
	private String stud_semester;
	
	@Column(length = 50)
	private String stud_qualification;
	
	@Column(length = 50)
	private String stud_batch_year;
	
	@Column(length = 50)
	private String stud_course_fee;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date stud_dob;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date stud_enroll_date;
	
	@Column(length = 50)
	private String stud_guardians_name;
	
	@Column(length = 50)
	private String stud_guardians_phone;
	
	@CreatedDate
	private LocalDateTime stud_created_date;
	
	@LastModifiedDate
	private LocalDateTime stud_update_date;

	public int getStud_id() {
		return stud_id;
	}

	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}

	public String getStud_first_name() {
		return stud_first_name;
	}

	public void setStud_first_name(String stud_first_name) {
		this.stud_first_name = stud_first_name;
	}

	public String getStud_last_name() {
		return stud_last_name;
	}

	public void setStud_last_name(String stud_last_name) {
		this.stud_last_name = stud_last_name;
	}

	public String getStud_faculty() {
		return stud_faculty;
	}

	public void setStud_faculty(String stud_faculty) {
		this.stud_faculty = stud_faculty;
	}

	public String getStud_gender() {
		return stud_gender;
	}

	public void setStud_gender(String stud_gender) {
		this.stud_gender = stud_gender;
	}

	public String getStud_photo() {
		return stud_photo;
	}

	public void setStud_photo(String stud_photo) {
		this.stud_photo = stud_photo;
	}

	public String getStud_email() {
		return stud_email;
	}

	public void setStud_email(String stud_email) {
		this.stud_email = stud_email;
	}

	public String getStud_phone() {
		return stud_phone;
	}

	public void setStud_phone(String stud_phone) {
		this.stud_phone = stud_phone;
	}

	public String getStud_address() {
		return stud_address;
	}

	public void setStud_address(String stud_address) {
		this.stud_address = stud_address;
	}

	public String getStud_country() {
		return stud_country;
	}

	public void setStud_country(String stud_country) {
		this.stud_country = stud_country;
	}

	public String getStud_semester() {
		return stud_semester;
	}

	public void setStud_semester(String stud_semester) {
		this.stud_semester = stud_semester;
	}

	public String getStud_qualification() {
		return stud_qualification;
	}

	public void setStud_qualification(String stud_qualification) {
		this.stud_qualification = stud_qualification;
	}

	public String getStud_batch_year() {
		return stud_batch_year;
	}

	public void setStud_batch_year(String stud_batch_year) {
		this.stud_batch_year = stud_batch_year;
	}

	public String getStud_course_fee() {
		return stud_course_fee;
	}

	public void setStud_course_fee(String stud_course_fee) {
		this.stud_course_fee = stud_course_fee;
	}

	public Date getStud_dob() {
		return stud_dob;
	}

	public void setStud_dob(Date stud_dob) {
		this.stud_dob = stud_dob;
	}

	public Date getStud_enroll_date() {
		return stud_enroll_date;
	}

	public void setStud_enroll_date(Date stud_enroll_date) {
		this.stud_enroll_date = stud_enroll_date;
	}

	public String getStud_guardians_name() {
		return stud_guardians_name;
	}

	public void setStud_guardians_name(String stud_guardians_name) {
		this.stud_guardians_name = stud_guardians_name;
	}

	public String getStud_guardians_phone() {
		return stud_guardians_phone;
	}

	public void setStud_guardians_phone(String stud_guardians_phone) {
		this.stud_guardians_phone = stud_guardians_phone;
	}

	public LocalDateTime getStud_created_date() {
		return stud_created_date;
	}

	public void setStud_created_date(LocalDateTime stud_created_date) {
		this.stud_created_date = stud_created_date;
	}

	public LocalDateTime getStud_update_date() {
		return stud_update_date;
	}

	public void setStud_update_date(LocalDateTime stud_update_date) {
		this.stud_update_date = stud_update_date;
	}

	
	
	
}
