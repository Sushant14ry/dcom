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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cwd.model.Staff;
import com.cwd.model.Stf_salary;
import com.cwd.model.Students;
import com.cwd.repository.Staff_Repository;
import com.cwd.repository.Staff_Salary_Repository;
import com.cwd.utils.StaffExcelView;
import com.cwd.utils.StudentExcelView;

@Controller
public class Staff_Controller {

	/* ================== Staff Repository ============= */
	@Autowired
	private Staff_Repository stf_repo;
	
	@Autowired
	private Staff_Salary_Repository stf_salary_repo;
	
	/* ================== Show All Staff in table ============= */
	@GetMapping("/staff_p")
	public String Staff_Page(Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("staff_list",stf_repo.findAll());
		return "StaffPage";
	}
	
	/* ================== Add New Staff in table ============= */
	@PostMapping("/staff_p")
	public String Add_New_Student(@RequestParam("staff_imgs") MultipartFile file, @ModelAttribute Staff stf , Model model, HttpSession session) throws IOException {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		if(!file.isEmpty()) { 
			FileOutputStream fout = new
			FileOutputStream("src/main/resources/static/Staff_Img/" + file.getOriginalFilename()); 
			fout.write(file.getBytes()); 
			stf.setStaff_photos(file.getOriginalFilename());
			fout.close();
			
			stf_repo.save(stf);
			return "redirect:staff_p";
		}
		return "redirect:staff_p";
	}
	
/* ================== View Single Student Data from Database ============= */
	
	@GetMapping("/view_s")
	public String View_Single_Staff(@RequestParam Integer id, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("view_staff",stf_repo.getById(id));
		return "View_Single_Staff_details";
	}
	
	
	/* ================== Delete Student from Database ============= */
	
	@GetMapping("/delete_s")
	public String Delete_Staff(@RequestParam Integer id, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		stf_repo.deleteById(id);
		return "redirect:staff_p";
	}
	
	@GetMapping("/edited_s")
	public String Edit_Single_Student(@RequestParam Integer id, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("edit_staff",stf_repo.getById(id));
		return "Edit_Staff_details";
	}
	
	/* ================== Update Student in table ============= */

	@PostMapping("/update_stf")
	public String Update_Staff(@RequestParam("staff_imgs") MultipartFile file, @ModelAttribute Staff stf , Model model, HttpSession session) throws IOException {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		Staff old_staffImage = stf_repo.findById(stf.getStf_id()).get();
		
		if(!file.isEmpty()) { 
			FileOutputStream fout = new
			FileOutputStream("src/main/resources/static/Staff_Img/" + file.getOriginalFilename()); 
			fout.write(file.getBytes()); 
			stf.setStaff_photos(file.getOriginalFilename());
			fout.close();
			
			stf_repo.save(stf);
			return "redirect:staff_p";
		}else {
			stf.setStaff_photos(old_staffImage.getStaff_photos());
		}
		return "redirect:staff_p";
	}
	
	/* ===================================================================== */
	
//	@PostMapping("/pay_salary")
//	public String Pay_Salary(@ModelAttribute Stf_salary stf_salry, Model model,@RequestParam("stf_id") int id) {
//		
//		System.out.println("============="+id);
//		 Staff sf = new Staff();
//		 sf.setStf_id(id);
//		stf_salry.setStaff(sf);
//		stf_salary_repo.save(stf_salry);
//		return "redirect:staff_p";
//	}
	
	
	/*
	 * @PostMapping("/pay_salary") public String Pay_Salary(@ModelAttribute
	 * Stf_salary stf_salry, Model model,@RequestParam("stf_id") int id) {
	 * 
	 * System.out.println("============="+id);
	 * 
	 * stf_salry.setStaff_id(id); stf_salary_repo.save(stf_salry); return
	 * "redirect:staff_p"; }
	 */
	
	
	/* =============== Staff Pay Salary Page Start ===================== */
	
	@GetMapping("/stf_slry")
	public String Staff_Salary_Page(Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("staff_list",stf_repo.findAll());
		return "Staff_Salary";
	}
	
/* =============== Pay Salary Which User  ===================== */
	
	@GetMapping("/pay_salry")
	public String Pay_Staff_Salary(@RequestParam Integer id, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("stf",stf_repo.getById(id));
		return "pay_salary";
	}
	
	@PostMapping("/pay_salary")
	public String Pay_Salary(@ModelAttribute Stf_salary stf_sal, @RequestParam("stf_id") Integer id, HttpSession session) {
		System.out.println(id);
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		stf_sal.setStaff(stf_repo.getById(id));
		stf_salary_repo.save(stf_sal);
		return "redirect:stf_slry";
	}
	
	@GetMapping("/view_pay_salry")
	public String show_staff_paymentDetails(@RequestParam("id") Integer id, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
//		model.addAttribute("stf_salary",stf_salary_repo.getStaffSalaryDetailsById(id));
		
		List<Stf_salary> sts = stf_salary_repo.getStaffSalaryDetailsById(id);
		model.addAttribute("stf_salary",sts);
		
		int stf_sal = 0;
		for(Stf_salary stf_s : sts) {
			stf_sal = stf_sal + stf_s.getStf_sal_amount();
		}
		model.addAttribute("total_stf_sal",stf_sal);
		
		model.addAttribute("stf_details",stf_repo.getById(id));
		return "Staff_Salary_Payment";
	}
	
	
	/***
	 * 8. export data to excel file
	 */
	@GetMapping("/staffExcel")
	public ModelAndView exportToExcel() {
		ModelAndView m =  new ModelAndView();
		m.setView(new StaffExcelView());

		//read data from DB
		List<Staff> list = stf_repo.findAll();
		//send to Excel Impl class
		m.addObject("list", list);

		return m;
	}
	
}
