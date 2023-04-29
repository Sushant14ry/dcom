package com.cwd.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cwd.model.Student_gallery;
import com.cwd.repository.Stud_Gallery_Repository;
import com.cwd.repository.Student_Repository;

@Controller
public class StudentGalleryController {

	@Autowired
	private Stud_Gallery_Repository stu_g_repo;

	@Autowired
	private Student_Repository stud_repo;

	/* ==================== Student Gallery ========================== */

	@GetMapping("/student_gal")
	public String Student_Gallery_Page(Model model, HttpSession session) {

		File dir = new File("src/main/resources/static/Student_Gallery");
		String[] stud_image_names = dir.list();
		if (session.getAttribute("usr") == null) {

			return "Login_Page";
		}

		model.addAttribute("stud_imagList", stud_image_names);

		return "Student_gallery";
	}

//	
	/* ====================== method -1 ================= */

//	@PostMapping("/upload_stud")
//	public String Upload_Student_Photos(@RequestParam("stud_imgs") MultipartFile[] files, Student_gallery stud_gall , Model model ) throws IOException {
//		List<String> stud_gall_list = new ArrayList<String>();
//		
//		for(MultipartFile file:files) {
//			stud_gall_list.add(file.getOriginalFilename());
//			
//			if(!file.isEmpty()) {
//				FileOutputStream fout = new FileOutputStream("src/main/resources/static/Student_Gallery/"+file.getOriginalFilename());
//				fout.write(file.getBytes());
//				
//				fout.close();
//				model.addAttribute("msg","Photo Upload Success");
//				
//				stu_g_repo.save(stud_gall);
//				stud_gall.setStud_multiple_images(stud_gall_list);
//				
//				return "redirect:student_gal";
//				
//			}	
//		}
//		
//		model.addAttribute("msg","Photo Upload Failed");
//		return "redirect:student_gal";
//	}

	/* ====================== method - 2 ================= */
//	@PostMapping("/upload_stud")
//	public String UploadGallery(@RequestParam("stud_imgs") MultipartFile[] files, Student_gallery stud_gal, Model model) throws IOException {
//		List<String> stud_gal_list = new ArrayList<>();
//		
//		for(MultipartFile file : files ) {
//			
//			if(!file.isEmpty()) {
//				
//				FileOutputStream fout = new FileOutputStream("src/main/resources/static/Student_Gallery/"+file.getOriginalFilename());
//				fout.write(file.getBytes());
//				stud_gal.setStud_multiple_images(stud_gal_list);
//				
//				fout.close();
//				stu_g_repo.save(stud_gal);
//				return "redirect:student_gal";
//			}
//		}	
//		return "redirect:student_gal";
//	}

	/* ====================== method - 3 Final Method Upload Image ================= */
	@RequestMapping("/upload_stud")
	public String Upload(@RequestParam("stud_imgs") MultipartFile[] files, Model model) {
		String imgPath = "src/main/resources/static/Student_Gallery/";

		System.out.println(files.length);

		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {

			Student_gallery sg = new Student_gallery();
			sg.setStud_gall_name(file.getOriginalFilename());

			fileNames.append(file.getOriginalFilename());
			try {
				Files.copy(file.getInputStream(), Paths.get(imgPath + file.getOriginalFilename()),
						StandardCopyOption.REPLACE_EXISTING);

				stu_g_repo.save(sg);
				model.addAttribute("msg", "Successfully Upload Files" + fileNames.toString());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return "redirect:student_gal";
	}

	/* ====================== method - 4 ================= */
//	@RequestMapping("/upload_stud")
//	public String UploadMultiple(@RequestParam("stud_imgs") MultipartFile[] files,Model model, Student_gallery stud_gall) {
//		List<String> message = new ArrayList<String>();
//		for(MultipartFile file : files) {
//			try {
//				if(file.getOriginalFilename().isEmpty()) {
//					message.add("Fail --> Empty File Name");
//					continue;
//				}
//				stud_gall.setStud_multiple_images(message);
//				stu_g_repo.save(stud_gall);
//				message.add("Successfully --> upload filename"+ file.getOriginalFilename());
//			} catch (Exception e) {
//				message.add("Successfully --> upload filename"+ file.getOriginalFilename());
//			}
//		}
//		model.addAttribute("message",message);
//		
//		return "redirect:student_gal";
//	}

	/* ==================== School Gallery ========================== */
	
	@GetMapping("/school_gal")
	public String School_Gallery_Page(Model model, HttpSession session) {
		
		if(session.getAttribute("usr") == null) {
			
			return "Login_Page";
		}
		
		model.addAttribute("student_list", stud_repo.findAll());
		
		return "School_gallery";
	}
}
