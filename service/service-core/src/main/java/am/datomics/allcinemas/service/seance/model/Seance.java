package am.datomics.allcinemas.service.seance.model;

import am.datomics.allcinemas.service.cinema.model.Cinema;
import am.datomics.allcinemas.service.common.AbstractIdentifiableModel;
import am.datomics.allcinemas.service.movie.model.Movie;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Seance extends AbstractIdentifiableModel {

    @DBRef
    private Movie movie;

    @DBRef
    private Cinema cinema;

    private Integer price;
    private LocalDateTime startTime;

    //e.g. 3D eng
    private String format;
}
