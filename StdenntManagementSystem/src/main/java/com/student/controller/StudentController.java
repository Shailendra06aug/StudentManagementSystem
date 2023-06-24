package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.entity.Student;
import com.student.service.StudentService;



@Controller
public class StudentController {
     
	@Autowired
	private StudentService service;

//	public StudentController(StudentService service) {
//		super();
//		this.service = service;
//	}
	
	//handler method to handel list of student return model and view
	@GetMapping("/students")
	public String getAll(Model model) {
		
		model.addAttribute("student", service.getallstudent());
		
		return"student";
	}
	
	@GetMapping("/mystudent")
	public String addStudent(Model model) {
		
		Student student= new Student();
		model.addAttribute("student",student);
		
		return"create_student";
		
	}
	
	@PostMapping("/studentDtails")
	public String saveAllStudent(@ModelAttribute("student") Student student) {
		
	 	service.saveStudent(student);
	 	
	 	return "redirect:/students"; // redirect to url not html view
		
	}
	
	//we want to send the data so we can use Model 
	@GetMapping("/student/edit/{id}")
	public String editStudentForm(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("student", service.getStudentById(id));
		
		return "edit_student";
	}
	
	
	//we save the data we can use @ModelAttribute
	@PostMapping("/studens/{id}")
	public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student, Model model) {
		
		//get student from database
		Student existingStudent = service.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstname(student.getFirstname());
		existingStudent.setLastname(student.getLastname());
		existingStudent.setEmail(student.getEmail());
		
		
		//Save updated Data
		service.updateStudent(student);
		return "redirect:/students";
	}
	
	//Delete Student
	@GetMapping("/studentDelete/{id}")
	public String DeleteStudent(@PathVariable("id") Long id) {
		
		service.deleteStudentById(id);
		return "redirect:/students";
	}
	
	
	//Show single details
	@GetMapping("/stu/edit/{id}")
	public String StudentDetails(@PathVariable("id") Long id, Model model) {
		
		Student student = new Student();
		
		model.addAttribute("model",service.getStudentById(id));
		System.out.println("data "+student);

		
		return "student_details";	
	}
	
	@GetMapping("/backToHome")
	public String retuenHome() {
		
		return"redirect:/students";
	}

	

	
	
	
	
}
