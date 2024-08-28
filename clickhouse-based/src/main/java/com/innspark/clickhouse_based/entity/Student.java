package com.innspark.clickhouse_based.entity;

public class Student {

	private Integer studentId;
	private String studentName;
	private String address;


	public Student(Integer studentId, String studentName, String address) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.address = address;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", address=" + address + "]";
	}

}
