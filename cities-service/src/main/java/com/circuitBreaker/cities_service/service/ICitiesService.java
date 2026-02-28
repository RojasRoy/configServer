package com.circuitBreaker.cities_service.service;

import com.circuitBreaker.cities_service.dto.CityDTO;

public interface ICitiesService {

    public CityDTO getCitiesHotels(String name, String country);

}
