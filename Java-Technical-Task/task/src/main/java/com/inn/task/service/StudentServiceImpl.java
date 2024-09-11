package com.inn.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.task.dto.StudentWithMarkDto;
import com.inn.task.entity.StudentDetails;
import com.inn.task.entity.StudentMarks;
import com.inn.task.repository.StudentMarksRepository;
import com.inn.task.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentMarksService studentMarksService;
	@Autowired
	private StudentMarksRepository studentMarksRepository;

	@Override
	public String createStudent(StudentDetails student) {
		StudentDetails savedStudent = studentRepository.save(student);
		return savedStudent + ": saved successfully..........";
	}

	
	@Override
	public StudentDetails findByStudentId(Integer studentId) {
		Optional<StudentDetails> optional = studentRepository.findById(studentId);
		if (optional.isEmpty()) {
			throw new RuntimeException("student record is null....!!!");
		} else {
			return optional.get();
		}
	}

	/**
	 * This method is for to get the student details with marks 
	 * @param markId
	 * @return
	 */
	@Override
	public List<StudentMarks> getStudentDetailsWithMarksByMarkId(Integer markId){
		List<StudentMarks> studentWithMarkList = studentMarksRepository.getStudentById(markId);
		return studentWithMarkList;
	}


	@Override
	public List<StudentDetails> findAllStudent() {
		return studentRepository.findAll();
	}

}
