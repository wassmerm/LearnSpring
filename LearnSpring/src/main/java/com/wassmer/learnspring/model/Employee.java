package com.wassmer.learnspring.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Employee {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    @NotBlank
    private String name;

    public Employee() {}

    public Employee(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }

}
