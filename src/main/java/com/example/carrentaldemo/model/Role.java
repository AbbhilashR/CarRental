package com.example.carrentaldemo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="userrole")
public class Role {
    @Id
    @Column(name = "roleid",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role;

    @NotNull
    @Column(name="userrolename")
    private String roleName;
}
