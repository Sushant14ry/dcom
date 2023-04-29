package com.cwd.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Staff_Salary")
//@Data
public class Stf_salary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int stf_sal_amount;
	private String stf_sal_remarks;
	private String stf_sal_date;
	private String stf_sal_mon;
	
	@ManyToOne
	@JoinColumn(name="staff_id")
	private Staff staff;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStf_sal_amount() {
		return stf_sal_amount;
	}

	public void setStf_sal_amount(int stf_sal_amount) {
		this.stf_sal_amount = stf_sal_amount;
	}

	public String getStf_sal_remarks() {
		return stf_sal_remarks;
	}

	public void setStf_sal_remarks(String stf_sal_remarks) {
		this.stf_sal_remarks = stf_sal_remarks;
	}

	public String getStf_sal_date() {
		return stf_sal_date;
	}

	public void setStf_sal_date(String stf_sal_date) {
		this.stf_sal_date = stf_sal_date;
	}

	public String getStf_sal_mon() {
		return stf_sal_mon;
	}

	public void setStf_sal_mon(String stf_sal_mon) {
		this.stf_sal_mon = stf_sal_mon;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	/*
	 * @ManyToOne private Staff staff;
	 */
	
	
}
