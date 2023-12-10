package com.wassmer.learnspring.service;

import com.wassmer.learnspring.model.Employee;
import com.wassmer.learnspring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee, Long employeeId) {
        Employee employeeDB = employeeRepository.findById(employeeId).get();

        if (Objects.nonNull(employee.getName()) && !"".equalsIgnoreCase(employee.getName())) {
            employeeDB.setName(employee.getName());
        }

        return employeeRepository.save(employeeDB);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}