package com.inn.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn.task.entity.SubjectDetails;
import com.inn.task.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;

	@PostMapping("/create")
	public String createSubject(@RequestBody SubjectDetails subjectDetails) {
		return subjectService.createSubject(subjectDetails);	
	}
	
	@GetMapping("/findAll")
	public List<SubjectDetails> findAllSubjectDetails() {
		return subjectService.findAllSubjectDtails();
		
	}
}
