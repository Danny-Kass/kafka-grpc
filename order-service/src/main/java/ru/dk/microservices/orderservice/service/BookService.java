package ru.dk.microservices.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.dk.microservices.orderservice.dto.BookDto;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {
    private final KafkaTemplate<String, BookDto> kafkaTemplate;

    public void createBook(BookDto bookDto) {
        String key = UUID.randomUUID().toString();
        kafkaTemplate.send("book-created-topic", key, bookDto);
    }
}
