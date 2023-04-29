package com.cwd.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
//@Data
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int n_id;
	private String n_title;
	private String n_post;
	private String n_photo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date n_date;

	public int getN_id() {
		return n_id;
	}

	public void setN_id(int n_id) {
		this.n_id = n_id;
	}

	public String getN_title() {
		return n_title;
	}

	public void setN_title(String n_title) {
		this.n_title = n_title;
	}

	public String getN_post() {
		return n_post;
	}

	public void setN_post(String n_post) {
		this.n_post = n_post;
	}

	public String getN_photo() {
		return n_photo;
	}

	public void setN_photo(String n_photo) {
		this.n_photo = n_photo;
	}

	public Date getN_date() {
		return n_date;
	}

	public void setN_date(Date n_date) {
		this.n_date = n_date;
	}
	
	
}
