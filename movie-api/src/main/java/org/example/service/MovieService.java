package org.example.service;



import lombok.RequiredArgsConstructor;
import org.example.domain.Movie;
import org.example.dto.SearchRes;
import org.example.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;



    public boolean duplicated(Movie movie){
        return Objects.equals(movie, movieRepository.findByApiId(movie.getApiId()));
    }
    public List<SearchRes> showMovies(){

        List<SearchRes> myMovies = new ArrayList<>();
        List<Movie> movies = movieRepository.findAll();
        movies.forEach(movie -> {SearchRes searchRes = SearchRes.builder()
                .id(movie.getApiId())
                .title(movie.getTitle())
                .poster_path(movie.getPoster_path())
                .build();
            myMovies.add(searchRes);});
        return myMovies;

    }
    public Movie findMovieByTitle(String title){
        return movieRepository.findByTitle(title);
    }

}
