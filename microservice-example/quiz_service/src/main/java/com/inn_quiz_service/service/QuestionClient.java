package com.inn_quiz_service.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.inn_quiz_service.entity.Quetion;

import feign.codec.DecodeException;

@FeignClient(value = "QUESTION-SERVICE", url="http://localhost:8081")
public interface QuestionClient {

	@GetMapping("/question/findById/{quizId}")
	List<String> getQuestionOfQuiz(@PathVariable Integer quizId);
	
	@GetMapping("/findAll")
	List<String> getAllQuestion();
}
