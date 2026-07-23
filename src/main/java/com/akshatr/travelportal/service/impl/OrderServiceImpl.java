package com.akshatr.travelportal.service.impl;

import com.akshatr.travelportal.exception.EntityNotFoundException;
import com.akshatr.travelportal.model.dto.order.OrderUpdateRequest;
import com.akshatr.travelportal.model.entity.*;
import com.akshatr.travelportal.repository.*;
import com.akshatr.travelportal.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Override
    public Order update(OrderUpdateRequest request) {
        User user = userRepository.findByUuid(UUID.fromString(request.getUserUuid()))
                .orElseThrow(() -> new EntityNotFoundException("User not found for the provided UUID."));

        Order order = new Order();
        if("U".equals(request.getAction())){
            order = orderRepository.findByUuid(UUID.fromString(request.getUuid()))
                .orElseThrow(() -> new EntityNotFoundException("Order not found for the provided UUID."));
        }
        else{
            order.setUuid(UUID.randomUUID());
            order.setActive(true);
            order.setUser(user);
        }

        order.setName(request.getName());
        order.setCode(request.getCode());

        return orderRepository.save(order);
    }

    @Override
    public List<Order> listOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order get(String uuid) {
        return orderRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new EntityNotFoundException("Order not found for the provided UUID."));
    }

    @Override
    public void delete(String uuid) {
        Order order = orderRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new EntityNotFoundException("Order not found for the provided UUID."));

        orderRepository.delete(order);
    }
}
