package com.inn.task.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.task.entity.SubjectDetails;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectDetails, Integer> {

	Optional<SubjectDetails> findBySubjectName(String subjectName);
}
