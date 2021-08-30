package com.hcl.employees.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.employees.dto.EmployeeDto;
import com.hcl.employees.dto.EmployeeRequestDto;
import com.hcl.employees.entity.Employee;
import com.hcl.employees.repository.EmployeeRepository;
import com.hcl.employees.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeRepository employeeRepository;

	@Override
	public List<Employee> saveEmployee(List<Employee> employees) {
		List<Employee> empl = new ArrayList<>();
		for (int i = 0; i < employees.size(); i++) {
			Employee employee = employees.get(i);
			if (employee.age > 18 && employee.mobileNumber.length() == 10 && employee.designation.matches("^[a-zA-Z]*$")
					&& employee.employeeName.matches("^[a-zA-Z]*$")) {
				empl.add(employee);

			}

		}

		return employeeRepository.saveAll(empl);

	}

	@Override
	public List<Employee> getEmployeesWhoseSalaryGreaterThan50000() {
		List<Employee> emplList = employeeRepository.findEmployeesBySalaryGreaterThan50000().stream().toList();
		return emplList;
	}

	@Override
	public List<EmployeeDto> getEmployeeNameAndDesignationWhoseSalaryLessThan20000() {

		List<Employee> employeeList = employeeRepository.findBySalaryLessThan20000();

		List<EmployeeDto> dtoList = employeeList.stream()
				.map(employee -> new EmployeeDto(employee.getEmployeeName(), employee.getDesignation()))
				.collect(Collectors.toList());
		return dtoList;
	}

	@Override
	public List<EmployeeRequestDto> getEmployeesHikeData() {
		List<Employee> employeeList = employeeRepository.findBySalaryLessThan20000();

		employeeList.stream().forEach(employee -> {
			employee.setSalary(employee.getSalary() + 10000);
			employeeRepository.flush();
		});

		List<EmployeeRequestDto> dtoList = employeeList.stream()
				.map(employee -> new EmployeeRequestDto(employee.getEmployeeName(), employee.getSalary()))
				.collect(Collectors.toList());
		return dtoList;
	}

}
