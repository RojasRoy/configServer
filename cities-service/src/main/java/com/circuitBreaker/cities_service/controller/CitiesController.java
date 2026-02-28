package com.circuitBreaker.cities_service.controller;

import com.circuitBreaker.cities_service.dto.CityDTO;
import com.circuitBreaker.cities_service.service.ICitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @Autowired
    private ICitiesService servCity;

    @GetMapping("/hotel")
    public CityDTO getCityAndHotel(@RequestParam String name,
                                   @RequestParam String country){
        return servCity.getCitiesHotels(name, country);
    }

}
