package com.cwd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cwd.repository.Student_Repository;

@Controller
public class GenerateCV_ID_Card_Controller {

	/* Student Repository */
	@Autowired
	private Student_Repository stud_repo;
	
	/* ======================== Generate ID-Card ======================== */
	
	@GetMapping("/idcard")
	public String ID_CardPage(Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("student_list", stud_repo.findAll());
		return "Id_cardPage";
	}
	
	@GetMapping("/view_id")
	public String View_Single_IDcard(@RequestParam Integer id, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("view_student",stud_repo.getById(id));
		return "Generate_Id_card";
	}
	
	
	/* ======================== Generate Certificate ======================== */
	
	@GetMapping("/certificate")
	public String Certificate_Page(Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("student_list", stud_repo.findAll());
		return "Certificate_Page";
	}
	
	@GetMapping("/gen_cert")
	public String Gen_Certificate(@RequestParam Integer id , Model model) {
		
		model.addAttribute("gen_cert", stud_repo.getById(id));
		return "Generate_Certificate";
	}
	
	
	

}
