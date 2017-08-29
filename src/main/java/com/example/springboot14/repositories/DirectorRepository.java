package com.example.springboot14.repositories;

import com.example.springboot14.models.Director;
import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Long>
{
}
