package com.example.carrentaldemo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class DummyUser {
    @NotNull(message = "User name cannot be empty")
    private String name;

    @NotNull(message = "Password cannot be empty")
    private String password;
    @Id
    private Long id;

}