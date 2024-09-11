package com.inn.task.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentWithMarkDto {

	private Integer studentId;
    private String studentName;
    private String studentEmail;
    private List<SubjectWithMarks> subjectMarks;
    
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SubjectWithMarks {
    	private String subjectName;
        private Double marks;
    }
}
