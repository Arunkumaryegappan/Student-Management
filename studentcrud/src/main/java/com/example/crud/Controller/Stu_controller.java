package com.example.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.crud.Entity.Student;
import com.example.crud.Service.Stu_service;


@Controller
public class Stu_controller {
	@Autowired
	Stu_service service;

	@GetMapping("/index")
	
	public String hello() {
		return "index";
	}
	
	@GetMapping("/studentregister")
	public String studentregister() {
	return "studentregister";
		
	}
	
	@PostMapping("/save")
	public String addstudent(@ModelAttribute("student") Student s) {
		service.save(s);
		return "redirect:/totalstudents";
		
	}
	@GetMapping("/totalstudents")
	public ModelAndView totalstudents() {
		List<Student> list = service.findallstudents();
		
		return new ModelAndView("totalstudents","student",list);
		
	}
	@RequestMapping("/deleteid/{id}")
	public String deleteid(@PathVariable("id")int id) {
		service.deleteid(id);
		return "redirect:/totalstudents";
	}
	@RequestMapping("/updateid/{id}")
	public String updateid(@PathVariable("id")int id ,Model m) {
		Student s = service.findid(id);
		m.addAttribute("student", s);
		return "updateid";
	}
	
	
	
	
}
