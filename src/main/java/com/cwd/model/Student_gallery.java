package com.cwd.model;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "Student_Gallery")
//@Data
public class Student_gallery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stud_gall_id;
	private String stud_gall_name;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date stud_gall_img_date;

	public int getStud_gall_id() {
		return stud_gall_id;
	}

	public void setStud_gall_id(int stud_gall_id) {
		this.stud_gall_id = stud_gall_id;
	}

	public String getStud_gall_name() {
		return stud_gall_name;
	}

	public void setStud_gall_name(String stud_gall_name) {
		this.stud_gall_name = stud_gall_name;
	}

	public Date getStud_gall_img_date() {
		return stud_gall_img_date;
	}

	public void setStud_gall_img_date(Date stud_gall_img_date) {
		this.stud_gall_img_date = stud_gall_img_date;
	}

	
}
