package ru.dk.microservices.bookservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dk.microservices.bookservice.dto.OrderDto;
import ru.dk.microservices.bookservice.service.GRPCOrderService;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final GRPCOrderService grpcOrderService;

    @PostMapping
    public ResponseEntity<Void> addOrder(@RequestBody OrderDto orderDto) {
        grpcOrderService.createOrder(orderDto);
        return ResponseEntity.ok().build();
    }
}
