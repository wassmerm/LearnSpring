package com.wassmer.learnspring.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private Integer id;
    private String name;

    public Employee() {}

    public Employee(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }

}
