package com.inn_quiz_service.service;

import java.util.List;

import com.inn_quiz_service.entity.Quiz;

public interface QuizService {

	public Quiz createQuiz(Quiz quiz);
	
	public List<Quiz> findAllQuiz();
	
	public Quiz findByQuizId(Integer id);
}
