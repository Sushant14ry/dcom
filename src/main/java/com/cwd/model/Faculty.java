package com.cwd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Faculty_Table")
//@Data
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int faculty_id;
	private String faculty_name;
	private String Course_fee;
	public int getFaculty_id() {
		return faculty_id;
	}
	public void setFaculty_id(int faculty_id) {
		this.faculty_id = faculty_id;
	}
	public String getFaculty_name() {
		return faculty_name;
	}
	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}
	public String getCourse_fee() {
		return Course_fee;
	}
	public void setCourse_fee(String course_fee) {
		Course_fee = course_fee;
	}
	
	
}
