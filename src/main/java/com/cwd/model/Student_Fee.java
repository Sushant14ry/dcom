package com.cwd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "Student_Fee_table")
//@Data
public class Student_Fee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stud_fee_id;
	private String stud_fee_installment;
	private int stud_fee_amount;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private String stud_fee_paydate;
	private String stud_fee_remarks;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Students student;

	public int getStud_fee_id() {
		return stud_fee_id;
	}

	public void setStud_fee_id(int stud_fee_id) {
		this.stud_fee_id = stud_fee_id;
	}

	public String getStud_fee_installment() {
		return stud_fee_installment;
	}

	public void setStud_fee_installment(String stud_fee_installment) {
		this.stud_fee_installment = stud_fee_installment;
	}

	public int getStud_fee_amount() {
		return stud_fee_amount;
	}

	public void setStud_fee_amount(int stud_fee_amount) {
		this.stud_fee_amount = stud_fee_amount;
	}

	public String getStud_fee_paydate() {
		return stud_fee_paydate;
	}

	public void setStud_fee_paydate(String stud_fee_paydate) {
		this.stud_fee_paydate = stud_fee_paydate;
	}

	public String getStud_fee_remarks() {
		return stud_fee_remarks;
	}

	public void setStud_fee_remarks(String stud_fee_remarks) {
		this.stud_fee_remarks = stud_fee_remarks;
	}

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}
	
	
}
