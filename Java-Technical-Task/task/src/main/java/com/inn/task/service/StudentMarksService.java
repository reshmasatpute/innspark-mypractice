package com.inn.task.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inn.task.dto.StudentWithMarkDto;
import com.inn.task.entity.StudentMarks;

@Service
public interface StudentMarksService {

	// String createStudentMark(StudentMarks studentMark);
	// StudentMarks findByStudentMarksId(Integer studentMarksId);

	/**
	 * This api is for th save student with marks
	 * 
	 * @param studentWithMarkDto
	 * @return List<StudentMarks>
	 */
	public List<StudentMarks> saveStudentWithMarks(StudentWithMarkDto studentWithMarkDto);

	/**
	 * This method is for get the specific studentDetails with their subject with
	 * marks.
	 * 
	 * @param studentId
	 * @return List<StudentMarks>
	 */
	public List<StudentMarks> getStudentDetailsWithMarksByStudentId(Integer markId);

	/**
	 * This api is for to get all student record with subject and marks
	 * @return List<StudentWithMarkDto>
	 */
	public List<StudentWithMarkDto> getAllStudentDetailsWithSubjectsAndMarks();
}
