package com.inn.task.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.task.dto.StudentWithMarkDto;
import com.inn.task.dto.StudentWithMarkDto.SubjectWithMarks;
import com.inn.task.entity.StudentDetails;
import com.inn.task.entity.StudentMarks;
import com.inn.task.entity.SubjectDetails;
import com.inn.task.repository.StudentMarksRepository;
import com.inn.task.repository.StudentRepository;
import com.inn.task.repository.SubjectRepository;

@Service
public class StudentMarksServiceImpl implements StudentMarksService {

	@Autowired
	private StudentMarksRepository studentMarksRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	/**
	 * This method is for save the student details ,subject details with it's marks
	 */

	@Override
	public List<StudentMarks> saveStudentWithMarks(StudentWithMarkDto studentWithMarkDto) {

		/**
		 * Fetching the student from database which is present in StudentWithMarkDto
		 */
		StudentDetails studentDetails = studentRepository.findById(studentWithMarkDto.getStudentId())
				.orElseThrow(() -> new RuntimeException("Student not found : " + studentWithMarkDto.getStudentId()));

		List<StudentMarks> savedStudentWithMarkList = new ArrayList<StudentMarks>();

		for (StudentWithMarkDto.SubjectWithMarks subjectMarks : studentWithMarkDto.getSubjectMarks()) {
			SubjectDetails subjectDetails = subjectRepository.findBySubjectName(subjectMarks.getSubjectName())
					.orElseThrow(() -> new RuntimeException("subject not found" + subjectMarks.getSubjectName()));

			StudentMarks studentWithSubjectWithMarks = new StudentMarks();

			studentWithSubjectWithMarks.setStudentDetails(studentDetails);
			studentWithSubjectWithMarks.setSubjectDetails(subjectDetails);
			studentWithSubjectWithMarks.setMarks(subjectMarks.getMarks());

			savedStudentWithMarkList.add(studentMarksRepository.save(studentWithSubjectWithMarks));
		}
		return savedStudentWithMarkList;
	}

	/**
	 * This api is for to get the specific student record with mark and subject
	 */

	@Override
	public List<StudentMarks> getStudentDetailsWithMarksByStudentId(Integer studentId) {
		List<StudentMarks> listOfStudentWithMarks = studentMarksRepository.getStudentById(studentId);
		return listOfStudentWithMarks;
	}

	/**
	 * This api is for to get all student details with subject and its
	 */
	public List<StudentWithMarkDto> getAllStudentDetailsWithSubjectsAndMarks() {
		// Retrieve all mappings without filtering by subjectId
		List<StudentMarks> mappings = studentMarksRepository.findAll(); // Assuming you have a method to get all
																		// mappings

		// Group the mappings by student ID
		Map<Integer, List<SubjectWithMarks>> subjectMarksByStudent = mappings.stream()
				.collect(
						Collectors.groupingBy(m -> m.getStudentDetails().getStudentId(),
								Collectors.mapping(
										m -> new StudentWithMarkDto.SubjectWithMarks(
												m.getSubjectDetails().getSubjectName(), m.getMarks()),
										Collectors.toList())));

		// Construct the list of StudentMarksDTO
		return subjectMarksByStudent.entrySet().stream().map(entry -> {
			int studentId = entry.getKey();
			List<SubjectWithMarks> subjectMarks = entry.getValue();

			// Retrieve the student details from the first mapping (assuming all mappings
			// for a student have the same details)
			StudentMarks firstMapping = mappings.stream().filter(m -> m.getStudentDetails().getStudentId() == studentId)
					.findFirst().orElse(null);

			return new StudentWithMarkDto(studentId, firstMapping.getStudentDetails().getStudentName(),
					firstMapping.getStudentDetails().getStudentEmail(), subjectMarks);
		}).collect(Collectors.toList());
	}

}