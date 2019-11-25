package am.datomics.allcinemas.service.seance.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SeanceDto {

    private String movieId;
    private String cinemaId;

    private LocalDateTime startTime;
    private Integer price;
    private String format;

}
