package com.cwd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cwd.model.Exp_report;
import com.cwd.model.Expenses;
import com.cwd.model.Student_Fee;
import com.cwd.model.Students;
import com.cwd.repository.Exp_Report_Repository;
import com.cwd.repository.Expense_Repository;
import com.cwd.utils.ExpensesExcelView;
import com.cwd.utils.ReportExpensesExcelView;
import com.cwd.utils.StudentExcelView;
import com.cwd.utils.Student_Fee_ExcelView;

@Controller
public class Exp_ReportController {

	@Autowired
	private Exp_Report_Repository exp_rep_repo;
	
	@Autowired
	private Expense_Repository exp_repo;
	

	/* Expenses Report in Excel */
	
	@GetMapping("/exp_reports")
	public ModelAndView exportReportToExcel(@ModelAttribute Exp_report expr) {
		ModelAndView m =  new ModelAndView();
		m.setView(new ReportExpensesExcelView());
		
		System.out.println("Filter amount : "+expr);
		Expenses expfind = exp_rep_repo.getFilterExpensesWithDate(expr.getE_from(), expr.getE_to());
		
		if(expfind != null){
			
			m.addObject("list", exp_repo.findAll());
			System.out.println("Download Sucees");
			return m;
		}
		System.out.println("Download Fail");
		
		
		return m;
	}
	

	

}
