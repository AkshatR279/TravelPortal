package com.akshatr.travelportal.repository;

import com.akshatr.travelportal.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, Long> {
    public Optional<Order> findByUuid(UUID uuid);
}
