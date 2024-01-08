package com.example.movies.service.makeuri;

import com.example.movies.dto.SearchReq;

import java.net.URI;

public interface MakeUri {

    public URI makeURI(SearchReq searchReq);

}
