package com.user.service.user.service;

import com.user.service.user.entity.User;
import com.user.service.user.feing.clients.BikeFeingClient;
import com.user.service.user.feing.clients.CarFeingClient;
import com.user.service.user.models.Bike;
import com.user.service.user.models.Car;
import com.user.service.user.models.UserDto;
import com.user.service.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final static String URL_MICRO_CARS = "http://localhost:8002/car/user/";
    private final static String URL_MICRO_BIKES = "http://localhost:8003/bike/user/";

    @Autowired
    private UserRepository userRepository;

    /**Se inyecta el RestTemplate creado en la Clase configuration**/
    @Autowired
    private RestTemplate restTemplate;

    /**Se inyecta la interface de feingclient que tiene la comunicacion con el microservice de carro**/
    @Autowired
    private CarFeingClient carFeingClient;

    /**Se inyecta la interface de feingclient que tiene la comunicacion con el microservice de motos**/
    @Autowired
    private BikeFeingClient bikeFeingClient;

    public List<Car> getCars(int userId){
        /**El sgte método hace una pétición dada una url, en este caso la url del micro servicio de carros**/
        List<Car> userCars =
                restTemplate.getForObject(URL_MICRO_CARS+userId, List.class);
        return userCars;
    }

    public List<Bike> getBikes(int userId){
        /**El sgte método hace una pétición dada una url, en este caso la url del micro servicio de motos**/
        List<Bike> userBikes =
                restTemplate.getForObject(URL_MICRO_BIKES+userId, List.class);
        return userBikes;
    }

    /**
     * Este método se encarga de crear un carro a un usuario determinado dado su id desde el microservicio usuario
     * @param userId Id del usuario al que se le quiere crear el carro
     * @param cars EL carro a crear
     * @return El carro creado
     */
    public List<Car> createCar(int userId, List<Car> cars){
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()){
            cars.forEach(car -> car.setUserId(userId));
            List<Car> newCars = carFeingClient.save(cars);
            return newCars;
        }
        return null;
    }

    /**
     * Lo mismo que el método anterior pero con bikes
     * @param userId
     * @param bikes
     * @return
     */

    public List<Bike> createBikes(int userId, List<Bike> bikes){
        if (userRepository.findById(userId).isPresent()) {
            bikes.forEach(bike -> bike.setUserId(userId));
            return bikeFeingClient.saveBikes(bikes);
        }
        return null;
    }

    /**
     * Este método retorna la información de un cliente y de sus vehiculos asociados (bikes, cars) usando los metodos que usn rest template
     * @param userId el id del usuario a buscar
     * @return
     */
    public UserDto getFullUserInformation(int userId){
        Optional<User> userOp = userRepository.findById(userId);
        if (userOp.isPresent()){
            List<Car> cars = getCars(userId);
            List<Bike> bikes = getBikes(userId);

            User user = userOp.get();
            UserDto userDto = new UserDto();

            userDto.setName(user.getName());
            userDto.setEmail(user.getEmail());
            userDto.setCars(cars);
            userDto.setBikes(bikes);

            return userDto;
        }
        return null;
    }

    public List<User> getUserLits(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id){
        return userRepository.findById(id);
    }

    public void createUsers(List<User> usersToCreate){
        usersToCreate.forEach(user -> userRepository.save(user));
    }

}
