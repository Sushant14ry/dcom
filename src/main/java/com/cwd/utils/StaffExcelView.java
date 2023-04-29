package com.cwd.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.cwd.model.Staff;
import com.cwd.model.Students;


public class StaffExcelView extends AbstractXlsxView {

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
		List<Staff> list = (List<Staff>) model.get("list");
		
		//3. create one sheet
		Sheet sheet = workbook.createSheet("All Staff Details");
		
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
		row.createCell(3).setCellValue("Staff Faculty");
		row.createCell(4).setCellValue("Staff Gender");
		row.createCell(5).setCellValue("Staff Email");
		row.createCell(6).setCellValue("Staff Phone");
		row.createCell(7).setCellValue("Staff Address");
		row.createCell(8).setCellValue("Staff Experience");
		row.createCell(9).setCellValue("Staff Qualification");
		row.createCell(10).setCellValue("Teaching Subject");
		row.createCell(11).setCellValue("Staff Salary");
		row.createCell(12).setCellValue("Staff Date of Birth");
		row.createCell(13).setCellValue("Student Join Date");
	}
	
	private void setBody(Sheet sheet, List<Staff> list) {
		int rowNum = 1;
		for(Staff stf : list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(stf.getStf_id());
			row.createCell(1).setCellValue(stf.getStaff_first_name());
			row.createCell(2).setCellValue(stf.getStaff_last_name());
			row.createCell(3).setCellValue(stf.getStaff_faculty());
			row.createCell(4).setCellValue(stf.getStaff_gender());
			row.createCell(5).setCellValue(stf.getStaff_email());
			row.createCell(6).setCellValue(stf.getStaff_phone());
			row.createCell(7).setCellValue(stf.getStaff_address());
			row.createCell(8).setCellValue(stf.getStaff_experience());
			row.createCell(9).setCellValue(stf.getStaff_qualification());
			row.createCell(10).setCellValue(stf.getStaff_sub_teacher());
			row.createCell(11).setCellValue(stf.getStaff_salary());
			row.createCell(12).setCellValue(stf.getStaff_dob());
			row.createCell(13).setCellValue(stf.getStaff_join_date());
		}
	}

}
