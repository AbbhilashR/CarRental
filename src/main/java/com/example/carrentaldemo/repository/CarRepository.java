package com.example.carrentaldemo.repository;

import com.example.carrentaldemo.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepository extends CrudRepository<Car,Long> {
    List<Car> findAll();
}
