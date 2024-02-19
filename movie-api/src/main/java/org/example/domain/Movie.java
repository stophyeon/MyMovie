package org.example.domain;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Getter
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movies_id;
    @Column(name = "api_id")
    private Long apiId;
    private String poster_path;
    private String title;

    @Builder
    public Movie(String poster_path, String title, Long api_id) {
        this.poster_path = poster_path;
        this.title = title;

        this.apiId = api_id;
    }
}
