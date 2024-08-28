package com.innspark.mysql.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innspark.mysql.entity.EmployeeDetails;
import com.innspark.mysql.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDetails addEmployee(EmployeeDetails employeeDetails) {

		EmployeeDetails savedEmployee = employeeRepository.save(employeeDetails);

		return savedEmployee;

	}

	@Override
	public EmployeeDetails getEmployeeById(Integer empid) {
		System.err.println(employeeRepository.findById(empid).get() + "*****************************");
		return employeeRepository.findById(empid).get();
	}

	@Override
	public List<EmployeeDetails> getAllEmployeeDetails() {
		List<EmployeeDetails> list = employeeRepository.findAll();

		return list;
	}

	@Override
	public String updateEmployee(EmployeeDetails employeeDetails) {

		EmployeeDetails findOneEmp = employeeRepository.findById(employeeDetails.getEmployeeId()).get();
		if (Objects.nonNull(employeeDetails.getEmployeeName())) {
			findOneEmp.setEmployeeId(employeeDetails.getEmployeeId());
			findOneEmp.setEmployeeName(employeeDetails.getEmployeeName());
			findOneEmp.setDesignation(employeeDetails.getDesignation());
			findOneEmp.setSalary(employeeDetails.getSalary());
			// BeanUtils.copyProperties(findOneEmp, employeeDetails);

			System.out.println(findOneEmp);
			employeeRepository.save(findOneEmp);
			return "EMPLOYEE_UPDATED";
		}
		return "EMPLOYEE_ID_IS_NOT_PRESENT";
	}

	@Override
	public String deleteEmployee(Integer empId) {
		EmployeeDetails employeeDetails = employeeRepository.findById(empId).get();
		if (employeeDetails.getEmployeeId() != 0) {
			employeeRepository.delete(employeeDetails);
		}
		return "EMPLOYEE_DELETED_SUCCESFULLY";
	}

}
