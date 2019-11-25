package am.datomics.allcinemas.service.movie;

import am.datomics.allcinemas.service.language.Language;
import am.datomics.allcinemas.service.movie.dto.AddTranslationMovieDto;
import am.datomics.allcinemas.service.movie.dto.MovieDto;
import am.datomics.allcinemas.service.movie.model.Movie;

import java.util.Optional;

public interface MovieService {

    Movie get(String id);

    Optional<Movie> find(String id);

    Optional<Movie> findByTitle(Language language, String title);

    Movie create(MovieDto movieDto);

    Movie addTranslation(String id, AddTranslationMovieDto dto);

}
