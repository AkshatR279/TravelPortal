package com.akshatr.travelportal.controller;

import com.akshatr.travelportal.model.dto.order.OrderDetails;
import com.akshatr.travelportal.model.dto.order.OrderUpdateRequest;
import com.akshatr.travelportal.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/save")
    public OrderDetails save(@RequestBody OrderUpdateRequest request){
        return new OrderDetails(orderService.update(request));
    }

    @GetMapping("/{uuid}")
    public OrderDetails get(@PathVariable String uuid){
        return new OrderDetails(orderService.get(uuid));
    }

    @PostMapping("/search")
    public List<OrderDetails> listUsers(){
        return orderService.listOrders().stream()
                .map(OrderDetails::new)
                .toList();
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid){
        orderService.delete(uuid);
    }
}
