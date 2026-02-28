package com.circuitBreaker.hotel_service.controller;

import com.circuitBreaker.hotel_service.model.Hotel;
import com.circuitBreaker.hotel_service.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private IHotelService servHotel;

    @GetMapping("/{cityId}")
    public List<Hotel> getHotelsByCityId(@PathVariable Long cityId){
        return servHotel.getHotelsByCityId(cityId);
    }


}
