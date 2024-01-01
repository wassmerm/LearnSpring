package com.wassmer.learnspring.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Employee {

    @NotNull
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
