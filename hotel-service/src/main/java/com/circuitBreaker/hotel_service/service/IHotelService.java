package com.circuitBreaker.hotel_service.service;

import com.circuitBreaker.hotel_service.model.Hotel;

import java.util.List;

public interface IHotelService {

    List<Hotel> getHotelsByCityId(Long cityId);

}
