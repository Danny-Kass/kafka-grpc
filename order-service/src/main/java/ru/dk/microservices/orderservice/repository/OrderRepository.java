package ru.dk.microservices.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dk.microservices.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
