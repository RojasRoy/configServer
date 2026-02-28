package com.circuitBreaker.cities_service.repository;

import com.circuitBreaker.cities_service.dto.HotelDTO;
import org.springframework.cloud.loadbalancer.core.LoadBalancerServiceInstanceCookieTransformer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "hotel-service")
public interface IHotelAPI {

    @GetMapping("hotel/{cityId}")
    public List<HotelDTO> getHotelCityById(@PathVariable("cityId") Long cityId);
}
