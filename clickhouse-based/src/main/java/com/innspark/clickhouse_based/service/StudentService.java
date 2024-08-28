package com.innspark.clickhouse_based.service;

import java.util.List;

import com.innspark.clickhouse_based.entity.Student;

public interface StudentService {

	public Student createStudent(Student student);
	
	public List<Student> getAllStudent();
	
	public Student findByStudentId(Integer studentId);
	
	public Student updateStudent(Student student);
	
	public String deleteStudent(Integer studentId);
	
	public String deleteStudentByName(String studentName);
}
