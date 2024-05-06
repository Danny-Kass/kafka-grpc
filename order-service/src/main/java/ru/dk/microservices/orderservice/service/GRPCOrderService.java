package ru.dk.microservices.orderservice.service;

import com.example.grpc.OrderRequest;
import com.example.grpc.OrderServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import ru.dk.microservices.orderservice.model.Order;
import ru.dk.microservices.orderservice.repository.OrderRepository;

@GrpcService
@RequiredArgsConstructor
public class GRPCOrderService extends OrderServiceGrpc.OrderServiceImplBase {
    private final OrderRepository orderRepository;

    @Override
    public void addOrder(OrderRequest request, StreamObserver<Empty> responseObserver) {
        Order order = new Order();
        order.setStatus(request.getStatus());
        order.setDescription(request.getDescription());
        orderRepository.save(order);
        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }
}
