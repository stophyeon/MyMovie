package com.example.movies.domain.Movie;

import com.example.movies.domain.User.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Getter
@Table(name = "movie_table")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movies_id;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    private String poster_path;
    private String title;

    @Builder
    public Movie(String poster_path, String title, User user) {
        this.poster_path = poster_path;
        this.title = title;
        this.user=user;
    }
}
