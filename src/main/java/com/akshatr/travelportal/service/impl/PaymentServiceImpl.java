package com.akshatr.travelportal.service.impl;

import com.akshatr.travelportal.exception.EntityNotFoundException;
import com.akshatr.travelportal.model.dto.payment.PaymentUpdateRequest;
import com.akshatr.travelportal.model.dto.ticket.TicketUpdateRequest;
import com.akshatr.travelportal.model.entity.*;
import com.akshatr.travelportal.repository.*;
import com.akshatr.travelportal.service.PaymentService;
import com.akshatr.travelportal.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Override
    public Payment update(PaymentUpdateRequest request) {
        User user = userRepository.findByUuid(UUID.fromString(request.getUserUuid()))
                .orElseThrow(() -> new EntityNotFoundException("User not found for the provided UUID."));

        Order order = orderRepository.findByUuid(UUID.fromString(request.getOrderUuid()))
                .orElseThrow(() -> new EntityNotFoundException("Order not found for the provided UUID."));

        Payment payment = new Payment();
        if("U".equals(request.getAction())){
            payment = paymentRepository.findByUuid(UUID.fromString(request.getUuid()))
                .orElseThrow(() -> new EntityNotFoundException("Payment not found for the provided UUID."));
        }
        else{
            payment.setUuid(UUID.randomUUID());
            payment.setActive(true);
            payment.setUser(user);
            payment.setOrder(order);
        }

        payment.setName(request.getName());
        payment.setCode(request.getCode());

        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> listPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment get(String uuid) {
        return paymentRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new EntityNotFoundException("Payment not found for the provided UUID."));
    }

    @Override
    public void delete(String uuid) {
        Payment payment = paymentRepository.findByUuid(UUID.fromString(uuid))
                .orElseThrow(() -> new EntityNotFoundException("Payment not found for the provided UUID."));

        paymentRepository.delete(payment);
    }
}
