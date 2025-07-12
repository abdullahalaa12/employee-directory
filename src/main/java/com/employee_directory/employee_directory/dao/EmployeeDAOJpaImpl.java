package com.employee_directory.employee_directory.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.employee_directory.employee_directory.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    // if id==0 then save/insert else update
    @Override
    public Employee save(Employee employee) {
        // save or update the employee
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        Employee emp = findById(id);
        entityManager.remove(emp);
    }

}
