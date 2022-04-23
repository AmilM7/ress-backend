package com.ressbackend.services;
import com.ressbackend.models.Restaurant;
import com.ressbackend.models.Type;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Please be aware that names restaurants and catering facilities are used interchangeably
@Service
public class RestaurantService {

    private final List<Restaurant> restaurantList;

    public RestaurantService(List<Restaurant> restaurantList) {
        this.restaurantList = new ArrayList<>();
        this.restaurantList.add(generateRestaurant1());
        this.restaurantList.add(generateRestaurant2());
    }


    public List<Restaurant> getRestaurants() {
        return this.restaurantList;
    }

    public Restaurant getById(long id) {
        for (Restaurant restaurant: this.restaurantList) {
            if (restaurant.getId() == id) {
                return restaurant;
            }
        }
        throw new RuntimeException("Value not find provided id"  + id);
    }

    public List<Restaurant> getOnlyClubs() {
        List<Restaurant> clubList = new ArrayList<>();
        for (Restaurant club: this.restaurantList) {
            if (club.getType()==Type.club) {
                clubList.add(club);
            }
        }
        return  clubList;
    }

    public List<Restaurant> getByLocation(String location) {
        List<Restaurant> list = new ArrayList<>();
        for (Restaurant restaurant: this.restaurantList) {
            if (restaurant.getLocation().equals(location)) {
                list.add(restaurant);
            }
        }
        return  list;
    }

    public Restaurant createRestaurant(Restaurant restaurant){
        long id = this.restaurantList.size()+1;
        restaurant.setId(id);
        this.restaurantList.add(restaurant);
        return restaurant;
    }

    public String deleteById (long id) {
        for (Restaurant restaurant: this.restaurantList) {
            if (restaurant.getId()==id) {
                this.restaurantList.remove(restaurant);
            }
        }
        return "Restaurant with number ID " + id + " deleted.";
    }





    private Restaurant generateRestaurant1 (){
        Restaurant restaurant = new Restaurant();
        restaurant.setId(1);
        restaurant.setName("RES1");
        restaurant.setLocation("Juraja Cizme 8");
        restaurant.setNumOfAvailGuests(30);
        restaurant.setNumOfAvailtables(10);
        restaurant.setRessDescription("Vey good restaurant with perfect party");
        restaurant.setContactNum("061909786");
        restaurant.setContactManager("061999888");
        restaurant.setStartTime(10,0,0);
        restaurant.setEndTime(23,0,0);
        restaurant.setEmail("employee1@restaurant1.com");
        restaurant.setType(Type.club);
        restaurant.setPassword("Password123");
        return restaurant;
    }

    private Restaurant generateRestaurant2 (){
        Restaurant restaurant = new Restaurant();
        restaurant.setId(2);
        restaurant.setName("RES2");
        restaurant.setLocation("Juraja Asme 9");
        restaurant.setNumOfAvailGuests(20);
        restaurant.setNumOfAvailtables(5);
        restaurant.setRessDescription("Vey good restaurant with the best food in the town");
        restaurant.setContactNum("061909788");
        restaurant.setContactManager("061980888");
        restaurant.setStartTime(9,0,0);
        restaurant.setEndTime(10,0,0);
        restaurant.setEmail("employee2@restaurant2.com");
        restaurant.setType(Type.restaurant);
        restaurant.setPassword("Password123");
        return restaurant;
    }
}