package com.innspark.clickhouse_based.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innspark.clickhouse_based.entity.Student;
import com.innspark.clickhouse_based.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@GetMapping("/getAllStudent")
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}

	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);

	}

	@GetMapping("/find/{studentId}")
	public Student findByStudentId(@PathVariable Integer studentId) {
		return studentService.findByStudentId(studentId);
	}

	@DeleteMapping("/delete/{studentId}")
	public String deleteStudent(@PathVariable Integer studentId) {
		return studentService.deleteStudent(studentId);

	}

	@DeleteMapping("deleteByName/{studentName}")
	public String deleteStudentByName(@PathVariable String studentName) {
       String deleteStudentByName = studentService.deleteStudentByName(studentName);
		return deleteStudentByName;

	}

}
