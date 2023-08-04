package com.example.movies.service;


import com.example.movies.domain.Movie.Movie;
import com.example.movies.domain.User.User;
import com.example.movies.dto.SearchRes;
import com.example.movies.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public void addMovies(SearchRes searchRes, User user){
        Movie myMovies = Movie.builder()
                .title(searchRes.getTitle())
                .poster_path(searchRes.getPoster_path())
                .user(user)
                .build();

    }
    public List<Movie> showMovies(){
        return movieRepository.findAll();

    }
    public Movie findMovieByTitle(String title){
        return movieRepository.findByTitle(title);
    }

}
