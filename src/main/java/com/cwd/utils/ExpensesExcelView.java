package com.cwd.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.cwd.model.Exp_report;
import com.cwd.model.Expenses;



public class ExpensesExcelView extends AbstractXlsxView {

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
		List<Expenses> list = (List<Expenses>) model.get("list");
		
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
		row.createCell(1).setCellValue("Expense Name");
		row.createCell(2).setCellValue("Expense Amount");
		row.createCell(3).setCellValue("Expense Remark");
		row.createCell(4).setCellValue("Expense Date");
	}
	
	private void setBody(Sheet sheet, List<Expenses> list) {
		int rowNum = 1;
		for(Expenses exp : list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(exp.getExp_id());
			row.createCell(1).setCellValue(exp.getExp_name());
			row.createCell(2).setCellValue(exp.getExp_amount());
			row.createCell(3).setCellValue(exp.getExp_remark());
			row.createCell(4).setCellValue(exp.getExp_date());
			
		}
	}

}
