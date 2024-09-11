package com.inn.task.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.inn.task.config.CustomeStudentDetails;
import com.inn.task.entity.StudentDetails;
import com.inn.task.repository.StudentRepository;

public class CustomStudentDetailsService implements UserDetailsService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<StudentDetails> credential = studentRepository.findByStudentName(username);
		return credential.map(CustomeStudentDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("Student Not found with name : " + username));
	}

}
