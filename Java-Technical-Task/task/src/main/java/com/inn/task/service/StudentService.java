package com.inn.task.service;

import java.util.List;

import com.inn.task.entity.StudentDetails;
import com.inn.task.entity.StudentMarks;

public interface StudentService {

	String createStudent(StudentDetails student);

	StudentDetails findByStudentId(Integer studentId);

	List<StudentMarks> getStudentDetailsWithMarksByMarkId(Integer markId);

	List<StudentDetails> findAllStudent();
}
