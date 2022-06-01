package com.ressbackend.controllers;

import com.ressbackend.models.Restaurant;
import com.ressbackend.models.Users;
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

    @PutMapping("/update/{email}")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable String email) {
        restaurant.setAccepted(true);
        return restaurantService.updateRestauranttoAccepted(restaurant,email);
    }

    @GetMapping("/location/{location}")
    public List<Restaurant> getByLocation(@PathVariable String location) {
        return restaurantService.getByLocation(location);
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }

    @DeleteMapping("/delete/{email}")
    public void deleteRestaurant (@PathVariable String email){
        Restaurant restaurant = restaurantService.getByEmail(email);
        restaurantService.deleteById(restaurant.getId());
    }


}





