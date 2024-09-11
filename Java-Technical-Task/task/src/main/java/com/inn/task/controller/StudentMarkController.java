package com.inn.task.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inn.task.dto.StudentWithMarkDto;
import com.inn.task.entity.StudentDetails;
import com.inn.task.entity.StudentMarks;
import com.inn.task.service.StudentMarksService;
import com.inn.task.service.StudentService;

@Controller
@RequestMapping("/marks")
public class StudentMarkController {

	@Autowired
	private StudentMarksService studentMarksService;

	@Autowired
	private StudentService studentService;

	/**
	 * This api is for to save student details with marks.
	 * 
	 * @param studentWithMarkDto
	 * @return List<StudentMarks>
	 */
	@PostMapping("/save")
	public List<StudentMarks> saveStudentWithMarks(@RequestBody StudentWithMarkDto studentWithMarkDto) {
		return studentMarksService.saveStudentWithMarks(studentWithMarkDto);
	}

	/**
	 * This api is for get specific studentdetails with subject and marks
	 * 
	 * @param studentId
	 * @return String
	 */
	@GetMapping("/getStudentDetailsWithMarks")
	public String getStudentDetailsWithMarks(@RequestParam Integer studentId, Model model) {

		StudentDetails studentDetails = studentService.findByStudentId(studentId);
		if (studentDetails != null) {
			List<StudentMarks> studentDetailsWithSubjectsAndMarks = studentMarksService
					.getStudentDetailsWithMarksByStudentId(studentId);

			List<StudentWithMarkDto.SubjectWithMarks> subjectMarks = studentDetailsWithSubjectsAndMarks.stream()
					.map(marks -> new StudentWithMarkDto.SubjectWithMarks(marks.getSubjectDetails().getSubjectName(),
							marks.getMarks()))
					.collect(Collectors.toList());

			StudentWithMarkDto studentWithMarkDto = new StudentWithMarkDto(studentDetails.getStudentId(),
					studentDetails.getStudentName(), studentDetails.getStudentEmail(), subjectMarks);
			model.addAttribute("studentDetails", studentWithMarkDto);
			System.err.println(studentWithMarkDto + "-----------------------");
			return "studentDetails";
		} else {
			model.addAttribute("error", "Record Not Found");
			return "error";
		}

	}

	/**
	 * This api is for get all studentdetails with subject and marks
	 * 
	 * @return String
	 */
	@GetMapping("/getAllStudentDetailsWithSubjectsAndMarks")
	public String getAllStudentDetailsWithSubjectsAndMarks(@RequestParam Integer subjectId, Model model) {
		System.out.println("inside the get ==");
		List<StudentWithMarkDto> allStudentDetailsWithSubjectsAndMarks = studentMarksService
				.getAllStudentDetailsWithSubjectsAndMarks();
		model.addAttribute("studentDetails", allStudentDetailsWithSubjectsAndMarks);
		System.err.println(allStudentDetailsWithSubjectsAndMarks+"*******************************************************");
		return "allStudentsData";

	}

}
