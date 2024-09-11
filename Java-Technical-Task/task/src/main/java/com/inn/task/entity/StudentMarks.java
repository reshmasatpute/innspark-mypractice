package com.inn.task.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentMarks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer markId;
	
	@ManyToOne
	@JoinColumn(name = "studentId")
	private StudentDetails studentDetails;
	
	@ManyToOne
	@JoinColumn(name = "subjectId")
	private SubjectDetails subjectDetails;
	
	private Double marks;
}
