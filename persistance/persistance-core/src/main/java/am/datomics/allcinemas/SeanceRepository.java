package am.datomics.allcinemas;

import am.datomics.allcinemas.service.movie.model.Movie;
import am.datomics.allcinemas.service.seance.model.Seance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeanceRepository extends MongoRepository<Seance, String> {

    Seance findByMovie(Movie movie);

}
