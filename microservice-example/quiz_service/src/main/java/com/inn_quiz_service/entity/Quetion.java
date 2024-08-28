package com.inn_quiz_service.entity;

public class Quetion {

	private Integer questionId;
	private String questionName;
	private Integer quizId;

	public Quetion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quetion(Integer questionId, String questionName, Integer quizId) {
		super();
		this.questionId = questionId;
		this.questionName = questionName;
		this.quizId = quizId;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public Integer getQuizId() {
		return quizId;
	}

	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionName=" + questionName + ", quizId=" + quizId + "]";
	}

}
