package com.ressbackend.services;
import com.ressbackend.data.EventTest;
import com.ressbackend.models.Event;
import com.ressbackend.models.Type;
import com.ressbackend.repositories.EventRespository;
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
public class EventServiceUnitTest {
    @MockBean
    private EventRespository eventRespository;

    @TestConfiguration
    static class EventServiceTestContextConfiguration {

        @Bean
        @Primary
        public EventService eventService(EventRespository eventRespository) {
            return new EventService(eventRespository);
        }
    }

    @Autowired
    private EventService eventService;

    @Test
    public void givenEvent_whenEventGetEvents_thenListShouldBeFound() {
        Mockito.when(eventRespository.findAll())
                .thenReturn(List.of(EventTest.event()));
        List<Event> returnedList = eventService.getEvents();
        assertThat(returnedList).hasSize(1);
    }


    @Test
    public void givenNoEvents_whenGetEvents_thenListShouldBeEmpty() {
        assertThat(eventService.getEvents()).isEmpty();
    }

    @Test
    public void givenValidId_whenGetById_thenEventShouldBeFound() {
        Event event = EventTest.event();
        Mockito.when(eventRespository.findById(event.getId()))
                .thenReturn(Optional.of(event));
        Event resultEvent = eventService.getById(event.getId());
        assertThat(resultEvent.getEventName())
                .isEqualTo(event.getEventName());
    }

    @Test
    public void givenInvalidId_whenGetById_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> eventService.getById(23))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("not found");
    }

    @Test
    public void givenEvent_whenCreate_thenRepositoryCalled() {
        Event event = EventTest.event();
        eventService.createEvent(event);
        verify(eventRespository, times(1)).save(event);
    }
}
