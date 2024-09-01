package com.retail.loyalty.service;

import com.retail.loyalty.entity.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {
    Flux<Order> getAllOrders();

    Mono<Order> getOrderById(Long id);

    Mono<Order> createOrder(Order order);

    Mono<Order> updateOrder(Long id, Order order);

    Mono<Void> deleteOrder(Long id);
}
