package com.cwd.dto;

import lombok.Data;


@Data
public class InternShipData {

	private int insd_id;
	private String stud_first_name;
	private String stud_last_name;
	private String stud_faculty;
	private String stud_gender;
	private String stud_photo;
	private String stud_email;
	private String stud_phone;
	private String stud_address;
	private String stud_country;
	private String stud_semester;
	private String stud_qualification;
	private String stud_batch_year;
	private String stud_course_fee;
	
	
	private String intern_joindate;
	private String intern_finishdate;
	private String intern_country;
	private String intern_department;
}
