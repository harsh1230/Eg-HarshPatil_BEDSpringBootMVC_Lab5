package com.greatlearning.employeemanagementsystem.service;

import java.util.List;

import com.greatlearning.employeemanagementsystem.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	
	Employee saveEmployee(Employee employee);
	
	Employee getEmployeeById(Integer id);
	
	Employee updateEmployee(int id, Employee employee);
	
	void deleteEmployeeById(int id);
}
