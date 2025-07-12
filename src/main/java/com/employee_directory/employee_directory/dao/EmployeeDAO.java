package com.employee_directory.employee_directory.dao;

import java.util.List;

import com.employee_directory.employee_directory.entity.Employee;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
