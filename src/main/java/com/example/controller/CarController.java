package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.CarService;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/api/cars/available")
    public List<Map<String, Object>> getAvailableCars() {

        System.out.println("Fetching available cars");

        return carService.getAvailableCars();
    }
}