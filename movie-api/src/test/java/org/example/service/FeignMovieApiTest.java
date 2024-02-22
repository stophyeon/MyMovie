package org.example.service;

import org.example.dto.SearchRes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class FeignMovieApiTest {
    @Autowired
    FeignMovieApi feignMovieApi;
    @Test
    public void title(){
        ResponseEntity<String> res =feignMovieApi.searchByTitle("아이언맨","ko-kr","73b8a45b717547a965c0d9a015f1fdf9");
        System.out.println(res);
        ResponseEntity<String> res2 = feignMovieApi.searchById("10138","ko-kr","73b8a45b717547a965c0d9a015f1fdf9");
        System.out.println(res2);
        ResponseEntity<String> res3 = feignMovieApi.searchPopular("ko-kr","73b8a45b717547a965c0d9a015f1fdf9");
        System.out.println(res3.getBody());
        ResponseEntity<String> res4 = feignMovieApi.searchByGenre("12","ko-kr","73b8a45b717547a965c0d9a015f1fdf9");
        System.out.println(res4);
    }
}