package com.inn_quiz_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn_quiz_service.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

	Optional<Quiz>  findById(Integer id);
}
