package com.car.service.car.controller;

import com.car.service.car.entity.Car;
import com.car.service.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @Value("${message}")
    private String message;

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars(){
        return carService.getCarLits().isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(carService.getCarLits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") int carId){
        Optional<Car> carOp = carService.getCarById(carId);
        return carOp.isPresent()
                ? ResponseEntity.ok(carOp.get())
                : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<List<Car>> saveCar(@RequestBody List<Car> carsToAdd){
        List<Car> cars = carService.createCars(carsToAdd);
        System.out.println(message);
        return ResponseEntity.ok(cars);
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Car>> getCarsByUserId(@PathVariable("userId") int userId){
        List<Car> carOp = carService.getCarsByUserId(userId);
        return carOp.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(carOp);
    }
}
