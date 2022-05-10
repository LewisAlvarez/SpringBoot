package com.bike.service.bike.service;

import com.bike.service.bike.entity.Bike;
import com.bike.service.bike.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> getBikeLits(){
        return  bikeRepository.findAll();
    }

    public Optional<Bike> getBikeById(int id){
        return bikeRepository.findById(id);
    }
    public List<Bike> createBikes(List<Bike> bikesToCreate){
        List<Bike> bikes = new ArrayList<>();
        bikesToCreate.forEach(bike ->  bikes.add(bikeRepository.save(bike)));
        return bikes;
    }

    /**Obtinene los motos que tiene un usuario by id **/
    public List<Bike> getBikesByUserId(int userId){
        return bikeRepository.findByUserId(userId);
    }
}
