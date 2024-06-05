package com.bootlabs.r2dbc.repositories;

import com.bootlabs.r2dbc.entities.Author;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends ReactiveCrudRepository<Author, Long> {
}
