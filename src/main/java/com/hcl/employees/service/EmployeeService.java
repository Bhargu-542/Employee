package com.hcl.employees.service;

import java.util.List;

import com.hcl.employees.dto.EmployeeDto;
import com.hcl.employees.dto.EmployeeRequestDto;
import com.hcl.employees.entity.Employee;

public interface EmployeeService {

	List<Employee> saveEmployee(List<Employee> employees);

	List<Employee> getEmployeesWhoseSalaryGreaterThan50000();

	List<EmployeeDto> getEmployeeNameAndDesignationWhoseSalaryLessThan20000();

	List<EmployeeRequestDto> getEmployeesHikeData();

}
