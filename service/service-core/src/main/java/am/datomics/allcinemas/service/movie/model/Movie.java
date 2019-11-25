package am.datomics.allcinemas.service.movie.model;

import am.datomics.allcinemas.service.common.AbstractIdentifiableModel;
import am.datomics.allcinemas.service.language.Language;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends AbstractIdentifiableModel {

    private Map<Language, String> title;
    private Map<Language, String> genre;
    private Map<Language, String> description;

    private String trailerUrl;
    private String mainImage;
    private String posterImage;

}
