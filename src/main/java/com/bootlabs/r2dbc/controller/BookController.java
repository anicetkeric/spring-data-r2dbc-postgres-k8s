package com.bootlabs.r2dbc.controller;


import com.bootlabs.r2dbc.entities.Book;
import com.bootlabs.r2dbc.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Book> createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping
    public Flux<Book> getBooks() {
        return bookRepository.findAll();
    }


    @GetMapping("/{bookId}")
    public Mono<ResponseEntity<Book>> getBookById(@PathVariable long bookId){
        return bookRepository.findById(bookId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("{bookId}")
    public Mono<ResponseEntity<Book>> updateBook(@PathVariable long bookId, @RequestBody Mono<Book> bookMono){
        return bookRepository.findById(bookId)
                .flatMap(book -> bookMono.map(u -> {
                    book.setDescription(u.getDescription());
                    book.setPrice(u.getPrice());
                    book.setIsbn(u.getIsbn());
                    book.setPrice(u.getPrice());
                    book.setPage(u.getPage());
                    return book;
                }))
                .flatMap(bookRepository::save)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{bookId}")
    public Mono<ResponseEntity<Void>> deleteBook(@PathVariable long bookId) {
        return bookRepository.findById(bookId)
                .flatMap(s ->
                        bookRepository.delete(s)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}