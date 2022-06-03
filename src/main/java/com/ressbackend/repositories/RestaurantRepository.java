package com.ressbackend.repositories;

import com.ressbackend.models.Type;
import com.ressbackend.models.Restaurant;
import com.ressbackend.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findRestaurantsByLocation(String location);

    List<Restaurant> findRestaurantsByType(String type);

    List<Restaurant> findRestaurantsByIsAccepted(Boolean isAccepted);

    Restaurant findRestaurantByEmail(String email);

    @Query(
            value = "select  p.*  from restaurant p, reservation t where p.id=t.restaurant group by p.id order by count(t.restaurant) desc limit 3",
            nativeQuery = true)
    List<Restaurant> findMostlyReservedRestaurants();

    @Query(
            value = "select * from restaurant order by random() limit 3;",
            nativeQuery = true)
    List<Restaurant> findThreeSugesstedRestaurants();
}
