package com.wassmer.learnspring.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wassmer.learnspring.model.Employee;
import com.wassmer.learnspring.repository.EmployeeDbRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeDbRepository repository;
    private final ObjectMapper objectMapper;

    public DataLoader(EmployeeDbRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }
    @Override
    public void run(String... args) throws Exception {
        if(repository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/dbContent.json")) {
                repository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Employee>>(){}));
            }
        }
    }
}
