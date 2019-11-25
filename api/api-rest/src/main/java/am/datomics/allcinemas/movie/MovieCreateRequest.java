package am.datomics.allcinemas.movie;

import am.datomics.allcinemas.service.language.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieCreateRequest {

    private Map<Language, String> title;
    private Map<Language, String> genre;
    private Map<Language, String> description;

    @NotEmpty
    private String trailerUrl;

    @NotEmpty
    private String mainImage;

    @NotEmpty
    private String posterImage;

}
