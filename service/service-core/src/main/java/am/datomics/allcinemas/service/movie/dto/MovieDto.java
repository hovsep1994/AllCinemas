package am.datomics.allcinemas.service.movie.dto;

import am.datomics.allcinemas.service.language.Language;
import lombok.Data;

import java.util.Map;

@Data
public class MovieDto {

    private Map<Language, String> title;
    private Map<Language, String> genre;
    private Map<Language, String> description;

    private String trailerUrl;
    private String mainImage;
    private String posterImage;

}
