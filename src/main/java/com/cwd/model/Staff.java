package com.cwd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name="staff_table")
//@Data
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stf_id;
	
	@Column(length = 50)
	private String staff_first_name;
	
	@Column(length = 50)
	private String staff_last_name;
	
	@Column(length = 50)
	private String staff_faculty;
	
	@Column(name ="Staff_gender")
	private String staff_gender;
	
	@Column(length = 255 )
	private String staff_photos;
	
	@Column(unique = true)
	private String staff_email;
	
	@Column(unique = true)
	private String staff_sub_teacher;
	
	@Column(length = 15)
	private String staff_phone;
	
	@Column(length = 50)
	private String staff_address;

	@Column(length = 50)
	private String staff_experience;
	
	@Column(length = 50)
	private String staff_qualification;
	
	@Column(length = 50)
	private String staff_salary;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date staff_dob;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date staff_join_date;

	public int getStf_id() {
		return stf_id;
	}

	public void setStf_id(int stf_id) {
		this.stf_id = stf_id;
	}

	public String getStaff_first_name() {
		return staff_first_name;
	}

	public void setStaff_first_name(String staff_first_name) {
		this.staff_first_name = staff_first_name;
	}

	public String getStaff_last_name() {
		return staff_last_name;
	}

	public void setStaff_last_name(String staff_last_name) {
		this.staff_last_name = staff_last_name;
	}

	public String getStaff_faculty() {
		return staff_faculty;
	}

	public void setStaff_faculty(String staff_faculty) {
		this.staff_faculty = staff_faculty;
	}

	public String getStaff_gender() {
		return staff_gender;
	}

	public void setStaff_gender(String staff_gender) {
		this.staff_gender = staff_gender;
	}

	public String getStaff_photos() {
		return staff_photos;
	}

	public void setStaff_photos(String staff_photos) {
		this.staff_photos = staff_photos;
	}

	public String getStaff_email() {
		return staff_email;
	}

	public void setStaff_email(String staff_email) {
		this.staff_email = staff_email;
	}

	public String getStaff_sub_teacher() {
		return staff_sub_teacher;
	}

	public void setStaff_sub_teacher(String staff_sub_teacher) {
		this.staff_sub_teacher = staff_sub_teacher;
	}

	public String getStaff_phone() {
		return staff_phone;
	}

	public void setStaff_phone(String staff_phone) {
		this.staff_phone = staff_phone;
	}

	public String getStaff_address() {
		return staff_address;
	}

	public void setStaff_address(String staff_address) {
		this.staff_address = staff_address;
	}

	public String getStaff_experience() {
		return staff_experience;
	}

	public void setStaff_experience(String staff_experience) {
		this.staff_experience = staff_experience;
	}

	public String getStaff_qualification() {
		return staff_qualification;
	}

	public void setStaff_qualification(String staff_qualification) {
		this.staff_qualification = staff_qualification;
	}

	public String getStaff_salary() {
		return staff_salary;
	}

	public void setStaff_salary(String staff_salary) {
		this.staff_salary = staff_salary;
	}

	public Date getStaff_dob() {
		return staff_dob;
	}

	public void setStaff_dob(Date staff_dob) {
		this.staff_dob = staff_dob;
	}

	public Date getStaff_join_date() {
		return staff_join_date;
	}

	public void setStaff_join_date(Date staff_join_date) {
		this.staff_join_date = staff_join_date;
	}
	
	

}
