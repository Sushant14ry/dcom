package com.cwd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cwd.model.Student_Fee;
import com.cwd.model.Students;
import com.cwd.repository.Student_Fee_Repository;
import com.cwd.repository.Student_Repository;
import com.cwd.utils.AllStudent_Fee_ExcelView;
import com.cwd.utils.NumberToWordss;
import com.cwd.utils.StudentExcelView;
import com.cwd.utils.Student_Fee_ExcelView;

@Controller
public class Student_Fee_Controller {

	/* Student Repository */
	@Autowired
	private Student_Repository stud_repo;

	/* Student Fee Repository */
	@Autowired
	private Student_Fee_Repository stud_fee_repo;

	/* =============== Student Fee Payment ================= */

	@GetMapping("/student_fee")
	public String AccountPage(@ModelAttribute Students std, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}

		model.addAttribute("student_list", stud_repo.findAll());
		return "Student_Fee_details";
	}

	@GetMapping("/pay_Fee")
	public String Student_Pay_Fee_Page(@RequestParam Integer id, Model model, HttpSession session) {

		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("std", stud_repo.getById(id));
		return "Pay_Student_Fee";
	}

	@PostMapping("/feePayment")
	public String Pay_Student_Fee(@ModelAttribute Student_Fee studnt_fee, @RequestParam("stud_id") Integer id, HttpSession session) {

		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		studnt_fee.setStudent(stud_repo.getById(id));
		stud_fee_repo.save(studnt_fee);
		return "redirect:student_fee";
	}

	/* =============== Show Student Fee Payment ================= */

	@GetMapping("/view_Fee")
	public String StudentfeePaymentDetailsPage(@RequestParam("id") Integer id, Model model, HttpSession session) {

		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}

		List<Student_Fee> sf = stud_fee_repo.getStudentPaymentDetailsById(id);
		System.out.println(sf.size());
		model.addAttribute("stud_fee_list", sf);
		
		int tm = 0;
		for (Student_Fee stdFee : sf)
			tm = tm + stdFee.getStud_fee_amount();

		model.addAttribute("all_fee_amount", tm);
//		model.addAttribute("stud_fee", sf.get(0).getStudent());
		model.addAttribute("stud_fee", stud_repo.getById(id));
		
		return "Student_Fee_Payment";
	}
	
	@GetMapping("/bill_gen")
	public String FeePaymentBillGenerate(@RequestParam("id") Integer id, Model model, HttpSession session) {

		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		List<Student_Fee> sf = stud_fee_repo.getStudentPaymentFeeDetailsById(id);
		System.out.println(sf.size());
		model.addAttribute("stud_fee_list", sf);
		
		int tm = 0;
		for (Student_Fee stdFee : sf)
			tm = tm + stdFee.getStud_fee_amount();


		model.addAttribute("all_fee_amount", tm);
		model.addAttribute("amountWord",NumberToWordss.NumToWords(tm) );

		model.addAttribute("stud_fee", sf.get(0).getStudent());
		model.addAttribute("Installment",sf.get(0).getStud_fee_installment());
		
		return "Student_Fee_BillGenerate";
	}
	
	
	/* Export Student fee data in excel form */
	
	@GetMapping("/stud_fee_excel")
	public ModelAndView exportToExcel(@RequestParam("id") Integer id) {
		ModelAndView m =  new ModelAndView();
		m.setView(new Student_Fee_ExcelView());

		//read data from DB
		List<Student_Fee> list = stud_fee_repo.getStudentPaymentDetailsById(id);
	
		//send to Excel Impl class
		m.addObject("list", list);

		return m;
	}

}
