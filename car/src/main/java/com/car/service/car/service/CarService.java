package com.car.service.car.service;

import com.car.service.car.entity.Car;
import com.car.service.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getCarLits(){
        return  carRepository.findAll();
    }

    public Optional<Car> getCarById(int id){
        return carRepository.findById(id);
    }

    public List<Car>  createCars(List<Car> carsToCreate){
        List<Car> cars = new ArrayList<>();
        carsToCreate.forEach(car ->  cars.add(carRepository.save(car)));
        return cars;
    }

    /**Obtinene los carros que tiene un usuario by id **/
    public List<Car> getCarsByUserId(int userId){
        return carRepository.findByUserId(userId);
    }

}
