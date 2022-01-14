package com.example.demo.Service;

import com.example.demo.domain.Car;
import exception.InvalidIdException;

import java.util.Optional;

public class CarServiceImpl implements CarService{
    @Override
    public Car saveCar(Car car) {
        return car;
    }

    @Override
    public Optional<Car> findCarById(Long id) {
        if(id <= 0) throw new InvalidIdException("Id must be positive : "+id);
        return Optional.of(new Car());
    }
}
