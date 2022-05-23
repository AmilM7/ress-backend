package com.ressbackend.services;
import com.ressbackend.data.ReservationTest;
import com.ressbackend.data.RestaurantTest;
import com.ressbackend.models.Reservation;
import com.ressbackend.models.Restaurant;
import com.ressbackend.models.Type;
import com.ressbackend.repositories.ReservationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class ReservationServiceUnitTest {

    @MockBean
    private ReservationRepository reservationRepository;

    @TestConfiguration
    static class ReservationServiceTestContextConfiguration {

        @Bean
        @Primary
        public ReservationService reservationService(ReservationRepository reservationRepository) {
            return new ReservationService(reservationRepository);
        }
    }

    @Autowired
    private ReservationService reservationService;

    @Test
    public void givenReservations_whenGetReservations_thenListShouldBeFound() {
        Mockito.when(reservationRepository.findAll())
                .thenReturn(List.of(ReservationTest.reservation()));

        List<Reservation> returnedList = reservationService.getReservation();
        assertThat(returnedList).hasSize(1);
    }

    @Test
    public void givenNoReservations_whenGetReservations_thenListShouldBeEmpty() {
        assertThat(reservationService.getReservation()).isEmpty();
    }

    @Test
    public void givenValidId_whenGetById_thenReservationShouldBeFound() {
        Reservation reservation = ReservationTest.reservation();
        Mockito.when(reservationRepository.findById(reservation.getId()))
                .thenReturn(Optional.of(reservation));
        Reservation resultReservation = reservationService.getById(reservation.getId());
        assertThat(resultReservation.getUserFirstName())
                .isEqualTo(reservation.getUserFirstName());
    }

    @Test
    public void givenInvalidId_whenGetById_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> reservationService.getById(1L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Value not find with provided id");
    }

    @Test
    public void givenReservation_whenCreate_thenRepositoryCalled() {
        Reservation reservation = ReservationTest.reservation();
        reservationService.createReservation(reservation);
        verify(reservationRepository, times(1)).save(reservation);
    }

    @Test
    public void givenReservation_whenCreate_thenIdAssigned() {
        Reservation inputReservation = ReservationTest.reservation();
        inputReservation.setId(0L);
        Reservation outputreservation = ReservationTest.reservation();
        Mockito.when(reservationRepository.save(inputReservation))
                .thenReturn(outputreservation);
        Reservation resultReservation = reservationService.createReservation(inputReservation);
        assertThat(resultReservation.getId()).isNotEqualTo(0L);
    }

    @Test
    public void givenReservation_whenCreate_thenReservationReturned() {
        Reservation inputReservation = ReservationTest.reservation();
        inputReservation.setId(0L);
        Reservation outputReservation = ReservationTest.reservation();

        Mockito.when(reservationRepository.save(inputReservation))
                .thenReturn(outputReservation);

        Reservation resultReservation = reservationService.createReservation(inputReservation);

        assertThat(resultReservation).isNotNull();
        assertThat(resultReservation.getUserFirstName()).isEqualTo(inputReservation.getUserFirstName());
    }

    @Test
    public void givenReservation_whenDelete_thenRepositoryCalled() {
        long id = 2L;
        reservationService.deleteReservation(id);
        verify(reservationRepository, times(1)).deleteById(id);
    }

    @Test
    public void givenValidReservationUsername_whenGetByUsername_thenReservationShouldBeFound() {
        Mockito.when(reservationRepository.findReservationsByUsername("Amil"))
                .thenReturn(List.of(ReservationTest.reservation()));
        List<Reservation> returnedList = reservationService.getByUsername("Amil");
        assertThat(returnedList).hasSize(1);
    }

    @Test
    public void givenValidReservationDay_whenGetByDay_thenReservationShouldBeFound() {
        Mockito.when(reservationRepository.findReservationsByDay("Monday"))
                .thenReturn(List.of(ReservationTest.reservation()));
        List<Reservation> returnedList = reservationService.getByDay("Monday");
        assertThat(returnedList).hasSize(2);
    }










}

