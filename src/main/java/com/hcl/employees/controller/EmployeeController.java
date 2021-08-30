package com.hcl.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.employees.dto.EmployeeDto;
import com.hcl.employees.dto.EmployeeRequestDto;
import com.hcl.employees.entity.Employee;
import com.hcl.employees.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<?> saveEmployee(@RequestBody List<Employee> employees) {

		List<Employee> empl = employeeService.saveEmployee(employees);

		if (empl != null) {
			return new ResponseEntity<>(empl, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("User Not saved - " + empl, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("findBySalary")
	public ResponseEntity<?> GetEmployees() {
		List<Employee> employees = employeeService.getEmployeesWhoseSalaryGreaterThan50000();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("GetEmployeeNameAndDesignation")
	public ResponseEntity<?> GetEmployeeNameAndDesignation() {
		return new ResponseEntity<List<EmployeeDto>>(employeeService.getEmployeeNameAndDesignationWhoseSalaryLessThan20000(),HttpStatus.OK);
	}
	
	@GetMapping("HikeSalary")
    public ResponseEntity<List<EmployeeRequestDto>> getHike() {
        return new ResponseEntity<List<EmployeeRequestDto>>(employeeService.getEmployeesHikeData(), HttpStatus.OK);
    }

}
