package am.datomics.allcinemas.cinema;

import am.datomics.allcinemas.CinemaRepository;
import am.datomics.allcinemas.service.cinema.CinemaService;
import am.datomics.allcinemas.service.cinema.model.Cinema;
import am.datomics.allcinemas.service.common.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;

    @Override
    public Cinema get(String id) {
        return find(id).orElseThrow(() -> getNotFoundError(id));
    }

    @Override
    public Optional<Cinema> find(String id) {
        return cinemaRepository.findById(id);
    }

    @Override
    public Cinema create(String name) {
        Cinema cinema = new Cinema();
        cinema.setName(name);
        cinema.setId(UUID.randomUUID().toString());
        cinema.setCreated(LocalDateTime.now());
        cinema.setUpdated(LocalDateTime.now());
        return cinemaRepository.save(cinema);
    }

    private static RuntimeException getNotFoundError(String id) {
        return new EntityNotFoundException("Not found movie - " + id);
    }

}
