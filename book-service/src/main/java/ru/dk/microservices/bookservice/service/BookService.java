package ru.dk.microservices.bookservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dk.microservices.bookservice.dto.BookDto;
import ru.dk.microservices.bookservice.model.Book;
import ru.dk.microservices.bookservice.repository.BookRepository;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Integer save(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setQuantity(bookDto.getQuantity());
        Book savedBook = bookRepository.save(book);
        return savedBook.getId();
    }
}
