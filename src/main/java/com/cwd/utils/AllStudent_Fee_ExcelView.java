package com.cwd.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.cwd.model.Student_Fee;
import com.cwd.model.Students;


public class AllStudent_Fee_ExcelView extends AbstractXlsxView {

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
		Map<String, List<Student_Fee>> list = (Map<String, List<Student_Fee>>) model.get("list");
		
		//3. create one sheet
		Sheet sheet = workbook.createSheet("SPECIALIZATION");
		
		//4. create row#0 as header
		setHead(sheet);
		
		//5. create row#1 onwards from List<T> 
		setBody(sheet,list);
	}


	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("sn");
		row.createCell(1).setCellValue("First Name");
		row.createCell(2).setCellValue("Last Name");
		row.createCell(3).setCellValue("Student Faculty");
		row.createCell(4).setCellValue("Student Batch Year");
		row.createCell(5).setCellValue("Student Course Fee");
		row.createCell(6).setCellValue("Student Fee ID");
		row.createCell(7).setCellValue("Student Fee Instalment");
		row.createCell(8).setCellValue("Student Fee Amount");
		row.createCell(9).setCellValue("Student Fee Date");
		row.createCell(10).setCellValue("Student Fee Remarks");

	}
	
	private void setBody(Sheet sheet, Map<String, List<Student_Fee>> list) {
		int rowNum = 1;
for(String fn : list.keySet()) {		
		for(Student_Fee stdf : list.get(fn)) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(rowNum);
			row.createCell(1).setCellValue(fn);
			row.createCell(2).setCellValue(stdf.getStudent().getStud_last_name());
			row.createCell(3).setCellValue(stdf.getStudent().getStud_faculty());
			row.createCell(4).setCellValue(stdf.getStudent().getStud_batch_year());
			row.createCell(5).setCellValue(stdf.getStudent().getStud_course_fee());
			row.createCell(6).setCellValue(stdf.getStud_fee_id());
			row.createCell(7).setCellValue(stdf.getStud_fee_installment());
			row.createCell(8).setCellValue(stdf.getStud_fee_amount());
			row.createCell(9).setCellValue(stdf.getStud_fee_paydate());
			row.createCell(10).setCellValue(stdf.getStud_fee_remarks());
	
		}
	}
	}

}
