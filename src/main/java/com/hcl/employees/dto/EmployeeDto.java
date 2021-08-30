package com.hcl.employees.dto;

import lombok.Data;

@Data
public class EmployeeDto {
	
	public String employeeName;
	public String designation;
	public EmployeeDto(String employeeName, String designation) {
		this.employeeName=employeeName;
		this.designation=designation;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	
}
