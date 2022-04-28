package com.ressbackend.controllers;

import com.ressbackend.models.Restaurant;
import com.ressbackend.services.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping()
    public List<Restaurant> getRestaurants() {
        return this.restaurantService.getRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable long id) {
        return this.restaurantService.getById(id);
    }

    @GetMapping("/clubs")
    public List<Restaurant> getClubs() {
        return this.restaurantService.getOnlyClubs();
    }

    @GetMapping("/location/{location}")
    public List<Restaurant> getByLocation(@PathVariable String location) {
        return this.restaurantService.getByLocation(location);
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return this.restaurantService.createRestaurant(restaurant);
    }

    @DeleteMapping("/{id}")
    public String deleteRestaurant(@PathVariable long id) {
        return this.restaurantService.deleteById(id);
    }


}





