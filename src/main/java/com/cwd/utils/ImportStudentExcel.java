package com.cwd.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cwd.model.Students;

public class ImportStudentExcel {
	public List<Students> excelImporter(){
		List<Students> studList = new ArrayList<>();
		int stud_id = 0;
		String stud_first_name = "";
		String stud_last_name = "";
		String stud_faculty = "";
		String stud_gender = "";
		String stud_photo = "";
		String stud_email = "";
		String stud_phone = "";
		String stud_address = "";
		String stud_country = "";
		String stud_qualification = "";
		String stud_batch_year = "";
		String stud_course_fee = "";
		String stud_dob = "";
		String stud_enroll_date = "";
		String stud_guardians_name = "";
		String stud_guardians_phone = "";
		
		String excelPath = "src/main/resources/static/Student_Img/student.xlsx";
		int start = (int) System.currentTimeMillis();
		
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(excelPath);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = firstSheet.iterator();
			rowIterator.next();
			while(rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				while(cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columIndex = nextCell.getColumnIndex();
					
					switch (columIndex) {
						case 0:
							stud_id = (int)nextCell.getNumericCellValue();
							System.out.println(stud_id);
							break;
						case 1:
							stud_first_name = nextCell.getStringCellValue();
							System.out.println(stud_first_name);
							break;
						case 2:
							stud_last_name = nextCell.getStringCellValue();
							System.out.println(stud_last_name);
							break;
						case 3:
							stud_faculty = nextCell.getStringCellValue();
							System.out.println(stud_faculty);
							break;
						case 4:
							stud_gender = nextCell.getStringCellValue();
							System.out.println(stud_gender);
							break;
						case 5:
							stud_photo = nextCell.getStringCellValue();
							System.out.println(stud_photo);
							break;
						case 6:
							stud_email = nextCell.getStringCellValue();
							System.out.println(stud_email);
							break;
						case 7:
							stud_phone = nextCell.getStringCellValue();
							System.out.println(stud_phone);
							break;
						case 8:
							stud_address = nextCell.getStringCellValue();
							System.out.println(stud_address);
							break;
						case 9:
							stud_country = nextCell.getStringCellValue();
							System.out.println(stud_country);
							break;
						case 10:
							stud_qualification = nextCell.getStringCellValue();
							System.out.println(stud_qualification);
							break;
						case 11:
							stud_batch_year = nextCell.getStringCellValue();
							System.out.println(stud_batch_year);
							break;
						case 12:
							stud_course_fee = nextCell.getStringCellValue();
							System.out.println(stud_course_fee);
							break;
						case 13:
							stud_first_name = nextCell.getStringCellValue();
							System.out.println(stud_first_name);
							break;
						case 14:
							stud_dob = nextCell.getStringCellValue();
							System.out.println(stud_dob);
							break;
						case 15:
							stud_enroll_date = nextCell.getStringCellValue();
							System.out.println(stud_enroll_date);
							break;
						case 16:
							stud_guardians_name = nextCell.getStringCellValue();
							System.out.println(stud_guardians_name);
							break;
						case 17:
							stud_guardians_phone = nextCell.getStringCellValue();
							System.out.println(stud_guardians_phone);
							break; 				
					}
//					studList.add(new Students(stud_id,stud_first_name,stud_last_name,stud_faculty,stud_gender,stud_photo,stud_email,stud_phone,stud_address,stud_country,stud_qualification,stud_batch_year,stud_course_fee,stud_dob,stud_enroll_date,stud_guardians_name,stud_guardians_phone));
				}
			
			}
			workbook.close();
			int end = (int) System.currentTimeMillis();
			System.out.printf("Import Done %d ms\n",(end - start));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return studList;
		
	}
	
	
}
