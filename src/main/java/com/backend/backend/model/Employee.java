package com.backend.backend.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be empty")
    @Size(min=2, max=30, message = "Name must be ")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Email cannot be empty")
    @Email
    @Column(name = "email")
    private String email;
    
}
