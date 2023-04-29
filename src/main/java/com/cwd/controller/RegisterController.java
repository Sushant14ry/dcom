package com.cwd.controller;

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
public class RegisterController {

	@Autowired
	private Login_Repository login_repo;
	
	@GetMapping("/singup")
	public String LoginForm() {
		
		return "Register_Page";
	}
	
	@PostMapping("/register")
	public String Register_User(@ModelAttribute Registration regis , Model model) {
		
		/* Encrypt Password in md5 Format */
		regis.setReg_password(DigestUtils.md5DigestAsHex(regis.getReg_password().getBytes()));
		
		login_repo.save(regis);
		return "Login_Page";
	}
}
