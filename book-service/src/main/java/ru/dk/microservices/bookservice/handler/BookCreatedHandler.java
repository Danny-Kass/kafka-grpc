package ru.dk.microservices.bookservice.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.dk.microservices.bookservice.dto.BookDto;
import ru.dk.microservices.bookservice.service.BookService;

@Component
@KafkaListener(topics = "book-created-topic")
@RequiredArgsConstructor
public class BookCreatedHandler {
    private final BookService bookService;
    @KafkaHandler
    public void handle(BookDto bookDto) {
        bookService.save(bookDto);
    }
}
