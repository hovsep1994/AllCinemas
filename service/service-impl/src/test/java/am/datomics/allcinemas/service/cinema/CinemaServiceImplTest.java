package am.datomics.allcinemas.service.cinema;

import am.datomics.allcinemas.service.cinema.model.Cinema;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class CinemaServiceImplTest {

    @Autowired
    private CinemaService cinemaService;

    @Test
    public void testCinemaCreate() {
        final String cinemaName = "Kinopark";
        final Cinema createdCinema = cinemaService.create(cinemaName);
        assertNotNull(createdCinema);
        assertNotNull(createdCinema.getId());
        assertNotNull(createdCinema.getCreated());
        assertNotNull(createdCinema.getUpdated());
        assertEquals(createdCinema.getName(), cinemaName);
        final Cinema cinema = cinemaService.get(createdCinema.getId());
        assertNotNull(cinema);
        assertEquals(cinema.getId(), createdCinema.getId());
        assertEquals(cinema.getName(), cinemaName);
        assertNotNull(cinema.getCreated());
        assertNotNull(cinema.getUpdated());
    }

}
