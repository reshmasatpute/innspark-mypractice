package com.innspark.mysql.service;

import java.util.List;

import com.innspark.mysql.entity.EmployeeDetails;

public interface EmployeeService {

	EmployeeDetails addEmployee(EmployeeDetails employeeDetails);

	EmployeeDetails getEmployeeById(Integer empid);

	List<EmployeeDetails> getAllEmployeeDetails();

	String updateEmployee(EmployeeDetails employeeDetails);

	String deleteEmployee(Integer empId);

}
