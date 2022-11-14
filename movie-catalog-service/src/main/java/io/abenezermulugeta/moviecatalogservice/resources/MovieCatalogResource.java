package io.abenezermulugeta.moviecatalogservice.resources;

import io.abenezermulugeta.moviecatalogservice.models.CatalogItem;
import io.abenezermulugeta.moviecatalogservice.models.Movie;
import io.abenezermulugeta.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 3)
        );

        return ratings.stream()
                .map(r -> {
                    Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + r.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), "Test", r.getRating());
                })
                .collect(Collectors.toList());
    }
}
