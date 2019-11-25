package am.datomics.allcinemas.movie;

import am.datomics.allcinemas.MovieRepository;
import am.datomics.allcinemas.service.common.EntityNotFoundException;
import am.datomics.allcinemas.service.language.Language;
import am.datomics.allcinemas.service.movie.MovieService;
import am.datomics.allcinemas.service.movie.dto.AddTranslationMovieDto;
import am.datomics.allcinemas.service.movie.dto.MovieDto;
import am.datomics.allcinemas.service.movie.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Movie get(String id) {
        return find(id).orElseThrow(() -> getNotFoundError(id));
    }

    public Optional<Movie> find(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Optional<Movie> findByTitle(Language language, String title) {
        return movieRepository.findByTitle(language, title);
    }

    @Override
    public Movie create(MovieDto dto) {
        Movie movie = Movie.builder()
                .description(dto.getDescription())
                .title(dto.getTitle())
                .genre(dto.getGenre())
                .mainImage(dto.getMainImage())
                .posterImage(dto.getPosterImage())
                .trailerUrl(dto.getTrailerUrl()).build();
        movie.setId(UUID.randomUUID().toString());
        movie.setCreated(LocalDateTime.now());
        movie.setUpdated(LocalDateTime.now());
        return movieRepository.save(movie);
    }

    @Override
    public Movie addTranslation(String id, AddTranslationMovieDto dto) {
        final Optional<Movie> optional = movieRepository.findById(id);
        if (optional.isPresent()) {
            final Movie movie = optional.get();
            movie.getTitle().put(dto.getLanguage(), dto.getTitle());
            movie.getGenre().put(dto.getLanguage(), dto.getGenre());
            movie.getDescription().put(dto.getLanguage(), dto.getDescription());
            movie.setUpdated(LocalDateTime.now());
            return movieRepository.save(movie);
        }
        throw getNotFoundError(id);
    }

    private static RuntimeException getNotFoundError(String id) {
        return new EntityNotFoundException("Not found movie - " + id);
    }

}
