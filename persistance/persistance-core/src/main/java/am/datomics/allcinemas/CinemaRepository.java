package am.datomics.allcinemas;

import am.datomics.allcinemas.service.cinema.model.Cinema;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CinemaRepository extends MongoRepository<Cinema, String> {
}
