package com.ressbackend.services;
import com.ressbackend.data.RestaurantTest;
import com.ressbackend.models.Restaurant;
import com.ressbackend.models.Type;
import com.ressbackend.repositories.RestaurantRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
public class RestaurantServiceUnitTest {

    @MockBean
    private RestaurantRepository restaurantRepository;

    @TestConfiguration
    static class RestaurantServiceTestContextConfiguration {

        @Bean
        @Primary
        public RestaurantService restaurantService(RestaurantRepository restaurantRepository) {
            return new RestaurantService(restaurantRepository);
        }
    }

    @Autowired
    private RestaurantService restaurantService;

    @Test
    public void givenRestaurants_whenGetRestaurants_thenListShouldBeFound() {
        Mockito.when(restaurantRepository.findAll())
                .thenReturn(List.of(RestaurantTest.restaurant()));

        List<Restaurant> returnedList = restaurantService.getRestaurants();
        assertThat(returnedList).hasSize(1);
    }

    @Test
    public void givenNoRestaurants_whenGetRestaurants_thenListShouldBeEmpty() {
        assertThat(restaurantService.getRestaurants()).isEmpty();
    }

    @Test
    public void givenValidId_whenGetById_thenRestaurantShouldBeFound() {
        Restaurant restaurant = RestaurantTest.restaurant();
        Mockito.when(restaurantRepository.findById(restaurant.getId()))
                .thenReturn(Optional.of(restaurant));
        Restaurant resultRestaurant = restaurantService.getById(restaurant.getId());
        assertThat(resultRestaurant.getName())
                .isEqualTo(restaurant.getName());
    }

    @Test
    public void givenInvalidId_whenGetById_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> restaurantService.getById(100L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Value not find with provided id");
    }

    @Test
    public void givenRestaurant_whenCreate_thenRepositoryCalled() {
        Restaurant restaurant = RestaurantTest.restaurant();
        restaurantService.createRestaurant(restaurant);
        verify(restaurantRepository, times(1)).save(restaurant);
    }

    @Test
    public void givenClubs_whenGetOnlyClubs_thenListShouldBeFound() {
        Mockito.when(restaurantRepository.findRestaurantsByType(String.valueOf(Type.club)))
                .thenReturn(List.of(RestaurantTest.club()));
        List<Restaurant> returnedList = restaurantService.getOnlyClubs();
        assertThat(returnedList).hasSize(1);
    }

    @Test
    public void givenRestaurant_whenCreate_thenIdAssigned() {
        Restaurant inputRestaurant = RestaurantTest.restaurant();
        inputRestaurant.setId(0L);
        Restaurant outputrestaurant = RestaurantTest.restaurant();
        Mockito.when(restaurantRepository.save(inputRestaurant))
                .thenReturn(outputrestaurant);
        Restaurant resultRestaurant = restaurantService.createRestaurant(inputRestaurant);
        assertThat(resultRestaurant.getId()).isNotEqualTo(0L);
    }

    @Test
    public void givenRestaurant_whenCreate_thenRestaurantReturned() {
        Restaurant inputRestaurant = RestaurantTest.restaurant();
        inputRestaurant.setId(0L);
        Restaurant outputRestaurant = RestaurantTest.restaurant();

        Mockito.when(restaurantRepository.save(inputRestaurant))
                .thenReturn(outputRestaurant);

        Restaurant resultRestaurant = restaurantService.createRestaurant(inputRestaurant);

        assertThat(resultRestaurant).isNotNull();
        assertThat(resultRestaurant.getName()).isEqualTo(inputRestaurant.getName());
    }

    @Test
    public void givenRestaurant_whenDelete_thenRepositoryCalled() {
        long id = 2L;
        restaurantService.deleteById(id);
        verify(restaurantRepository, times(1)).deleteById(id);
    }

    @Test
    public void givenValidRestaurant_whenGetByLocation_thenRestaurantsShouldBeFound() {
        Mockito.when(restaurantRepository.findRestaurantsByLocation("JurajaCizme100"))
                .thenReturn(List.of(RestaurantTest.restaurant()));
        List<Restaurant> returnedList = restaurantService.getByLocation("JurajaCizme100");
        assertThat(returnedList).hasSize(1);
    }











}

