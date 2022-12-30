package com.example.carrentaldemo.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="complaint")
public class Complaint{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long complaintid;

    @ManyToOne
    @JoinColumn(name="fromuser",referencedColumnName="userid",insertable = false,updatable = false)
    private User user1;

    @ManyToOne
    @JoinColumn(name="Towardsuser",referencedColumnName="userid",insertable = false,updatable = false)
    private User user2;

    @Column(name="complaint",nullable=false)
    private String complaintMessage;

}