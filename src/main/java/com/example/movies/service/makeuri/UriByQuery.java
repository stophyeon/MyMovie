package com.example.movies.service.makeuri;

import com.example.movies.dto.SearchReq;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class UriByQuery implements MakeUri{
    private final String key;

    {
        key = "73b8a45b717547a965c0d9a015f1fdf9";
    }



    @Override
    public URI makeURI(SearchReq searchReq){
        String url = "https://api.themoviedb.org/3/search/movie";
        URI uri = UriComponentsBuilder.fromUriString(url)
                .queryParam("query", searchReq.getQuery())
                .queryParam("api_key", key)
                .queryParam("language", searchReq.getLanguage())
                .build()
                .encode()
                .toUri();
        return uri;
    }
}
