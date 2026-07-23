package com.akshatr.travelportal.repository;

import com.akshatr.travelportal.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    public Optional<Payment> findByUuid(UUID uuid);
}
