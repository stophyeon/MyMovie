package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.*;
import org.example.service.MovieSearchAPI;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieSearchAPI movieSearchAPI;


    @PostMapping("/search")
    public List<SearchRes> search(@RequestBody SearchReq req) throws IOException, ParseException{

        SearchResList movies = movieSearchAPI.searchMovie(req.getQuery());

        return movies.getResults();
    }
    @GetMapping("/detail")
    public MovieDetailDto detail(@RequestBody SearchReq req) throws IOException, ParseException {
        SearchRes movie = movieSearchAPI.searchMovieById(req.getId());
        CastList castList = movieSearchAPI.searchCastById(req.getId());
        return new MovieDetailDto(movie,castList);
    }
    @GetMapping("/credit")
    public List<Cast> castDetail(@RequestBody SearchReq req) throws IOException, ParseException {
        Actor actor = movieSearchAPI.searchCast(req.getName());

        return actor.getResults();
    }



}
