package com.wassmer.learnspring.repository;

import com.wassmer.learnspring.model.Employee;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface EmployeeDbRepository extends ListCrudRepository<Employee, Integer> {
    List<Employee> findAllByNameContainsIgnoreCase(String keyword);

}
