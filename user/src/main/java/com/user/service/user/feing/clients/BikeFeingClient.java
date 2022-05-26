package com.user.service.user.feing.clients;

import com.user.service.user.models.Bike;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "bike-service")
@RequestMapping("/bike")
public interface BikeFeingClient {

    /**
     * Guarda bikes desde la clase usuarios comunicandose con el micro de bikes
     * @param bikes
     * @return
     */
    @PostMapping
    List<Bike> saveBikes(@RequestBody List<Bike> bikes);

    /**
     * Método para obtener los motos de un usuario desde usuario
     * @param userId
     * @return
     */
    @GetMapping("/user/{userId}")
    List<Bike> getBikes(@PathVariable("userId") int userId);
}

