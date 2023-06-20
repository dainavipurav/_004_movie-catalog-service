package com.abc.learning.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.abc.learning.models.CatalogItem;
import com.abc.learning.models.Movie;
import com.abc.learning.models.Rating;
import com.abc.learning.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalogList(@PathVariable("userId") String userId) {
		
		UserRating userRating = restTemplate.getForObject("http://movie-rating-service/ratings/users/"+userId, UserRating.class);
		
		List<CatalogItem> catalogItems = new ArrayList<>();

//		List<Rating> ratings = restTemplate.getForObject("http://localhost:8009/ratings/"+userId, Rating.class);

		List<Rating> ratings = Arrays.asList(new Rating("A", 4), new Rating("B", 5), new Rating("C", 3));

		for (Rating rating : ratings) {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);

			/*
			 * Movie movie =
			 * webClientBuilder.build().get().uri("http://localhost:8008/movies/"+rating.
			 * getMovieId()) .retrieve() .bodyToMono(Movie.class) .block();
			 */

			catalogItems.add(new CatalogItem(movie.getMovieId(), movie.getName(), "test", rating.getRating()));
		}

		return catalogItems;

	}
}
