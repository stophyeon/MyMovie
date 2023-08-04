package com.example.movies.service;


import com.example.movies.aop.TimeCheck;
import com.example.movies.dto.SearchReq;
import com.example.movies.dto.SearchRes;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import org.json.simple.parser.ParseException;
import java.util.*;

@Service
public class MovieSearchAPI {
    private final String key;
    {key = "73b8a45b717547a965c0d9a015f1fdf9";}
    @TimeCheck
    public List<SearchRes> searchMovie(SearchReq searchReq) throws IOException, ParseException, org.json.simple.parser.ParseException {
        String url = "https://api.themoviedb.org/3/search/movie";
        URI uri = UriComponentsBuilder.fromUriString(url)
                .queryParam("query",searchReq.getQuery())
                .queryParam("api_key",key)
                .queryParam("language",searchReq.getLanguage())
                .build()
                .encode()
                .toUri();
        //uri를 통해 tmdb 서버와 통신하는 부분
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<?> response = restTemplate.getForEntity(uri, String.class);
        List<SearchRes> movies = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(Objects.requireNonNull(response.getBody()).toString());
        JSONArray jsonArray = (JSONArray)jsonObject.get("results");
        for (Object o : jsonArray) {
            JSONObject jsonObject1 = (JSONObject) o;
            String title = (String) jsonObject1.get("title");
            String overview = (String) jsonObject1.get("overview");
            var poster_path = "https://image.tmdb.org/t/p/w500" + jsonObject1.get("poster_path");
            Double vote_average = (Double) jsonObject1.get("vote_average");
            movies.add(new SearchRes(title, overview, poster_path, vote_average));
        }
        return movies;
    }


}
