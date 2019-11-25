package am.datomics.allcinemas.service.cinema;

import am.datomics.allcinemas.service.cinema.model.Cinema;

import java.util.Optional;

public interface CinemaService {

    Cinema get(String id);

    Optional<Cinema> find(String id);

    Cinema create(String name);
}
