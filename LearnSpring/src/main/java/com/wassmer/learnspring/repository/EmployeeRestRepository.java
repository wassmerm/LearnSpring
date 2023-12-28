package com.wassmer.learnspring.repository;

import com.wassmer.learnspring.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeRestRepository {

    private final List<Employee> employeeList = new ArrayList<>();

    public EmployeeRestRepository() {}

    public List<Employee> findAll() {
        return employeeList;
    }

    public Optional<Employee> findById(Integer id) {
        return employeeList.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    // methods annotated by @PostConstruct are automatically invoked by Spring once the constructor
    // has been invoked, and once the dependencies have been injected. We are using this concept here
    // to allow us to initialize the repository with some dummy content.
    @PostConstruct
    private void afterInit() {
        Employee e1 = new Employee(1, "Test Employee #1");
        Employee e2 = new Employee(2, "Test Employee #2");
        employeeList.add(e1);
        employeeList.add(e2);
    }

}
