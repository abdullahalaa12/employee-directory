package com.employee_directory.employee_directory.rest;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_directory.employee_directory.entity.Employee;
import com.employee_directory.employee_directory.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;
    private final ObjectMapper objectMapper;

    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee emp = employeeService.findById(id);

        if (emp == null)
            throw new EmployeeNotFoundException("Employee id not found - " + id);

        return emp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee emp) {
        emp.setId(0);
        return employeeService.save(emp);
    }

    @PutMapping("/employees")
    public Employee updatEmployee(@RequestBody Employee emp) {
        if (employeeService.findById(emp.getId()) == null)
            throw new EmployeeNotFoundException("Employee id not found - " + emp.getId());
        return employeeService.save(emp);
    }

    @PatchMapping("/employees/{id}")
    public Employee patchEmployee(@PathVariable int id, @RequestBody Map<String, Object> patchPayload) {
        Employee employee = employeeService.findById(id);

        if (employee == null)
            throw new EmployeeNotFoundException("Employee id not found - " + id);

        if (patchPayload.containsKey("id"))
            throw new RuntimeException("Employee id not allowed in request body - " + id);

        Employee patchedEmployee = applyPatch(patchPayload, employee);
        return employeeService.save(patchedEmployee);
    }

    private Employee applyPatch(Map<String, Object> patchPayload, Employee employee) {
        ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteMethodName(@PathVariable int id) {
        if (employeeService.findById(id) == null)
            throw new EmployeeNotFoundException("Employee id not found - " + id);
        employeeService.deleteById(id);

        return "Deleted employee id - " + id;
    }
}
