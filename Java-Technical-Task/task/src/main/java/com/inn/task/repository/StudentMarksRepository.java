package com.inn.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inn.task.entity.StudentMarks;

@Repository
@EnableJpaRepositories
public interface StudentMarksRepository extends JpaRepository<StudentMarks, Integer> {

	@Query("SELECT s1 FROM StudentMarks s1 " +
		       "JOIN s1.subjectDetails s " +
		       "WHERE s1.studentDetails.studentId = :studentId " +
		       "ORDER BY s1.marks DESC")
		public List<StudentMarks> getStudentById(@Param("studentId") Integer studentId);
}
