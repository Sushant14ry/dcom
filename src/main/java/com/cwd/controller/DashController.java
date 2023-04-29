package com.cwd.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cwd.model.Staff;
import com.cwd.model.Students;
import com.cwd.repository.Faculty_Repository;
import com.cwd.repository.Internship_Repository;
import com.cwd.repository.Staff_Repository;
import com.cwd.repository.Stud_Gallery_Repository;
import com.cwd.repository.Student_Repository;

@Controller
public class DashController {

	@Autowired
	private Student_Repository stu_repo;
	
	@Autowired
	private Staff_Repository stf_repo;
	
	@Autowired
	private Faculty_Repository fac_repo;
	
	@Autowired
	private Stud_Gallery_Repository stug_repo;
	
	@Autowired
	private Internship_Repository intern_repo;
	
	@GetMapping("/dash")
	private String DashboardPage(Model model,HttpSession session) {
		
		/* Count Total Student Start */
		int Total_Student = stu_repo.getTotalStudent();
		model.addAttribute("Total_stud",Total_Student);

		/* Count Total Staff Start */
		int Total_Staff = stf_repo.getTotalStaff();
		model.addAttribute("Total_stf",Total_Staff);
		
		/* Count Total Faculty Start */
		int Total_faculty = fac_repo.getTotalFaculty();
		model.addAttribute("Total_fac",Total_faculty);
		
		/* Count Total Photos Start */
		int Total_Photos = stug_repo.getTotalPhotos();
		model.addAttribute("Total_photo",Total_Photos);
		
		/* Count Total Interns Start */
		int Total_Interns = intern_repo.getTotalInterns();
		model.addAttribute("Total_inter",Total_Interns);
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		return "dashboard";
	}
	
	
	
}
