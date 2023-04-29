package com.cwd.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Intern_Doccument {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int int_id;
	private String int_pp_photo;
	private String int_citizen_photo;
	private String int_certificate_photo;
	private String int_passport_photo;
	private String int_exp_letter_photo;
	private String int_carriculum_photo;
	
	@ManyToOne
	@JoinColumn(name = "intern_id")
	private Students student;

	public int getInt_id() {
		return int_id;
	}

	public void setInt_id(int int_id) {
		this.int_id = int_id;
	}

	public String getInt_pp_photo() {
		return int_pp_photo;
	}

	public void setInt_pp_photo(String int_pp_photo) {
		this.int_pp_photo = int_pp_photo;
	}

	public String getInt_citizen_photo() {
		return int_citizen_photo;
	}

	public void setInt_citizen_photo(String int_citizen_photo) {
		this.int_citizen_photo = int_citizen_photo;
	}

	public String getInt_certificate_photo() {
		return int_certificate_photo;
	}

	public void setInt_certificate_photo(String int_certificate_photo) {
		this.int_certificate_photo = int_certificate_photo;
	}

	public String getInt_passport_photo() {
		return int_passport_photo;
	}

	public void setInt_passport_photo(String int_passport_photo) {
		this.int_passport_photo = int_passport_photo;
	}

	public String getInt_exp_letter_photo() {
		return int_exp_letter_photo;
	}

	public void setInt_exp_letter_photo(String int_exp_letter_photo) {
		this.int_exp_letter_photo = int_exp_letter_photo;
	}

	public String getInt_carriculum_photo() {
		return int_carriculum_photo;
	}

	public void setInt_carriculum_photo(String int_carriculum_photo) {
		this.int_carriculum_photo = int_carriculum_photo;
	}

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}
	
	
}
