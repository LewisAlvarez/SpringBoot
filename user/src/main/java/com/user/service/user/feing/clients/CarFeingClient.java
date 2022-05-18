package com.user.service.user.feing.clients;

import com.user.service.user.models.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Se crea una interfaz  con feing client indicamos el nombre del servicio y la url del servicio con el que nos queremos comunicar
 * En esta interfaz escribimos los mismos métodos para acceder a los request en el otro microservicio
 */
@FeignClient(name="car-service")
@RequestMapping("/car")
public interface CarFeingClient {

    /**
     * El objetivo del método es crear un carro desde el microservicio de usuario
     * @param cars - Los carros que se quiere guardar
     * @return el carro guardado
     */
    @PostMapping()
    public List<Car> save(@RequestBody List<Car> cars);
}
