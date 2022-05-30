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
        return restaurantService.getRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable long id) {
        return restaurantService.getById(id);
    }

    @GetMapping("/clubs")
    public List<Restaurant> getClubs() {
        return restaurantService.getOnlyClubs();
    }

    @GetMapping("/notAccepted")
    public List<Restaurant> getUnAccepted(){
        return restaurantService.findNotAcceptedRestaurants();
    }


    @GetMapping("/location/{location}")
    public List<Restaurant> getByLocation(@PathVariable String location) {
        return restaurantService.getByLocation(location);
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }

    @DeleteMapping("/{id}")
    public void  deleteRestaurant(@PathVariable long id) {
        restaurantService.deleteById(id);
    }

}





