package com.example.springboot14.repositories;

import com.example.springboot14.models.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long>
{
}
