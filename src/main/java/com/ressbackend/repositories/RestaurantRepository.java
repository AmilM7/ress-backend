package com.ressbackend.repositories;
import com.ressbackend.models.Type;
import com.ressbackend.models.Restaurant;
import com.ressbackend.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findRestaurantsByLocation(String location);
    List<Restaurant> findRestaurantsByType(String type);
    List<Restaurant> findRestaurantsByIsAccepted(Boolean isAccepted);
    Restaurant findRestaurantByEmail(String email);
}
