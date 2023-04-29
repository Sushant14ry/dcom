package com.cwd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Join_Interns")
//@Data
public class InternShip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int intern_id;
	private String intern_joindate;
	private String intern_finishdate;
	private String intern_country;
	private String intern_department;
	
	@ManyToOne
	@JoinColumn(name = "studen_id")
	private Students student;

	public int getIntern_id() {
		return intern_id;
	}

	public void setIntern_id(int intern_id) {
		this.intern_id = intern_id;
	}

	public String getIntern_joindate() {
		return intern_joindate;
	}

	public void setIntern_joindate(String intern_joindate) {
		this.intern_joindate = intern_joindate;
	}

	public String getIntern_finishdate() {
		return intern_finishdate;
	}

	public void setIntern_finishdate(String intern_finishdate) {
		this.intern_finishdate = intern_finishdate;
	}

	public String getIntern_country() {
		return intern_country;
	}

	public void setIntern_country(String intern_country) {
		this.intern_country = intern_country;
	}

	public String getIntern_department() {
		return intern_department;
	}

	public void setIntern_department(String intern_department) {
		this.intern_department = intern_department;
	}

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}
	
	
}
