package com.akshatr.travelportal.service;

import com.akshatr.travelportal.model.dto.order.OrderUpdateRequest;
import com.akshatr.travelportal.model.entity.Order;

import java.util.List;

public interface OrderService {
    public Order update(OrderUpdateRequest request);
    public List<Order> listOrders();
    public Order get(String uuid);
    public void delete(String uuid);
}
