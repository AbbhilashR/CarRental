package com.example.carrentaldemo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.carrentaldemo.model.Booking;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking,Long> {
    List<Booking> findAll();
}
