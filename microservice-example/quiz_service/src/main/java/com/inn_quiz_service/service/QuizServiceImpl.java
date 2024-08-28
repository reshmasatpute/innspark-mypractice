package com.inn_quiz_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn_quiz_service.entity.Quiz;
import com.inn_quiz_service.repository.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository quizRepository;
	
	private QuestionClient questionClient;
	
	

	/*
	 * public QuizServiceImpl(QuizRepository quizRepository) { super();
	 * this.quizRepository = quizRepository; }
	 */
	
	
	public QuizServiceImpl(QuestionClient questionClient) {
		super();
		this.questionClient = questionClient;
	}

	@Override
	public Quiz createQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	/**
	 * Implementing Fiegn client
	 */
	@Override
	public List<Quiz> findAllQuiz() {
		List<Quiz> listOfQuiz = quizRepository.findAll();
		
		listOfQuiz.forEach(quiz-> questionClient.getAllQuestion().addAll(quiz.getQuestions()));
//	    listOfQuiz.forEach(quiz -> {
//	    	List<String> questions = questionClient.getQuestionOfQuiz(quiz.getId());
//	        
//	        // Set questions to the quiz object
//	        quiz.setQuestions(questions);
//	        System.out.println("--------------------------"+questions);
//	    });
//		listOfQuiz.stream().map(quiz->{
//			quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId());
//			return quiz;
//		}).collect(Collectors.toList());
		listOfQuiz.stream().forEach(System.out::println);
		return listOfQuiz;
	}

	@Override
	public Quiz findByQuizId(Integer id) {
		Quiz quiz = quizRepository.findById(id).get();
		quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
	}

}
