package ru.dk.microservices.bookservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDto {
    private String status;
    private String description;
}
