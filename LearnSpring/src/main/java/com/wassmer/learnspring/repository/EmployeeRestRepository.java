package com.wassmer.learnspring.repository;

import com.wassmer.learnspring.model.Employee;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeRestRepository {

    private Logger logger = LoggerFactory.getLogger(EmployeeRestRepository.class);

    private final List<Employee> employeeList = new ArrayList<>();

    public EmployeeRestRepository() {}

    public List<Employee> findAll() {
        return employeeList;
    }

    public Optional<Employee> findById(Integer id) {
        return employeeList.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public void save(Employee employee) {
        logger.trace("Saving employee with id=" + employee.getId());
        employeeList.removeIf(c -> c.getId().equals(employee.getId()));  // delete element if it already exists to avoid duplicates
        employeeList.add(employee);
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

    public boolean existsById(Integer id) {
        return employeeList.stream().filter(c -> c.getId().equals(id)).count() > 0;
    }

    public void delete(Integer id) {
        employeeList.removeIf(c -> c.getId().equals(id));
    }
}
