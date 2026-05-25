package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.model.Booking;
import com.example.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public String bookCar(@RequestBody Booking booking) {

        System.out.println("Controller Hit");

        return bookingService.bookCar(booking);
    }
}