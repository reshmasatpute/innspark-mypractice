package com.inn.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inn.task.entity.StudentDetails;
import com.inn.task.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	/*
	 * @PostMapping("/create") public String createStudent(@RequestBody
	 * StudentDetails student) { return studentService.createStudent(student); }
	 */
	
	
	@GetMapping("/findById")
	public StudentDetails findByStudentId(@RequestParam Integer studentId) {
		 StudentDetails studentDetails = studentService.findByStudentId(studentId);
		return studentDetails;
	}
	
	@GetMapping("/findAll")
	public List<StudentDetails> findAllStudent() {
		return studentService.findAllStudent();
		
		
	}
	
	
	
	
	
}
