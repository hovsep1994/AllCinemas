package am.datomics.allcinemas.service.cinema;

import am.datomics.allcinemas.service.cinema.model.Cinema;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class CinemaHelper {

    public static Cinema getCinema() {
        Cinema cinema = new Cinema();
        cinema.setId("id");
        cinema.setName("name");
        cinema.setCreated(LocalDateTime.now());
        cinema.setUpdated(LocalDateTime.now());
        return cinema;
    }

}
