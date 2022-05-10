package com.bike.service.bike.controller;

import com.bike.service.bike.entity.Bike;
import com.bike.service.bike.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @Value("${message}")
    private String message;

    @GetMapping("/bikes")
    public ResponseEntity<List<Bike>> getAllBikes(){
        return bikeService.getBikeLits().isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(bikeService.getBikeLits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getBikeById(@PathVariable("id") int bikeId){
        Optional<Bike> bikeOp = bikeService.getBikeById(bikeId);
        return bikeOp.isPresent()
                ? ResponseEntity.ok(bikeOp.get())
                : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<List<Bike>> saveBike(@RequestBody List<Bike> bikesToAdd){
        List<Bike> bikes = bikeService.createBikes(bikesToAdd);
        System.out.println(message);
        return ResponseEntity.ok(bikes);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Bike>> getBikeByUserId(@PathVariable("userId") int userId){
        List<Bike> bikeOp = bikeService.getBikesByUserId(userId);
        return bikeOp.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(bikeOp);
    }
}
