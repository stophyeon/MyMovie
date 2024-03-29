package org.example.service;

import org.example.dto.SearchRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "tmdb-api", url = "https://api.themoviedb.org/3")
@Component
public interface FeignMovieApi {
    //https://api.themoviedb.org/3/genre/movie/list?language=ko-kr&api_key=73b8a45b717547a965c0d9a015f1fdf9
    @GetMapping("/search/movie")
    public ResponseEntity<String> searchByTitle(@RequestParam("query") String query,@RequestParam("language") String lang,@RequestParam("api_key") String api_key);
    @GetMapping("/movie/{id}")
    public ResponseEntity<String> searchById(@PathVariable("id") String id,@RequestParam("language") String lang,@RequestParam("api_key") String api_key);
    @GetMapping("/movie/popular")
    public ResponseEntity<String> searchPopular(@RequestParam("language") String lang,@RequestParam("api_key") String api_key);
    @GetMapping("/discover/movie")
    public ResponseEntity<String> searchByGenre(@RequestParam("with_genres") String genre,@RequestParam("language") String lang,@RequestParam("api_key") String api_key);
    @GetMapping("/movie/{id}/credits")
    public ResponseEntity<String> searchCastById(@PathVariable("id") String id,@RequestParam("language") String lang,@RequestParam("api_key") String api_key);
    @GetMapping("/search/person")
    public ResponseEntity<String> searchCastDetail(@RequestParam("query") String name,@RequestParam("language") String lang,@RequestParam("api_key") String api_key);
}
