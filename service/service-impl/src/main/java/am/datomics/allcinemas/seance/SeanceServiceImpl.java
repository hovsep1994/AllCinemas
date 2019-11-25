package am.datomics.allcinemas.seance;

import am.datomics.allcinemas.SeanceRepository;
import am.datomics.allcinemas.service.cinema.CinemaService;
import am.datomics.allcinemas.service.common.EntityNotFoundException;
import am.datomics.allcinemas.service.movie.MovieService;
import am.datomics.allcinemas.service.seance.SeanceService;
import am.datomics.allcinemas.service.seance.dto.SeanceDto;
import am.datomics.allcinemas.service.seance.model.Seance;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class SeanceServiceImpl implements SeanceService {

    private final SeanceRepository seanceRepository;
    private final MovieService movieService;
    private final CinemaService cinemaService;

    @Override
    public Seance create(SeanceDto dto) {
        Seance seance = new Seance();
        seance.setStartTime(dto.getStartTime());
        seance.setMovie(movieService.get(dto.getMovieId()));
        seance.setCinema(cinemaService.get(dto.getCinemaId()));
        seance.setStartTime(dto.getStartTime());
        seance.setPrice(dto.getPrice());
        seance.setFormat(dto.getFormat());
        seanceRepository.save(seance);
        return seance;
    }

    private static RuntimeException getNotFoundError(String id) {
        return new EntityNotFoundException("Not found movie - " + id);
    }

}
