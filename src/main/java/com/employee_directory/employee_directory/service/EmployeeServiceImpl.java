package com.employee_directory.employee_directory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee_directory.employee_directory.dao.EmployeeDAO;
import com.employee_directory.employee_directory.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

}
