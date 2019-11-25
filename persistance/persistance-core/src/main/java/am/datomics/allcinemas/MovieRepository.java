package am.datomics.allcinemas;

import am.datomics.allcinemas.service.language.Language;
import am.datomics.allcinemas.service.movie.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface MovieRepository extends MongoRepository<Movie, String> {


    // NOT WORKING
    @Query("{'movie.title':{$elemMatch: { k: ?0, v: ?1 } } }")
    Optional<Movie> findByTitle(Language language, String title);

}
