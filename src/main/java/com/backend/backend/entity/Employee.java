package com.backend.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Employee {

    @Id
    private long id;

    @Column(name = "name")
    private String name;
    
}
