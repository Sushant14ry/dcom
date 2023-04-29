package com.cwd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cwd.model.Registration;
import com.cwd.repository.Login_Repository;

@Controller
public class LoginController {

	@Autowired
	private Login_Repository login_repo;
	
	@GetMapping("/")
	public String indexPage() {
		
		return "Login_Page";
	}
	
	@GetMapping("/login")
	public String LoginPage(HttpSession session) {
		
		if(session.getAttribute("usr") != null) {
			
			return "dashboard";
		}
		
		return "Login_Page";
	}
	
	@PostMapping("/login")
	public String Login_User(@ModelAttribute Registration regis , Model model, HttpSession session) {
		
		/* Password Decrypt */
		regis.setReg_password(DigestUtils.md5DigestAsHex(regis.getReg_password().getBytes()));
		
		Registration regis_log = login_repo.Login_User(regis.getReg_email(), regis.getReg_password());
		
		if(regis_log!= null) {
			
			session.setAttribute("usr", regis_log);
			return "dashboard";
		}
			
		model.addAttribute("log_msg","Invalid Username and Password");
		return "Login_Page";
	
	}
	
	@GetMapping("/logouts")
	public String Logout(HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		session.invalidate();
		return "Login_Page";
	}
	
	
	
	
}
