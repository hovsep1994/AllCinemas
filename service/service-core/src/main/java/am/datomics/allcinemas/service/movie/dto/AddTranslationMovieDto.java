package am.datomics.allcinemas.service.movie.dto;

import am.datomics.allcinemas.service.language.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTranslationMovieDto {

    private Language language;
    private String title;
    private String genre;
    private String description;

}
