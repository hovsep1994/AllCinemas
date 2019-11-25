package am.datomics.allcinemas.service.cinema;

import am.datomics.allcinemas.CinemaRepository;
import am.datomics.allcinemas.cinema.CinemaServiceImpl;
import am.datomics.allcinemas.service.cinema.model.Cinema;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CinemaServiceTest {

    @Mock
    private CinemaRepository cinemaRepository;

    @InjectMocks
    private CinemaServiceImpl cinemaService;

    @Test
    public void testGet() {
        final Cinema expectedCinema = CinemaHelper.getCinema();
        final String id = expectedCinema.getId();

        when(cinemaRepository.findById(id)).thenReturn(Optional.of(expectedCinema));

        Cinema cinema = cinemaService.get(id);
        assertEquals(cinema, expectedCinema);
    }

    @Test
    public void testGetWithNonExistingId() {
        final String id = "id";

        when(cinemaRepository.findById(id)).thenReturn(Optional.empty());

        try {
            cinemaService.get(id);
            fail();
        } catch (RuntimeException e) {
            // expected
        }
    }

    @Test
    public void testFind() {
        Cinema expectedCinema = CinemaHelper.getCinema();
        final String id = expectedCinema.getId();

        when(cinemaRepository.findById(id)).thenReturn(Optional.of(expectedCinema));

        Optional<Cinema> cinema = cinemaService.find(id);

        assertTrue(cinema.isPresent());
        assertEquals(cinema.get(), expectedCinema);
    }

    @Test
    public void testFindWithNonExistingId() {
        final String id = "nonExistingId";

        when(cinemaRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Cinema> cinema = cinemaService.find(id);

        assertFalse(cinema.isPresent());
    }

    @Test
    public void testCreate() {
        String name = "name";

        when(cinemaRepository.save(any(Cinema.class))).then(invocation -> invocation.getArguments()[0]);

        Cinema cinema = cinemaService.create(name);

        assertNotNull(cinema);
        assertNotNull(cinema.getId());
        assertNotNull(cinema.getCreated());
        assertNotNull(cinema.getUpdated());
        assertEquals(cinema.getName(), name);
    }

}
