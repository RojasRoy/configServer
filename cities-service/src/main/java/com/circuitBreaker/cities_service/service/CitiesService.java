package com.circuitBreaker.cities_service.service;

import com.circuitBreaker.cities_service.dto.CityDTO;
import com.circuitBreaker.cities_service.model.Cities;
import com.circuitBreaker.cities_service.repository.IHotelAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CitiesService implements ICitiesService{

    @Autowired
    private IHotelAPI hotelAPI;

    List<Cities> cities = new ArrayList<Cities>();


    @Override
    @CircuitBreaker(name = "hotel-service", fallbackMethod = "fallBackCitiesHotel")
    @Retry(name ="hotel-service")
    public CityDTO getCitiesHotels(String name, String country) {

        //buscamos ciudad original
        Cities city = this.findCities(name, country);

        //creamos el dto de la ciudad + los hoteles
        CityDTO cityDTO = new CityDTO();
        cityDTO.setCityId(city.getCityId());
        cityDTO.setName(city.getName());
        cityDTO.setCountry(city.getCountry());
        cityDTO.setContinent(city.getContinent());
        cityDTO.setState(city.getState());

        //buscamos la lista de hoteles en la API y asignamos
        cityDTO.setHotelList(hotelAPI.getHotelCityById(city.getCityId()));

        //createException();

        return cityDTO;
    }

    public void createException(){
        throw new IllegalArgumentException("Prueba resilience y circuit breaker");
    }

    public CityDTO fallBackCitiesHotel(String name, String country, Throwable t){
        return  new CityDTO(99999999999L,"Fallido","Fallido", "Fallido", "Fallido", null);
    }

    public Cities findCities(String name, String country){
        this.loadCities();
        for (Cities c:cities) {
            if(c.getName().equals(name)){
                if (c.getCountry().equals(country)){
                    return c;
                }
            }
        }
        return null;
    }

    public void loadCities(){

        cities.add(new Cities(1L, "buenos aires", "america del sur", "Argentina", "Buenos aire" ));
        cities.add(new Cities(2L, "corrientes", "america del sur", "Argentina", "Buenos aire" ));
        cities.add(new Cities(3L, "santa fe", "america del sur", "Argentina", "Buenos aire" ));
        cities.add(new Cities(4L, "formosa", "america del sur", "Argentina", "Buenos aire" ));
        cities.add(new Cities(5L, "chubut", "america del sur", "Argentina", "Buenos aire" ));

    }

}
