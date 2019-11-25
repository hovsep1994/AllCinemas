package am.datomics.allcinemas.movie;


import am.datomics.allcinemas.common.OrikaBeanMapper;
import am.datomics.allcinemas.service.movie.MovieService;
import am.datomics.allcinemas.service.movie.dto.MovieDto;
import am.datomics.allcinemas.service.movie.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final OrikaBeanMapper mapper;

    @GetMapping("{id}")
    public Movie get(@NotEmpty @PathVariable String id) {
        return movieService.get(id);
    }

    @PostMapping
    public Movie create(@Valid @RequestBody MovieCreateRequest request) {
        return movieService.create(mapper.map(request, MovieDto.class));
    }

}
