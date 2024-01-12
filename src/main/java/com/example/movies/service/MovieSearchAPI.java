package com.example.movies.service;


import com.example.movies.aop.TimeCheck;
import com.example.movies.dto.Cast;
import com.example.movies.dto.SearchRes;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
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
public class  MovieSearchAPI {
    String key = "73b8a45b717547a965c0d9a015f1fdf9";
    public URI makeUri(String q,MakeUri makeUri){
        return makeUri.makeURI();
    };



    //query-param 형태로 URI 생성

    public JSONObject makeJson(URI uri) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(Objects.requireNonNull(response.getBody()));
        return jsonObject;
    }
    public void convertJson(Object o, List<SearchRes> movies){
        JSONObject json = (JSONObject)JSONValue.parse(o.toString());
        JSONObject jsonObject1 = (JSONObject) o;
        Long id = (Long) jsonObject1.get("id");
        String title = (String) jsonObject1.get("title");
        String overview = (String) jsonObject1.get("overview");
        var poster_path = "https://image.tmdb.org/t/p/w220_and_h330_face" + jsonObject1.get("poster_path");
        String backPoster = "https://image.tmdb.org/t/p/w500" + (String) jsonObject1.get("backdrop_path");
        //Double vote_average = (Double) jsonObject1.get("vote_average");
        movies.add(SearchRes.builder()
                .id(id)
                .title(title)
                .overview(overview)
                .poster_path(poster_path)
                //.vote_average(vote_average)
                .build());
    }
    public SearchRes convertJsonById(JSONObject jsonObject){

        Long movie_id = (Long) jsonObject.get("id");
        String overview = (String) jsonObject.get("overview");
        String title = (String) jsonObject.get("title");
        String date = (String) jsonObject.get("release_date");
        Long runtime = (Long) jsonObject.get("runtime");
        String poster_path = "https://image.tmdb.org/t/p/w300_and_h450_face" + (String) jsonObject.get("poster_path");
        String backPoster = "https://image.tmdb.org/t/p/w500" + (String) jsonObject.get("backdrop_path");
        Double vote_average = (Double) jsonObject.get("vote_average");
        return SearchRes.builder()
                .id(movie_id)
                .title(title)
                .overview(overview)
                .poster_path(poster_path)
                .vote_average(vote_average)
                .release_date(date)
                .back_poster(backPoster)
                .runtime(runtime)
                .build();
    }
    //검색어를 통한 영화 조회 api
    @TimeCheck
    public List<SearchRes> searchMovie(String query) throws IOException, ParseException, org.json.simple.parser.ParseException {

        URI uri = makeUri(query,()->{
                    String url = "https://api.themoviedb.org/3/search/movie";
                    return UriComponentsBuilder.fromUriString(url)
                    .queryParam("query", query)
                    .queryParam("api_key", key)
                    .queryParam("language", "ko-KR")
                    .build()
                    .encode()
                    .toUri();});

        JSONObject jsonObject = makeJson(uri);
        JSONArray jsonArray = (JSONArray) jsonObject.get("results");
        List<SearchRes> movies = new ArrayList<>();
        jsonArray.forEach(o->convertJson(o,movies));

        return movies;
    }

    //영화 id를 통한 영화 검색 api
    @TimeCheck
    public SearchRes searchMovieById(String id) throws IOException, ParseException, org.json.simple.parser.ParseException {
        URI uri = makeUri(id,()->{ String url = "https://api.themoviedb.org/3/movie/" + id;
                    return UriComponentsBuilder.fromUriString(url)
                    .queryParam("api_key", key)
                    .queryParam("language", "ko")
                    .build()
                    .encode()
                    .toUri();});
        JSONObject jsonObject = makeJson(uri);
        return convertJsonById(jsonObject);
    }

    //인기 영화 조회 api
    public List<SearchRes> popularMovie() throws IOException, ParseException, org.json.simple.parser.ParseException {

        URI uri = makeUri("",()->{String url = "https://api.themoviedb.org/3/movie/popular";
                    return UriComponentsBuilder.fromUriString(url)
                    .queryParam("api_key", key)
                    .queryParam("language", "ko-KR")
                    .build()
                    .encode()
                    .toUri();});
        //uri를 통해 tmdb 서버와 통신하는 부분
        JSONObject jsonObject = makeJson(uri);
        JSONArray jsonArray = (JSONArray) jsonObject.get("results");
        List<SearchRes> movies = new ArrayList<>();
        jsonArray.forEach(o->convertJson(o,movies));
        return movies;
    }

    @TimeCheck
    public List<SearchRes> searchMovieByGenre(String genre) throws ParseException {

        URI uri = makeUri(genre,()->{String url = "https://api.themoviedb.org/3/discover/movie";
                return UriComponentsBuilder.fromUriString(url)
                    .queryParam("with_genres", genre)
                    .queryParam("api_key", key)
                    .queryParam("language", "ko-KR")
                    .queryParam("sort_by", "popularity.desc")
                    .build()
                    .encode()
                    .toUri();});
        //uri를 통해 tmdb 서버와 통신하는 부분
        JSONObject jsonObject = makeJson(uri);
        JSONArray jsonArray = (JSONArray) jsonObject.get("results");
        List<SearchRes> movies = new ArrayList<>();
        jsonArray.forEach(o->convertJson(o,movies));
        return movies;
    }

    @TimeCheck
    public List<Cast> searchCastById(String id) throws IOException, ParseException, org.json.simple.parser.ParseException {

        URI uri = makeUri(id,()->{String url = "https://api.themoviedb.org/3/movie/" + id + "/credits";
            return UriComponentsBuilder.fromUriString(url)
                    .queryParam("api_key", key)
                    .queryParam("language", "ko")
                    .build()
                    .encode()
                    .toUri();});
        //uri를 통해 tmdb 서버와 통신하는 부분
        List<Cast> casts = new ArrayList<>();
        JSONObject jsonObject = makeJson(uri);
        JSONArray jsonArray = (JSONArray) jsonObject.get("cast");

        for (Object o : jsonArray) {
            JSONObject jsonObject1 = (JSONObject) o;
            Long cast_id = (Long) jsonObject1.get("id");
            String name = (String) jsonObject1.get("name");
            String character = (String) jsonObject1.get("character");
            String profile_path = "https://image.tmdb.org/t/p/w220_and_h330_face/" + (String) jsonObject1.get("profile_path");

            casts.add(Cast.builder()
                    .cast_id(cast_id)
                    .name(name)
                    .character(character)
                    .profile_path(profile_path)
                    .build());
        }
        return casts;
    }

    @TimeCheck
    public Cast searchCast(String cast_id) throws IOException, ParseException, org.json.simple.parser.ParseException {

        URI uri = makeUri(cast_id,()->{String url = "https://api.themoviedb.org/3/person/" + cast_id;
            return UriComponentsBuilder.fromUriString(url)
                    .queryParam("api_key", key)
                    .queryParam("language", "ko")
                    .build()
                    .encode()
                    .toUri();});
        //uri를 통해 tmdb 서버와 통신하는 부분



        JSONObject jsonObject = makeJson(uri);
        Long person_id = (Long) jsonObject.get("id");
        String name = (String) jsonObject.get("name");
        String biography = (String) jsonObject.get("biography");
        String profile_path = "https://image.tmdb.org/t/p/w220_and_h330_face/" + (String) jsonObject.get("profile_path");

        return Cast.builder()
                .cast_id(person_id)
                .biography(biography)
                .name(name)
                .profile_path(profile_path)
                .build();
    }
    @TimeCheck
    public List<SearchRes> searchCastDetail(String id) throws IOException, ParseException, org.json.simple.parser.ParseException {

        URI uri = makeUri(id,()->{ String url = "https://api.themoviedb.org/3/person/" + id + "/movie_credits";
            return UriComponentsBuilder.fromUriString(url)
                    .queryParam("api_key", key)
                    .queryParam("language", "ko")
                    .build()
                    .encode()
                    .toUri();});
        List<SearchRes> movies = new ArrayList<>();
        //uri를 통해 tmdb 서버와 통신하는 부분
        JSONObject jsonObject =makeJson(uri);
        JSONArray jsonArray = (JSONArray) jsonObject.get("cast");

        for (Object o : jsonArray) {
            JSONObject jsonObject1 = (JSONObject) o;
            Long movie_id = (Long) jsonObject1.get("id");
            String title = (String) jsonObject1.get("title");
            String overview = (String) jsonObject1.get("overview");
            String poster_path = "https://image.tmdb.org/t/p/w220_and_h330_face/" + (String) jsonObject1.get("poster_path");

            movies.add(SearchRes.builder()
                            .id(movie_id)
                            .poster_path(poster_path)
                            .title(title)
                            .overview(overview)
                    .build());
        }
        return movies;
    }
}
