package com.user.service.user.feing.clients;

import com.user.service.user.models.Bike;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public List<Bike> saveBikes(@RequestBody List<Bike> bikes);
}
