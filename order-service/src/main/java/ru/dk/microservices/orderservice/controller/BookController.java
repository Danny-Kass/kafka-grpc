package ru.dk.microservices.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dk.microservices.orderservice.dto.BookDto;
import ru.dk.microservices.orderservice.service.BookService;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @PostMapping
    ResponseEntity<String> createBook(@RequestBody BookDto bookDto) {
        bookService.createBook(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book created!");
    }
}
