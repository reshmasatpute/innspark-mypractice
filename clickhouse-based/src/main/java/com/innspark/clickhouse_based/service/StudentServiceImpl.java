package com.innspark.clickhouse_based.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innspark.clickhouse_based.entity.Student;
import com.innspark.clickhouse_based.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		Student savedStudent = studentRepository.createStudent(student);
		return savedStudent;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> allStudent = studentRepository.getAllStudent();
		return allStudent;
	}

	@Override
	public Student updateStudent(Student student) {
		Student updatedStudent = studentRepository.updateStudent(student);
		return updatedStudent;
	}

	@Override
	public Student findByStudentId(Integer studentId) {
		return studentRepository.findByStudentId(studentId);
	}

	@Override
	public String deleteStudent(Integer studentId) {
		return studentRepository.deleteStudent(studentId);
	}

	@Override
	public String deleteStudentByName(String studentName) {
		// TODO Auto-generated method stub
		return null;
	}

}
