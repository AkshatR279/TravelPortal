package com.akshatr.travelportal.service;

import com.akshatr.travelportal.model.dto.payment.PaymentUpdateRequest;
import com.akshatr.travelportal.model.entity.Payment;

import java.util.List;

public interface PaymentService {
    public Payment update(PaymentUpdateRequest request);
    public List<Payment> listPayments();
    public Payment get(String uuid);
    public void delete(String uuid);
}
