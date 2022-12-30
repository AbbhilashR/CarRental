package com.example.carrentaldemo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="license")
class License{
    @Id
    private Long UserId;

    @Column(name="license",nullable=false)
    private String licenseimg;


}