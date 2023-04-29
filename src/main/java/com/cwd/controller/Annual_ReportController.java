package com.cwd.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cwd.model.Expenses;
import com.cwd.model.Stf_salary;
import com.cwd.model.Student_Fee;
import com.cwd.repository.Expense_Repository;
import com.cwd.repository.Staff_Salary_Repository;
import com.cwd.repository.Student_Fee_Repository;

@Controller
public class Annual_ReportController {

	/* Student Fee Repository */
	@Autowired
	private Student_Fee_Repository stud_fee_repo;
	
	/* Expenses Repository */
	@Autowired
	private Expense_Repository exp_repo;
	
	/* Staff Slary Repository */
	@Autowired
	private Staff_Salary_Repository stf_salary_repo;
	
	@GetMapping("/anual_report")
	public String Annul_ReportPage(Model model,HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		/* Total Student Amount Section */
		int TotalStudAmout = stud_fee_repo.getStudentTotalAmount();
		model.addAttribute("Total_Stud_fee",TotalStudAmout);
		
		/* Total Expenses Section */
		int total_exp = 0;
		for(Expenses exp : exp_repo.findAll())
			total_exp = total_exp + exp.getExp_amount();
		model.addAttribute("total_exp_amount", total_exp);
		
		
		/* Total Staff Amount Section */
		int total_stf_sal = 0;
		for(Stf_salary stf_sal : stf_salary_repo.findAll())
			total_stf_sal = total_stf_sal + stf_sal.getStf_sal_amount();
		model.addAttribute("total_staff_amount", total_stf_sal);
		
		return "Anual_report";
	}
}
