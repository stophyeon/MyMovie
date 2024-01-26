package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Cast;
import org.example.dto.SearchReq;
import org.example.dto.SearchRes;
import org.example.dto.SearchResList;
import org.example.service.MovieSearchAPI;
import org.example.service.MovieService;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieSearchAPI movieSearchAPI;
    private final MovieService movieService;

    @PostMapping("/search")
    public List<SearchRes> search(@RequestBody SearchReq req) throws IOException, ParseException{

        SearchResList movies = movieSearchAPI.searchMovie(req.getQuery());

        return movies.getResults();
    }
    @GetMapping("/detail")
    public SearchRes detail(@RequestBody SearchReq req) throws IOException, ParseException {
        SearchRes movie = movieSearchAPI.searchMovieById(req.getId());
        //List<Cast> casts = movieSearchAPI.searchCastById(req.getId());

        return movie;
    }
    @GetMapping("/credit")
    public List<SearchRes> castDetail(@RequestBody SearchReq req) throws IOException, ParseException {
        //Cast cast = movieSearchAPI.searchCast(req.getCastId());
        List<SearchRes> movies = new ArrayList<>();//movieSearchAPI.searchCastDetail(req.getCastId());

        return movies;
    }



}
