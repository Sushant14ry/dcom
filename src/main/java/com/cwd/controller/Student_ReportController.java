package com.cwd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cwd.repository.Student_Repository;

@Controller
public class Student_ReportController {

	@Autowired
	private Student_Repository stu_repo;
	
	@GetMapping("/rep_stud")
	public String StudReport(Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		/* Count Total DHM Student */
		String TotalDHM = stu_repo.getDCATotalStudent("dhm");
		model.addAttribute("T_DHM",TotalDHM);
		
		/* Count Total DCA Student */
		String TotalDCA = stu_repo.getDCATotalStudent("dca");
		model.addAttribute("T_DCA",TotalDCA);
		
		/* Count Total 2078 Student */
		int Total_2078 = stu_repo.getTotalStudent(2078);
		model.addAttribute("Stud_2078",Total_2078);
		
		/* Count Total 2079 Student */
		int Total_2079 = stu_repo.getTotalStudent(2079);
		model.addAttribute("Stud_2079",Total_2079);
		
		/* Count Total 2080 Student */
		int Total_2080 = stu_repo.getTotalStudent(2080);
		model.addAttribute("Stud_2080",Total_2080);
		
		/* Count Total 2081 Student */
		int Total_2081 = stu_repo.getTotalStudent(2081);
		model.addAttribute("Stud_2081",Total_2081);
		
		/* Count Total 2082 Student */
		int Total_2082 = stu_repo.getTotalStudent(2082);
		model.addAttribute("Stud_2082",Total_2082);
		
		/* Count Total 2083 Student */
		int Total_2083 = stu_repo.getTotalStudent(2083);
		model.addAttribute("Stud_2083",Total_2083);
		
		/* Count Total 2084 Student */
		int Total_2084 = stu_repo.getTotalStudent(2084);
		model.addAttribute("Stud_2084",Total_2084);
		
		/* Count Total 2085 Student */
		int Total_2085 = stu_repo.getTotalStudent(2085);
		model.addAttribute("Stud_2085",Total_2085);
		
		/* Count Total 2086 Student */
		int Total_2086 = stu_repo.getTotalStudent(2086);
		model.addAttribute("Stud_2086",Total_2086);

		return "Student_Report";
	}
	
	
	
	
	
}
