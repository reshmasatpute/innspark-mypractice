package com.innspark.mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.innspark.mysql.entity.EmployeeDetails;
import com.innspark.mysql.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody EmployeeDetails employeeDetails) {
		employeeService.addEmployee(employeeDetails);
		return "EMPLOYEE_CREATED";
	}

	@GetMapping("/getEmployeeById/{empid}")
	public EmployeeDetails getEmployeeById(@PathVariable Integer empid) {
		System.err.println(empid);
		return employeeService.getEmployeeById(empid);
	}

	@GetMapping("/getAllEmployees")
	public List<EmployeeDetails> getAllEmployeeDetails() {
		List<EmployeeDetails> list = employeeService.getAllEmployeeDetails();
		System.out.println(list);
		return list;
	}

	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody EmployeeDetails employeeDetails) {
		String updateEmployee = employeeService.updateEmployee(employeeDetails);
		return updateEmployee;
	}

	@DeleteMapping("deleteEmployee/{empId}")
	public String deleteEmployee(@PathVariable Integer empId) {
		employeeService.deleteEmployee(empId);
		return "EMPLOYEE_RECORD_DELETED";

	}

}
