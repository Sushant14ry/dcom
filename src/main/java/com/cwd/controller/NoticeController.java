package com.cwd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoticeController {

	@GetMapping("/notice_page")
	public String NoticePage() {
		
		return "NoticePage";
	}
	
	@PostMapping("upld_notice")
	public String Upload_Notice() {
		
		return "redirect:notice_page";
	}
}
