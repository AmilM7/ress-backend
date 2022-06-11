package com.ressbackend.services;

import com.ressbackend.models.Restaurant;
import com.ressbackend.models.Type;
import com.ressbackend.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant getByName(String name) {
        return restaurantRepository.findRestaurantByName(name);
    }

    public Restaurant getByEmail(String email) {
        return restaurantRepository.findRestaurantByEmail(email);
    }

    public Restaurant getById(long id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (restaurantOptional.isPresent()) return restaurantOptional.get();
        throw new RuntimeException("Value not find with provided id: " + id);
    }

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public List<Restaurant> getOnlyClubs() {
        return restaurantRepository.findRestaurantsByType(String.valueOf(Type.club));
    }

    public List<Restaurant> getByLocation(String location) {
        return restaurantRepository.findRestaurantsByLocation(location);
    }

    public List<Restaurant> getMostlyReservedRestaurants() {
        return restaurantRepository.findMostlyReservedRestaurants();
    }

    public List<Restaurant> getSugesstedRestaurants() {
        return restaurantRepository.findThreeSugesstedRestaurants();
    }

    public List<Restaurant> getNotAcceptedRestaurants() {
        return restaurantRepository.findRestaurantsByIsAccepted(false);
    }

    public List<Restaurant> getAcceptedRestaurants() {
        return restaurantRepository.findRestaurantsByIsAccepted(true);
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        restaurant.setAccepted(false);
        return restaurantRepository.save(restaurant);
    }

    public void deleteById(long id) {
        restaurantRepository.deleteById(id);
    }

    public Restaurant updateRestauranttoAccepted(Restaurant restaurant, String email) {
        getByEmail(email);
        restaurant.setAccepted(true);
        return restaurantRepository.save(restaurant);
    }

}
