package org.example.service;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class  MovieSearchAPI {
    private final String key = "73b8a45b717547a965c0d9a015f1fdf9";
    private final String lang = "ko-kr";
    private final FeignMovieApi feignMovieApi;
    private final ObjectMapper objectMapper;

    public MovieSearchAPI(FeignMovieApi feignMovieApi, ObjectMapper objectMapper) {
        this.feignMovieApi = feignMovieApi;
        this.objectMapper = objectMapper;
    }


    //query-param 형태로 URI 생성


    //검색어를 통한 영화 조회 api

    public SearchResList searchMovie(String query) throws IOException, ParseException, ParseException {
        ResponseEntity<String> res = feignMovieApi.searchByTitle(query,lang,key);
        //포스터는 프론트에서"https://image.tmdb.org/t/p/w220_and_h330_face" & 백포스터 "https://image.tmdb.org/t/p/w500"
        SearchResList resList = objectMapper.readValue(res.getBody(), SearchResList.class);
        //resList.getResults().stream()

        return objectMapper.readValue(res.getBody(), SearchResList.class);
    }

    //영화 id를 통한 영화 검색 api

    public SearchRes searchMovieById(String id) throws IOException, ParseException, ParseException {
        //포스터  "https://image.tmdb.org/t/p/w300_and_h450_face"
        return objectMapper.readValue(feignMovieApi.searchById(id,lang,key).getBody(),SearchRes.class);
    }

    //인기 영화 조회 api
    public SearchResList popularMovie() throws IOException, ParseException, ParseException {

        return objectMapper.readValue(feignMovieApi.searchPopular(lang,key).getBody(),SearchResList.class);
    }


    public SearchResList searchMovieByGenre(String genre) throws ParseException, JsonProcessingException {
        return objectMapper.readValue(feignMovieApi.searchByGenre(genre,lang,key).getBody(), SearchResList.class);
    }


    public CastList searchCastById(String id) throws IOException, ParseException, ParseException {
        return objectMapper.readValue(feignMovieApi.searchCastById(id,lang,key).getBody(),CastList.class);
    }

    public Actor searchCast(String name) throws IOException, ParseException, ParseException {
        return objectMapper.readValue(feignMovieApi.searchCastDetail(name,lang,key).getBody(), Actor.class);
    }


}
