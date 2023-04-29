package com.cwd.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cwd.model.Students;
import com.cwd.repository.Faculty_Repository;
import com.cwd.repository.Student_Repository;
import com.cwd.utils.ImportStudentExcel;
import com.cwd.utils.StudentExcelView;

@Controller
public class Student_Controller {

	/* Student Repository */
	@Autowired
	private Student_Repository stud_repo;
	
	@Autowired
	private Faculty_Repository fcty_repo;
	
	/* ================== Show All Data in table ============= */
	@GetMapping("/stud_page")
	private String StudentPage(Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
//		ra.addAttribute("Stud_sin_list",);
		model.addAttribute("student_list", stud_repo.findAll());
		model.addAttribute("faculty_list",fcty_repo.findAll());
		return "Student_Page";
	}
	
	/* ================== Add New Student in table ============= */
	@PostMapping("/stud_page")
	public String Add_New_Student(@RequestParam("imgs") MultipartFile file, @ModelAttribute Students stdn , Model model, HttpSession session) throws IOException {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		if(!file.isEmpty()) { 
			FileOutputStream fout = new
			FileOutputStream("src/main/resources/static/Student_Img/" + file.getOriginalFilename()); 
			fout.write(file.getBytes()); 
			stdn.setStud_photo(file.getOriginalFilename());
			fout.close();
			
			stud_repo.save(stdn);
			return "redirect:stud_page";
		}
		return "redirect:stud_page";
	}
	
/* ================== View Single Student Data from Database ============= */
	
	@GetMapping("/view")
	public String View_Single_Student(@RequestParam Integer id, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("view_student",stud_repo.getById(id));
		return "View_Single_Student_details";
	}
	
	
	/* ================== Delete Student from Database ============= */
	
	@GetMapping("/deleted")
	public String Delete_Student(@RequestParam Integer id, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		stud_repo.deleteById(id);
		return "redirect:stud_page";
	}
	
	/* ================== Edit Single Student Data from Database ============= */
	
	@GetMapping("/edited")
	public String Edit_Single_Student(@RequestParam Integer id, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("edit_student",stud_repo.getById(id));
		return "Edit_Student_details";
	}
	
	/* ================== Update Student in table ============= */
	
	@PostMapping("/update")
	public String Update_Student(@RequestParam("imgs") MultipartFile file, @ModelAttribute Students stdn , Model model, HttpSession session) throws IOException {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
//		find Old images from database using student specific id
		Students stud_oldimage = stud_repo.findById(stdn.getStud_id()).get();
		
		if(!file.isEmpty()) { 
			FileOutputStream fout = new
			FileOutputStream("src/main/resources/static/Student_Img/" + file.getOriginalFilename()); 
			fout.write(file.getBytes()); 
			stdn.setStud_photo(file.getOriginalFilename());
			fout.close();
			
			stud_repo.save(stdn);
			return "redirect:stud_page";
		}else {
			stdn.setStud_photo(stud_oldimage.getStud_photo());
			stud_repo.save(stdn);
		}
		return "redirect:stud_page";
	}
	
	
	/***
	 * 8. export data to excel file
	 */
	@GetMapping("/excel")
	public ModelAndView exportToExcel() {
		ModelAndView m =  new ModelAndView();
		m.setView(new StudentExcelView());

		//read data from DB
		List<Students> list = stud_repo.findAll();
		//send to Excel Impl class
		m.addObject("list", list);

		return m;
	}
	
	
	/* Import Data from Excel */
//	@RequestMapping("/import/excel")
//	@ResponseBody
//	public String ImportFromExcel() {
//		ImportStudentExcel importexcel = new ImportStudentExcel();
//		List<Students> stud_list = importexcel.excelImporter();
//		stud_repo.saveAll(stud_list);
//		
//		return "Import Successfully";
//	}
	
}
