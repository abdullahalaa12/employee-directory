package com.employee_directory.employee_directory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_directory.employee_directory.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
