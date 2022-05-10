package com.user.service.user.controller;

import com.user.service.user.entity.User;
import com.user.service.user.models.Bike;
import com.user.service.user.models.Car;
import com.user.service.user.models.UserDto;
import com.user.service.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${message}")
    private String message;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return userService.getUserLits().isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(userService.getUserLits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int userId){
        Optional<User> userOp = userService.getUserById(userId);
        return userOp.isPresent()
                ? ResponseEntity.ok(userOp.get())
                : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity saveUser(@RequestBody List<User> usersToAdd){
        userService.createUsers(usersToAdd);
        System.out.println(message);
        return ResponseEntity.ok().build();
    }

    /**
     * Resquest que se comunica con el otro microservicio de carros, obtiene los carros de un usuario, desde el microservicio user
     * @param userId- id del usuario
     * @return NotFound si el usuario no existe, la lista de carros si el usuario tiene carros
     */

    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<Car>> getCarsForUser(@PathVariable("userId") int userId){
        if(userService.getUserById(userId).isEmpty())
            return ResponseEntity.notFound().build();

        List<Car> cars = userService.getCars(userId);
        return cars == null
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(cars);
    }

    /**
     * Resquest que se comunica con el otro microservicio de carros, obtiene los carros de un usuario, desde el microservicio user
     * @param userId- id del usuario
     * @return NotFound si el usuario no existe, la lista de carros si el usuario tiene carros
     */

    @GetMapping("/bikes/{userId}")
    public ResponseEntity<List<Bike>> getBikesForUser(@PathVariable("userId") int userId){
        if(userService.getUserById(userId).isEmpty())
            return ResponseEntity.notFound().build();

        List<Bike> bikes = userService.getBikes(userId);
        return bikes == null
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(bikes);
    }

    @GetMapping("/full/{userId}")
    public ResponseEntity<UserDto> getFullUser(@PathVariable("userId") int userId){
        UserDto userDto = userService.getFullUserInformation(userId);
        return userDto != null
                ? ResponseEntity.ok(userDto)
                : ResponseEntity.notFound().build();
    }

    /**
     *
     *Uso de FeingCLient para crear bikes y cars desde el microservicio de user
     */

    @PostMapping("/car/{userId}")
    public ResponseEntity<List<Car>> saveCarToUser(@PathVariable("userId") int userId, @RequestBody List<Car> cars){
        List<Car> newCars = userService.createCar(userId, cars);
        return newCars == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(newCars);
    }

    @PostMapping("/bike/{userId}")
    public ResponseEntity<List<Bike>> saveBikesToUser(@PathVariable("userId") int userId, @RequestBody List<Bike> bikes){
        List<Bike> newBikes = userService.createBikes(userId, bikes);
        return newBikes == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(newBikes);
    }

}
