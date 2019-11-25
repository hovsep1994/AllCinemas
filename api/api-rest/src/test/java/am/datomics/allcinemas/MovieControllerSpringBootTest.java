package am.datomics.allcinemas;

import am.datomics.allcinemas.common.ApiError;
import am.datomics.allcinemas.service.common.EntityNotFoundException;
import am.datomics.allcinemas.service.movie.MovieService;
import am.datomics.allcinemas.service.movie.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerSpringBootTest {

    @MockBean
    private MovieService movieService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void canRetrieveByIdWhenExist() {
        // given
        given(movieService.get("id")).willReturn(new Movie());

        // when
        ResponseEntity<Movie> superHeroResponse = restTemplate.getForEntity("/movie/id", Movie.class);

        // then
        assertThat(superHeroResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(superHeroResponse.getBody().equals(new Movie()));
    }

    @Test
    public void canRetrieveByIdWhenNotExist() {
        // given
        given(movieService.get("id")).willThrow(new EntityNotFoundException("Entity not found"));

        // when
        ResponseEntity<ApiError> superHeroResponse = restTemplate.getForEntity("/movie/id", ApiError.class);

        // then
        assertThat(superHeroResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(superHeroResponse.getBody()).isInstanceOf(ApiError.class);
    }

}