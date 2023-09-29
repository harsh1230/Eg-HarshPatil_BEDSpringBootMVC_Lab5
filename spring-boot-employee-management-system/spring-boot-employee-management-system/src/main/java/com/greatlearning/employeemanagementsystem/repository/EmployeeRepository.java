package com.greatlearning.employeemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.employeemanagementsystem.model.Employee;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
