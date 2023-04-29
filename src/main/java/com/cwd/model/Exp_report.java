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
public class Exp_report {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int e_id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date e_from;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date e_to;

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public Date getE_from() {
		return e_from;
	}

	public void setE_from(Date e_from) {
		this.e_from = e_from;
	}

	public Date getE_to() {
		return e_to;
	}

	public void setE_to(Date e_to) {
		this.e_to = e_to;
	}
	
	
	
}
