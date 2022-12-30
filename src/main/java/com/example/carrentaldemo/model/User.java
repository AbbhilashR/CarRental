package com.example.carrentaldemo.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="user")
public class  User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;

    @NotNull(message = "Name Should not be null")
    @Column(name="username")
    private String username;

    @Column(name="address")
    private String address;


    @Column(name="age")
    private int age;


    @Column(name="phonenumber")
    private long phoneNumber;


    @Column(name="email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="roleid")
    private Role role;


    @OneToMany(mappedBy="user")
    private Set<Car> car;

    @OneToMany(mappedBy="user",fetch = FetchType.LAZY)
    private Set<Booking> booking;

//    @OneToOne(mappedBy="user",fetch = FetchType.LAZY)
//    private License license;

    @OneToMany(mappedBy = "user1",fetch = FetchType.LAZY)
    private List<Complaint> user1;

    @OneToMany(mappedBy = "user2",fetch = FetchType.LAZY)
    private List<Complaint> user2;


}
