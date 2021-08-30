package com.hcl.employees.dto;

public class EmployeeRequestDto {
	
	public String employeeName;
	public double salary;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public EmployeeRequestDto(String employeeName, double salary) {
		super();
		this.employeeName = employeeName;
		this.salary = salary;
	}
	
	

}
