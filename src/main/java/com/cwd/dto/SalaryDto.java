package com.cwd.dto;

import java.sql.Date;

import lombok.Data;
@Data
public class SalaryDto {
	
	private String staff_name;
	private String month;
	private int salary;
	private String remarks;
	private Date  date;

}
