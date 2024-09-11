package com.inn.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.task.entity.SubjectDetails;
import com.inn.task.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	
	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public String createSubject(SubjectDetails subjectDetails) {
		 SubjectDetails savedSubject = subjectRepository.save(subjectDetails);
		return savedSubject+": saved successfully";
	}

	@Override
	public List<SubjectDetails> findAllSubjectDtails() {
		List<SubjectDetails> listOfSubject = subjectRepository.findAll();
		return listOfSubject;
	}

}
