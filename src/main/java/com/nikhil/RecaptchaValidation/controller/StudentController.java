package com.nikhil.RecaptchaValidation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nikhil.RecaptchaValidation.entity.Student;
import com.nikhil.RecaptchaValidation.repositories.StudentRepo;
import com.nikhil.RecaptchaValidation.service.RecaptchaValidation;

@Controller
@RequestMapping("/student") 
public class StudentController {


    @Autowired
	private RecaptchaValidation recaptchaValidation;
	
	@Autowired
	private StudentRepo studentRepo;
	
	 @GetMapping("/register")
	 public String showRegister(Model model)
	 {  
		 model.addAttribute("student", new Student());
		 return "studentRegister";
	  }
	 


	 @PostMapping("/save")
	 public String saveStudent(@ModelAttribute("student")
	 Student student,  
	 
	 @RequestParam(name="g-recaptcha-response")
	 String captcha, Model model) 
	 {  
		 if(recaptchaValidation.validateCaptcha(captcha))
	        {    
			 studentRepo.save(student); 
			 model.addAttribute("student", new Student());
			 model.addAttribute("message", "Student added Sucessfully!!"); 
			 } 
		     else { 
		    	 model.addAttribute("message", "Please Verify Captcha");
		    	 }      
		 return "studentRegister"; 
	}  
	 
	 @GetMapping("/all")
	 public String getAllStudent(Model model)
	 {  
		 model.addAttribute("list", studentRepo.findAll()); 
         return "studentData"; 
         
	 }  

}
