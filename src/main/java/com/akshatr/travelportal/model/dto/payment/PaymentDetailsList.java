package com.akshatr.travelportal.model.dto.payment;

import com.akshatr.travelportal.model.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetailsList {
    private int count;
    private List<PaymentDetails> paymentList;

    public PaymentDetailsList(List<Payment> payments){
        this.count = payments.size();
        this.paymentList = payments.stream()
                .map(PaymentDetails::new)
                .toList();
    }
}
