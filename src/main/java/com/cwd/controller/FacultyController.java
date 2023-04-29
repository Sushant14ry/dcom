package com.cwd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cwd.model.Faculty;
import com.cwd.repository.Faculty_Repository;

@Controller
public class FacultyController {

	@Autowired
	private Faculty_Repository fcty_repo;
	
	@GetMapping("/faculty")
	public String Faculty_Page(Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("faculty_list",fcty_repo.findAll());
		return "facultyPage";
	}
	
	@PostMapping("/faculty")
	public String Post_Faculty(@ModelAttribute Faculty facty,HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		fcty_repo.save(facty);
		return "redirect:faculty";
	}
	
	@GetMapping("/delete")
	public String Delete_faculty(@RequestParam Integer id,HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		fcty_repo.deleteById(id);
		return "redirect:faculty";
	}
	
}
