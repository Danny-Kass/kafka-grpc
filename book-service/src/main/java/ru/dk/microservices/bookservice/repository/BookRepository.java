package ru.dk.microservices.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dk.microservices.bookservice.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
