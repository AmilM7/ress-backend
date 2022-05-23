package com.ressbackend.data;

import com.ressbackend.models.Restaurant;
import com.ressbackend.models.Type;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantTest {

    public static Restaurant restaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(100L);
        restaurant.setName("RES100");
        restaurant.setLocation("JurajaCizme100");
        restaurant.setNumOfAvailGuests(30);
        restaurant.setNumOfAvailTables(10);
        restaurant.setRessDescription("Vey good restaurant with perfect party");
        restaurant.setContactNum("061909786");
        restaurant.setContactManager("061999888");
        restaurant.setStartTime(10, 0, 0);
        restaurant.setEndTime(23, 0, 0);
        restaurant.setEmail("employee1@restaurant1.com");
        restaurant.setType(Type.restaurant);
        restaurant.setPassword("Password123");
        return restaurant;
    }

    public static Restaurant club() {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(101L);
        restaurant.setName("RES100");
        restaurant.setLocation("Juraja Cizme 100");
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
}






