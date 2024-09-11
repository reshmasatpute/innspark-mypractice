package com.inn.task.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.task.entity.StudentDetails;

@Repository
public interface StudentRepository extends JpaRepository<StudentDetails, Integer>{

	Optional<StudentDetails> findByStudentName(String username);

}
