package com.example.carrentaldemo.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="rating")
public class Rating{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long ratingid;

    @ManyToOne
    @JoinColumn(name="userid",referencedColumnName="userid")
    private User user;

    @OneToOne
    @JoinColumn(name="carid",referencedColumnName="carid")
    private Booking booking;

}
