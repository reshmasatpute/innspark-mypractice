package com.inn.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inn.task.config.AuthRequest;
import com.inn.task.config.JwtUtil;
import com.inn.task.entity.StudentDetails;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private JwtUtil util;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@PostMapping("/create")
	public String createStudent(@RequestBody StudentDetails student) {
		String saveStudent = util.saveStudent(student);
		return saveStudent;
	}

	@PostMapping("/generateToken")
	public String getToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			return util.generateToken(authRequest.getUsername());

		} else {
			throw new RuntimeException("invalid access......");
		}

	}

	@GetMapping("/validate")
	public String validateToken(@RequestParam("token") String token) {
		String username = util.extractUsername(token); // Extract username from token
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		if (userDetails == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}

		if (util.validateToken(token, userDetails)) {
			return "Token is valid.";
		} else {
			return "Token is invalid or expired.";
		}
	}

}
