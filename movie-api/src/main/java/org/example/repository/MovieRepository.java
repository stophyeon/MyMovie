package org.example.repository;


import org.example.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    public Movie findByTitle(String title);

    public Movie findByApiId(Long id);
}
