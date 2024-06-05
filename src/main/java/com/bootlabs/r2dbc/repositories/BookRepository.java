package com.bootlabs.r2dbc.repositories;

import com.bootlabs.r2dbc.entities.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Long> {
}
