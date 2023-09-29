package com.greatlearning.employeemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeemanagementsystem.model.Employee;
import com.greatlearning.employeemanagementsystem.repository.EmployeeRepository;

@Service

public class EmployeeServiceImplementation implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		// TODO Auto-generated method stub
		Employee updatedEmployeeInfo = getEmployeeById(id);
    	updatedEmployeeInfo.setFirstName(employee.getFirstName());
    	updatedEmployeeInfo.setLastName(employee.getLastName());
    	updatedEmployeeInfo.setEmail(employee.getEmail());
		return saveEmployee(employee);
	}

	@Override
	public void deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);	
	}
}
