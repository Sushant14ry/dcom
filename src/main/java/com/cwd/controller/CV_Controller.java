package com.cwd.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cwd.model.CV_Model;
import com.cwd.repository.CV_Repository;
import com.cwd.repository.Faculty_Repository;
import com.cwd.repository.Student_Repository;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class CV_Controller {

	/* Student Repository */
	@Autowired
	private Student_Repository stud_repo;
	
	@Autowired
	private CV_Repository cv_repo;
	
	@Autowired
	private Faculty_Repository fac_repo;
	
/* ======================== Generate CV ======================== */
	
	@GetMapping("/cv")
	public String CV_Page(Model model,HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("student_list", stud_repo.findAll());
		model.addAttribute("fac_list", fac_repo.findAll());
		model.addAttribute("cv_list",cv_repo.findAll());
		return "CVPage";
	}
	
	@GetMapping("/view_cv_id")
	public String Generate_CV(@RequestParam Integer id, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("gen_cv",stud_repo.getById(id));
		return "Generate_CV";
	}
	
	@PostMapping("upload_cv")
	public String Upload_CV(@RequestParam("cv_imgs") MultipartFile file,@ModelAttribute CV_Model cv, Model model, HttpSession session) throws IOException {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		if(!file.isEmpty()) {
			FileOutputStream fout = new FileOutputStream("src/main/resources/static/CV_Photos/"+file.getOriginalFilename());
			fout.write(file.getBytes());
			cv.setCphoto(file.getOriginalFilename());
			
			fout.close();
			model.addAttribute("msg",cv_repo.save(cv));
			return "redirect:cv";
			
		}
		model.addAttribute("msg","Failed to Upload CV");
		return "redirect:cv";
	}
	
	
	/* Delete Student Cv */
	@GetMapping("/delete_cv")
	public String Delete_CVPage(@RequestParam Integer id, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		cv_repo.deleteById(id);
		return "redirect:cv";
	}
	
	/* Edit Student CV */
	@GetMapping("/edit_cv")
	public String Edit_CVPage(@RequestParam Integer id, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("upd_cv",cv_repo.getById(id));
		model.addAttribute("fac_list", fac_repo.findAll());
		return "Edit_Student_CV";
	}
	
	/* Generate CV */
	@GetMapping("/gen_cv")
	public String GenerateCV(@RequestParam Integer id, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("gen_cv",cv_repo.getById(id));
		return "Generate_CV";
	}
	
}
