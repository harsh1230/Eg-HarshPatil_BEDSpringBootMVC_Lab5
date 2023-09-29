package com.greatlearning.employeemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.employeemanagementsystem.model.Employee;
import com.greatlearning.employeemanagementsystem.service.EmployeeService;

@Controller

public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	
	private String listEmployees(Model model) {
		
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "employees";
	}
	
    @GetMapping("/employees/new")
	
	private String createEmployeeForm(Model model) {
		
	    Employee employee = new Employee(); 
		model.addAttribute("employee", employee);
		return "create_employee";
	}
    
    @PostMapping("/employees")
	
	private String saveEmployee(@ModelAttribute("employee") Employee employee) {
	
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
    
    @GetMapping("/employees/edit/{id}")
 	
	private String editEmployeeForm(@PathVariable int id, Model model) {
		
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
	}
    
    @PostMapping("/employees/{id}")
	
	private String updateEmployee(@PathVariable int id, @ModelAttribute("employee") Employee employee, Model model) {
    	
    	employeeService.updateEmployee(id, employee);
		return "redirect:/employees";
	}
    
    @GetMapping("/employees/{id}")
 	
	private String deleteEmployee(@PathVariable int id) {
		
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}
}
