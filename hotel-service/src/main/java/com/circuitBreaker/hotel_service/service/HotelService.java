package com.circuitBreaker.hotel_service.service;


import com.circuitBreaker.hotel_service.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService implements IHotelService {

    List<Hotel> hotelsList = new ArrayList<Hotel>();


    @Override
    public List<Hotel> getHotelsByCityId(Long cityId) {

        List<Hotel> hotelCityList = new ArrayList<Hotel>();

        //carga la db logica
        this.loadHotels();
        //busca si coincide la id
        for(Hotel h:hotelsList){
            if(h.getCityId()==cityId){
                hotelCityList.add(h);
            }
        }


        //devuelve la lista
        return hotelCityList;
    }

    public void loadHotels(){

        hotelsList.add(new Hotel(1L, "paradise", 5, 1L));
        hotelsList.add(new Hotel(2L, "sunset view", 4, 2L));
        hotelsList.add(new Hotel(3L, "ocean breeze", 3, 3L));
        hotelsList.add(new Hotel(4L, "mountain retreat", 4, 1L));
        hotelsList.add(new Hotel(5L, "city light inn", 4, 2L));
        hotelsList.add(new Hotel(6L, "riverside lodge", 3, 3L));
        hotelsList.add(new Hotel(7L, "cozy cabin", 2, 1L));
        hotelsList.add(new Hotel(8L, "luxury", 3, 2L));
        hotelsList.add(new Hotel(9L, "historic grand hotel", 1, 3L));
        hotelsList.add(new Hotel(10L, "tranquil gardens", 5, 1L));

    }
}
