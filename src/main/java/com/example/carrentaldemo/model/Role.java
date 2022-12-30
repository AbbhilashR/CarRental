package com.example.carrentaldemo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name ="role")
public class Role {
    @Id
    @Column(name = "roleid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Roleid;

    @NotNull
    @Column(name="rolename")
    private String roleName;
}
