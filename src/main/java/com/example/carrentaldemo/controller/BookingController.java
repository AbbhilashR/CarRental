package com.example.carrentaldemo.controller;


import com.example.carrentaldemo.model.Booking;
import com.example.carrentaldemo.model.User;
import com.example.carrentaldemo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public List getAllUsers(){
        return bookingService.getAllBookings();
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> createBookings(Booking booking){
        Booking savedUser = bookingService.createBooking(booking);
        System.out.println(savedUser);
        return new ResponseEntity<Booking>(savedUser, HttpStatus.OK);
    }
}
