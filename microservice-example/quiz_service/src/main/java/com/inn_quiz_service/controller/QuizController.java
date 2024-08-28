package com.inn_quiz_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn_quiz_service.entity.Quiz;
import com.inn_quiz_service.service.QuizService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;

	
	@PostMapping("/create")
	public Quiz createQuiz(@RequestBody Quiz quiz) {
		return quizService.createQuiz(quiz);
	}


	@GetMapping("/findAll")
	public List<Quiz> findAllQuiz() {
		return quizService.findAllQuiz();
	}
	
	@GetMapping("/findById/{id}")
	public Quiz findByQuizId(@PathVariable Integer id) {
		return quizService.findByQuizId(id);
		
	}


}
