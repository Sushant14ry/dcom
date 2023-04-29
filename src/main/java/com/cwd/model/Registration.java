package com.cwd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Register_table")
//@Data
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reg_id;
	private String reg_fullname;
	
	@Column(unique = true)
	private String reg_email;
	
	private String reg_password;

	public int getReg_id() {
		return reg_id;
	}

	public void setReg_id(int reg_id) {
		this.reg_id = reg_id;
	}

	public String getReg_fullname() {
		return reg_fullname;
	}

	public void setReg_fullname(String reg_fullname) {
		this.reg_fullname = reg_fullname;
	}

	public String getReg_email() {
		return reg_email;
	}

	public void setReg_email(String reg_email) {
		this.reg_email = reg_email;
	}

	public String getReg_password() {
		return reg_password;
	}

	public void setReg_password(String reg_password) {
		this.reg_password = reg_password;
	}
	
	
}
