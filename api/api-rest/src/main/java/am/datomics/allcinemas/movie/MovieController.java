package am.datomics.allcinemas.movie;


import am.datomics.allcinemas.common.OrikaBeanMapper;
import am.datomics.allcinemas.service.movie.MovieService;
import am.datomics.allcinemas.service.movie.dto.MovieDto;
import am.datomics.allcinemas.service.movie.model.Movie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
@Slf4j
public class MovieController {

    private final MovieService movieService;
    private final OrikaBeanMapper mapper;

    @GetMapping("{id}")
    public Movie get(@NotEmpty @PathVariable String id) {
        log.error("Get movie by id request received");
        Movie movie = movieService.get(id);
        log.error("Get movie by id response returned");
        return movie;
    }

    @PostMapping
    public Movie create(@Valid @RequestBody MovieCreateRequest request) {
        return movieService.create(mapper.map(request, MovieDto.class));
    }

}
