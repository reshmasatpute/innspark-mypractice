package com.inn.task.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDetails {

	@Id
	private Integer subjectId;
	private String subjectName;
	
	
	@ManyToOne
	@JoinColumn(name = "studentId")
	private StudentDetails studentDetails;
}
