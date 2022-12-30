package com.example.carrentaldemo.controller;


import com.example.carrentaldemo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public List getAllCars(){
        return carService.findAllCars();
    }

}
