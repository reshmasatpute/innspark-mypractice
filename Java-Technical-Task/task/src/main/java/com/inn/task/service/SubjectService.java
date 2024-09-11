package com.inn.task.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.inn.task.entity.SubjectDetails;

public interface SubjectService {

	String createSubject(@RequestBody SubjectDetails subjectDetails);
	
	List<SubjectDetails> findAllSubjectDtails();
}
