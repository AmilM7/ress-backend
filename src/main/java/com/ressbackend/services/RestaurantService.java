package com.ressbackend.services;

import com.ressbackend.models.Restaurant;
import com.ressbackend.models.Type;
import com.ressbackend.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Please be aware that names restaurants and catering facilities are used interchangeably
@Service
public class RestaurantService {

    private final List<Restaurant> restaurantList;
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantList = new ArrayList<>();
        this.restaurantList.add(generateRestaurant1());
        this.restaurantList.add(generateRestaurant2());
    }

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getById(long id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (restaurantOptional.isPresent()) return restaurantOptional.get();
        throw new RuntimeException("Value not find with provided id: " + id);
    }

    public List<Restaurant> getOnlyClubs() {
        return restaurantRepository.findRestaurantsByType(String.valueOf(Type.club));
    }

    public List<Restaurant> getByLocation(String location) {
        return restaurantRepository.findRestaurantsByLocation(location);
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        restaurant.setAccepted(false);
        return restaurantRepository.save(restaurant);
    }
    public void deleteById(long id) {
        restaurantRepository.deleteById(id);
    }

    public List<Restaurant> findNotAcceptedRestaurants (){
        return restaurantRepository.findRestaurantsByIsAccepted(false);
    }

    private Restaurant generateRestaurant1() {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(1);
        restaurant.setName("RES1");
        restaurant.setLocation("Juraja Cizme 8");
        restaurant.setNumOfAvailGuests(30);
        restaurant.setNumOfAvailTables(10);
        restaurant.setRessDescription("Vey good restaurant with perfect party");
        restaurant.setContactNum("061909786");
        restaurant.setContactManager("061999888");
        restaurant.setStartTime(10, 0, 0);
        restaurant.setEndTime(23, 0, 0);
        restaurant.setEmail("employee1@restaurant1.com");
        restaurant.setType(Type.club);
        restaurant.setPassword("Password123");
        return restaurant;
    }

    private Restaurant generateRestaurant2() {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(2);
        restaurant.setName("RES2");
        restaurant.setLocation("Juraja Asme 9");
        restaurant.setNumOfAvailGuests(20);
        restaurant.setNumOfAvailTables(5);
        restaurant.setRessDescription("Vey good restaurant with the best food in the town");
        restaurant.setContactNum("061909788");
        restaurant.setContactManager("061980888");
        restaurant.setStartTime(9, 0, 0);
        restaurant.setEndTime(10, 0, 0);
        restaurant.setEmail("employee2@restaurant2.com");
        restaurant.setType(Type.restaurant);
        restaurant.setPassword("Password123");
        return restaurant;
    }
}