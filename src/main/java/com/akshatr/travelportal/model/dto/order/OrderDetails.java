package com.akshatr.travelportal.model.dto.order;

import com.akshatr.travelportal.model.dto.payment.PaymentDetailsList;
import com.akshatr.travelportal.model.dto.ticket.TicketDetailsList;
import com.akshatr.travelportal.model.dto.user.UserDetails;
import com.akshatr.travelportal.model.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
    private UUID uuid;
    private String code;
    private String name;
    private Boolean active;
    private UserDetails user;
    private TicketDetailsList tickets;
    private PaymentDetailsList payments;

    public OrderDetails(Order order){
        this.uuid = order.getUuid();
        this.code = order.getCode();
        this.name = order.getName();
        this.active = order.getActive();
        this.user = new UserDetails(order.getUser());
        this.tickets = new TicketDetailsList(order.getTickets());
        this.payments = new PaymentDetailsList(order.getPayments());
    }
}
