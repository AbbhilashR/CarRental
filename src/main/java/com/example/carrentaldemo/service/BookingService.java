package com.example.carrentaldemo.service;

import com.example.carrentaldemo.model.Booking;
import com.example.carrentaldemo.model.User;
import com.example.carrentaldemo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List getAllBookings(){
        return this.bookingRepository.findAll();
    }

    public Booking createBooking(Booking booking) {
        Booking booking1=this.bookingRepository.save(booking);
        return bookingRepository.save(booking1);
    }
}
