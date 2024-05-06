package ru.dk.microservices.orderservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {
    private String name;
    private Integer quantity;
}
