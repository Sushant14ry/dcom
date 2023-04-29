package com.cwd.model;

import javax.persistence.Column;
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
@Table(name = "CV_table")
//@Data
public class CV_Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cv_id;
	private String cfnam;
	private String clname;
	private String cphoto;
	private String cgender;
	private String cemail;
	private String cphone;
	private String caddress;
	private String ccountry;
	private String cqualification;
	private String cbasicqualification;
	
	@Column(length = 1000)
	private String cedubackground;
	@Column(length = 1000)
	private String cskills;
	@Column(length = 1000)
	private String cintrest;
	@Column(length = 1000)
	private String cexp;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String cdob;

	public int getCv_id() {
		return cv_id;
	}

	public void setCv_id(int cv_id) {
		this.cv_id = cv_id;
	}

	public String getCfnam() {
		return cfnam;
	}

	public void setCfnam(String cfnam) {
		this.cfnam = cfnam;
	}

	public String getClname() {
		return clname;
	}

	public void setClname(String clname) {
		this.clname = clname;
	}

	public String getCphoto() {
		return cphoto;
	}

	public void setCphoto(String cphoto) {
		this.cphoto = cphoto;
	}

	public String getCgender() {
		return cgender;
	}

	public void setCgender(String cgender) {
		this.cgender = cgender;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCphone() {
		return cphone;
	}

	public void setCphone(String cphone) {
		this.cphone = cphone;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getCcountry() {
		return ccountry;
	}

	public void setCcountry(String ccountry) {
		this.ccountry = ccountry;
	}

	public String getCqualification() {
		return cqualification;
	}

	public void setCqualification(String cqualification) {
		this.cqualification = cqualification;
	}

	public String getCbasicqualification() {
		return cbasicqualification;
	}

	public void setCbasicqualification(String cbasicqualification) {
		this.cbasicqualification = cbasicqualification;
	}

	public String getCedubackground() {
		return cedubackground;
	}

	public void setCedubackground(String cedubackground) {
		this.cedubackground = cedubackground;
	}

	public String getCskills() {
		return cskills;
	}

	public void setCskills(String cskills) {
		this.cskills = cskills;
	}

	public String getCintrest() {
		return cintrest;
	}

	public void setCintrest(String cintrest) {
		this.cintrest = cintrest;
	}

	public String getCexp() {
		return cexp;
	}

	public void setCexp(String cexp) {
		this.cexp = cexp;
	}

	public String getCdob() {
		return cdob;
	}

	public void setCdob(String cdob) {
		this.cdob = cdob;
	}
	
	
}
