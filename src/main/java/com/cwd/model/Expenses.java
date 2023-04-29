package com.cwd.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "Expenses_table")
//@Data
public class Expenses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int exp_id;
	private String exp_name;
	private String exp_remark;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date exp_date;
	private int exp_amount;
	public int getExp_id() {
		return exp_id;
	}
	public void setExp_id(int exp_id) {
		this.exp_id = exp_id;
	}
	public String getExp_name() {
		return exp_name;
	}
	public void setExp_name(String exp_name) {
		this.exp_name = exp_name;
	}
	public String getExp_remark() {
		return exp_remark;
	}
	public void setExp_remark(String exp_remark) {
		this.exp_remark = exp_remark;
	}
	public Date getExp_date() {
		return exp_date;
	}
	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}
	public int getExp_amount() {
		return exp_amount;
	}
	public void setExp_amount(int exp_amount) {
		this.exp_amount = exp_amount;
	}
	
	
}
