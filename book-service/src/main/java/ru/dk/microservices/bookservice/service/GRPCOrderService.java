package ru.dk.microservices.bookservice.service;

import com.example.grpc.OrderRequest;
import com.example.grpc.OrderServiceGrpc;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import ru.dk.microservices.bookservice.dto.OrderDto;

@Service
@RequiredArgsConstructor
public class GRPCOrderService {

    @GrpcClient("order-service")
    private OrderServiceGrpc.OrderServiceBlockingStub orderServiceBlockingStub;

    public void createOrder(OrderDto orderDto) {
        OrderRequest request = OrderRequest.newBuilder()
                .setStatus(orderDto.getStatus())
                .setDescription(orderDto.getDescription())
                .build();
        orderServiceBlockingStub.addOrder(request);
    }
}
