package com.retail.loyalty.service.impl;

import com.retail.loyalty.entity.Order;
import com.retail.loyalty.repository.OrderRepository;
import com.retail.loyalty.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final R2dbcEntityTemplate template;

    @Override
    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Mono<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Mono<Order> createOrder(Order order) {
        order.setCreatedAt(LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Override
    public Mono<Order> updateOrder(Long id, Order order) {
        return orderRepository.findById(id)
                .flatMap(existingOrder -> {
                    existingOrder.setUserId(order.getUserId());
                    existingOrder.setRewardId(order.getRewardId());
                    existingOrder.setStatus(order.getStatus());
                    existingOrder.setUpdatedAt(LocalDateTime.now());
                    return orderRepository.save(existingOrder);
                });
    }

    @Override
    public Mono<Void> deleteOrder(Long id) {
        return orderRepository.deleteById(id);
    }
}
