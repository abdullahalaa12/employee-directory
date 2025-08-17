package com.employee_directory.employee_directory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employee_directory.employee_directory.dao.EmployeeRepository;
import com.employee_directory.employee_directory.entity.Employee;
import com.employee_directory.employee_directory.rest.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> result = employeeRepository.findById(id);

        if (result.isPresent())
            return result.get();
        else
            throw new EmployeeNotFoundException("Did not find employee id - " + id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

}
