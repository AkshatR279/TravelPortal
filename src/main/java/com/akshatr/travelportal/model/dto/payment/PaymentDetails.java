package com.akshatr.travelportal.model.dto.payment;

import com.akshatr.travelportal.model.dto.order.OrderDetails;
import com.akshatr.travelportal.model.dto.user.UserDetails;
import com.akshatr.travelportal.model.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetails {
    private UUID uuid;
    private String code;
    private String name;
    private Boolean active;
    private UserDetails user;
    private OrderDetails order;

    public PaymentDetails(Payment payment){
        this.uuid = payment.getUuid();
        this.code = payment.getCode();
        this.name = payment.getName();
        this.active = payment.getActive();
        this.user = new UserDetails(payment.getUser());
        this.order = new OrderDetails(payment.getOrder());
    }
}
