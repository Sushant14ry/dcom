package com.cwd.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.cwd.model.Students;


public class StudentExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) 
					throws Exception {

		//1. define your own excel file name
		response.addHeader("Content-Disposition", "attachment;filename=SPECS.xlsx");
		
		//2. read data given by Controller
		@SuppressWarnings("unchecked")
		List<Students> list = (List<Students>) model.get("list");
		
		//3. create one sheet
		Sheet sheet = workbook.createSheet("SPECIALIZATION");
		
		//4. create row#0 as header
		setHead(sheet);
		
		//5. create row#1 onwards from List<T> 
		setBody(sheet,list);
	}


	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("First Name");
		row.createCell(2).setCellValue("Last Name");
		row.createCell(3).setCellValue("Student Faculty");
		row.createCell(4).setCellValue("Student Gender");
		row.createCell(5).setCellValue("Student Email");
		row.createCell(6).setCellValue("Student Phone");
		row.createCell(7).setCellValue("Student Address");
		row.createCell(8).setCellValue("Student Country");
		row.createCell(9).setCellValue("Student Qualification");
		row.createCell(10).setCellValue("Student Batch Year");
		row.createCell(11).setCellValue("Student Course Fee");
		row.createCell(12).setCellValue("Student Date of Birth");
		row.createCell(13).setCellValue("Student Course Enroll Date");
		row.createCell(14).setCellValue("Student Guardians Name");
		row.createCell(15).setCellValue("Student Guardians Phone");
	}
	
	private void setBody(Sheet sheet, List<Students> list) {
		int rowNum = 1;
		for(Students std : list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(std.getStud_id());
			row.createCell(1).setCellValue(std.getStud_first_name());
			row.createCell(2).setCellValue(std.getStud_first_name());
			row.createCell(3).setCellValue(std.getStud_faculty());
			row.createCell(4).setCellValue(std.getStud_gender());
			row.createCell(5).setCellValue(std.getStud_email());
			row.createCell(6).setCellValue(std.getStud_phone());
			row.createCell(7).setCellValue(std.getStud_address());
			row.createCell(8).setCellValue(std.getStud_country());
			row.createCell(9).setCellValue(std.getStud_qualification());
			row.createCell(10).setCellValue(std.getStud_batch_year());
			row.createCell(11).setCellValue(std.getStud_course_fee());
			row.createCell(12).setCellValue(std.getStud_dob());
			row.createCell(13).setCellValue(std.getStud_enroll_date());
			row.createCell(14).setCellValue(std.getStud_guardians_name());
			row.createCell(15).setCellValue(std.getStud_guardians_phone());
	
		}
	}

}
