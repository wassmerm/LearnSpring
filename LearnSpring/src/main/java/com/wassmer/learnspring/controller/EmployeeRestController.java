package com.wassmer.learnspring.controller;


import com.wassmer.learnspring.model.Employee;
import com.wassmer.learnspring.repository.EmployeeRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private final EmployeeRestRepository employeeRepository;

    @Autowired
    public EmployeeRestController(EmployeeRestRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    };

    @GetMapping("")
    public List<Employee> findAll() { return null;}

    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@RequestParam Integer id) {
        return employeeRepository.findById(id);
    }
}
