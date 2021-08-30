package com.hcl.employees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.employees.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("from Employee where salary > 50000")
	List<Employee> findEmployeesBySalaryGreaterThan50000();

	@Query("from Employee where salary < 20000")
	List<Employee> findBySalaryLessThan20000();

}
