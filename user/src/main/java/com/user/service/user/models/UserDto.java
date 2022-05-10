package com.user.service.user.models;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private String name;
    private String email;
    private List<Car> cars;
    private List<Bike> bikes;
}
