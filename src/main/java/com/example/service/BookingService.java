package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.model.Booking;

@Service
public class BookingService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String bookCar(Booking booking) {

        System.out.println("Service Hit");

        String sql = "INSERT INTO bookings(user_id, car_id, start_date, end_date, status) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                booking.getUserId(),
                booking.getCarId(),
                booking.getStartDate(),
                booking.getEndDate(),
                "CONFIRMED"
        );

        return "Booking Successful";
    }
}