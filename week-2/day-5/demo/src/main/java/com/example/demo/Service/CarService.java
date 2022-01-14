package com.example.demo.Service;

import com.example.demo.domain.Car;

import java.util.Optional;

public interface CarService {
    Car saveCar(Car car);
    Optional<Car> findCarById(Long id);
}
