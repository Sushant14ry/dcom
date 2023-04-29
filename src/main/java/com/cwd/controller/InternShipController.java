package com.cwd.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cwd.dto.InternShipData;
import com.cwd.model.InternShip;
import com.cwd.model.Intern_Doccument;
import com.cwd.model.Student_gallery;
import com.cwd.model.Students;
import com.cwd.repository.Faculty_Repository;
import com.cwd.repository.Internship_Repository;
import com.cwd.repository.Join_Internship_Repository;
import com.cwd.repository.Student_Repository;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class InternShipController {
	
	@Autowired
	private Internship_Repository intern_repo;
	
	@Autowired
	private Join_Internship_Repository join_intern_repo;
	
	@Autowired
	private Student_Repository stud_repo;
	
	@Autowired
	private Faculty_Repository fcty_repo;
	
	@GetMapping("/intern_page")
	public String InternshipPage(Model model, HttpSession session) {

		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("student_list",stud_repo.findAll());
		model.addAttribute("faculty_list",fcty_repo.findAll());
		return "InternShip_Page";
	}
	
//	@PostMapping("/intern")
//	public String Upload_Intern_data(@RequestParam("int_img") MultipartFile[] files, @ModelAttribute Intern_Doccument intdoc, @RequestParam("stud_id") Integer id,  Model model) throws IOException {
//		String imgPath= "src/main/resources/static/Intern_doccument/";
//		 
//		System.out.println(files.length);
//		
//		StringBuilder fileNames = new StringBuilder();
//		for(MultipartFile file : files) {
//			
//			Intern_Doccument sg = new Intern_Doccument();
//			sg.setInt_certificate_photo(file.getOriginalFilename());
//			sg.setInt_carriculum_photo(file.getOriginalFilename());
//			sg.setInt_exp_letter_photo(file.getOriginalFilename());
//			sg.setInt_citizen_photo(file.getOriginalFilename());
//			
//			fileNames.append(file.getOriginalFilename());
//			try {
//               Files.copy(file.getInputStream(), Paths.get(imgPath+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
//	
//				intern_repo.save(sg);
//				model.addAttribute("msg","Successfully Upload Files"+fileNames.toString());
//	
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return "InternDOC";
//	}
	
	@PostMapping("/intern")
	public String Upload_DOC(@RequestParam("int_img") MultipartFile[] files,Intern_Doccument intdoc,@RequestParam("stud_id") Integer id, InternShip internj, Model model, HttpSession session) throws IOException {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		String ar[] = new String[6];
		int i = 0;
		
		for(MultipartFile file : files ) {
			ar[i] = file.getOriginalFilename();
			i++;
			if(!file.isEmpty()) {
				FileOutputStream fout = new FileOutputStream("src/main/resources/static/Intern_doccument/"+file.getOriginalFilename());
						
				fout.write(file.getBytes());
				fout.close();
				System.out.println(id);
					
			}
		}
		
		intdoc.setInt_pp_photo(ar[0]);
		intdoc.setInt_certificate_photo(ar[1]);
		intdoc.setInt_citizen_photo(ar[2]);
		intdoc.setInt_exp_letter_photo(ar[3]);
		intdoc.setInt_passport_photo(ar[4]);
		intdoc.setInt_carriculum_photo(ar[5]);
		intdoc.setStudent(stud_repo.getById(id));
		intern_repo.save(intdoc);
		
		internj.setStudent(stud_repo.getById(id));
		join_intern_repo.save(internj);
		model.addAttribute("msg","Data Upload Success");
		return "redirect:intern_page";
	}
	
	@GetMapping("/interndoc")
	public String Intern_DocPage(@RequestParam() Integer id, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}		
		
		model.addAttribute("edit_student",stud_repo.getById(id));
		return "InternDOC";
	}
	
	@GetMapping("/view_intern")
	public String Intern_Students(@RequestParam("id") Integer id, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}	
		
		Intern_Doccument doc =intern_repo.getInternshipStudentById(id);
		Students s =  stud_repo.getById(id);
		if(doc != null && s != null)
		{
			model.addAttribute("int_doc",doc);
			model.addAttribute("std", s);
		}else {
			model.addAttribute("int_doc",new Intern_Doccument());
			model.addAttribute("std", s);
		}
		return "View_Intern_Student";
	}

	/*
	 * ============================================================================
	 */
			
	/* Edit Internship Documment */
//	@GetMapping("/edit_intern")
//	public String EditIntern(@RequestParam Integer id, Model model) {
//			
//		Intern_Doccument doc =intern_repo.getInternshipStudentById(id);
//		Students s =  stud_repo.getById(id);
//		if(doc != null && s != null)
//		{
//			model.addAttribute("int_doc",doc);
//			model.addAttribute("std", s);
//		}else {
//			model.addAttribute("int_doc",new Intern_Doccument());
//			model.addAttribute("std", s);
//		}
//			
//			return "Edit_Intern_Doc";
//		}
	
	@GetMapping("/del_doc")
	public String Delete_InternDoc(@RequestParam Integer id, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}	
		
		intern_repo.deleteById(id);
		return "redirect:intern_page";
	}
	
	@GetMapping("/edit_intern")
	public String Edit_Intern_Docs_Date(@RequestParam Integer id, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}	
		
//		model.addAttribute("ind_doc",intern_repo.getInternshipStudentById(id));
		model.addAttribute("intern_join",join_intern_repo.getJoinInternsStudentById(id));
		model.addAttribute("std",stud_repo.getById(id));	

		return "Edit_Intern_Doc";
	}
	
	@PostMapping("/upd_intern_date")
	public String Update_Intern_date(@ModelAttribute InternShip interns, @RequestParam("stud_id") Integer id, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}	
		
		Students s = stud_repo.getById(id);
		interns.setStudent(s);
		System.out.println();
		join_intern_repo.save(interns);
		return "redirect:intern_page";
	}
	
	
	
	/* Join InternShip Section Start */
	@GetMapping("/join_intern")
	public String JoinInternship(@ModelAttribute InternShip interns, Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}	
		
//		model.addAttribute("Joined_student", join_intern_repo.getInternJoinedAllStudents());
		
		List<Object> intj = join_intern_repo.getInternJoinedAllStudents();
		System.out.println(intj.size());
		System.out.println((InternShipData)intj.get(0));
		
		
	  Stream.of(intj);
		
//		model.addAttribute("Joined_student",intj);
//		model.addAttribute("Joined_student",intj.get(0).getStudent());
		
		return "Join_Internship";
	}
	
}
