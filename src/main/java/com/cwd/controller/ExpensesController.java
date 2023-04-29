package com.cwd.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.cwd.model.Exp_report;
import com.cwd.model.Expenses;
import com.cwd.model.Students;
import com.cwd.repository.Exp_Report_Repository;
import com.cwd.repository.Expense_Repository;
import com.cwd.utils.ExpensesExcelView;
import com.cwd.utils.ImportStudentExcel;
import com.cwd.utils.ReportExpensesExcelView;
import com.cwd.utils.StudentExcelView;

@Controller
public class ExpensesController {

	@Autowired
	private Expense_Repository exp_repo;
	
	@Autowired
	private Exp_Report_Repository exp_rep_repo;
	
	@GetMapping("/expense")
	public String ExpensesPage(Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("exp_list",exp_repo.findAll());
		
		int total_exp = 0;
		
		for(Expenses exp : exp_repo.findAll())
			total_exp = total_exp + exp.getExp_amount();
		
		model.addAttribute("total_exp_amount", total_exp);
		
		return "Office_Expenses";
	}
	
	@PostMapping("/expan")
	public String AddExpenses(@ModelAttribute Expenses expan, Model model,HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		exp_repo.save(expan);
		return "redirect:expense";
	}
	
	@GetMapping("/exp_delete")
	public String Del_Expenses(@RequestParam Integer id, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		exp_repo.deleteById(id);
		return "redirect:expense";
	}
	
	@GetMapping("/exp_edit")
	public String Edit_Expense(@RequestParam Integer id, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("edit_exp",exp_repo.getById(id));
		return "Edit_Expenses";
	}
	
	
	@GetMapping("/all_exp")
	public String ALl_Expenses(Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("exp_list",exp_repo.findAll());
		return "Office_All_Expenses";
	}
	
	
	/* Search Data Between two dates */
	@RequestMapping("/find_exp")
	public String Search_dataBetweendates(@RequestParam  String e_from ,@RequestParam String e_to, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		List<Expenses> expfind = exp_repo.getFilterExpensesWithDate(e_from,e_to);
		
		System.out.println(expfind.size());
		
		int total_exp = 0;
		for(Expenses exp : expfind)
			total_exp = total_exp + exp.getExp_amount();
		
		model.addAttribute("total_exp_amount", total_exp);
		
		if(expfind != null) {
			
			model.addAttribute("foundata",expfind);
			
			System.out.println(e_from);
			System.out.println(e_to);
			
			return "Office_All_Expenses";
		}
		
		return "Office_All_Expenses";
	}
	
	
	@GetMapping("/rep_exp_delete")
	public String Del_Report_Expenses(@RequestParam Integer id, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		exp_repo.deleteById(id);
		return "redirect:find_exp";
	}
	
	
	
	/** 8. export data to excel file*/

	@GetMapping("/all_exp_excel")
	public ModelAndView exportToExcel() {
		ModelAndView m =  new ModelAndView();
		m.setView(new ExpensesExcelView());

		//read data from DB
		List<Expenses> list = exp_repo.findAll();
		//send to Excel Impl class
		m.addObject("list", list);

		return m;
	}
		 	
	
}
