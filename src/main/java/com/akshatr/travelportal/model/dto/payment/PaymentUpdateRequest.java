package com.akshatr.travelportal.model.dto.payment;

import lombok.Getter;

import java.util.List;

@Getter
public class PaymentUpdateRequest {
    private String action;
    private String uuid;
    private String code;
    private String name;
    private String orderUuid;
    private String userUuid;
}
