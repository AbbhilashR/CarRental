package com.example.carrentaldemo.service;

import com.example.carrentaldemo.model.Car;
import com.example.carrentaldemo.model.User;
import com.example.carrentaldemo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService{
    @Autowired
    private CarRepository carRepository;

    public Car createCar(Car car) {
        return carRepository.save(car);
    }
    public List findAllCars(){
        return carRepository.findAll();
    }
}
