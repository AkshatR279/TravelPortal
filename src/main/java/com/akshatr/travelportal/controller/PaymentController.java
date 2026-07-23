package com.akshatr.travelportal.controller;

import com.akshatr.travelportal.model.dto.payment.PaymentDetails;
import com.akshatr.travelportal.model.dto.payment.PaymentUpdateRequest;
import com.akshatr.travelportal.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/save")
    public PaymentDetails save(@RequestBody PaymentUpdateRequest request){
        return new PaymentDetails(paymentService.update(request));
    }

    @GetMapping("/{uuid}")
    public PaymentDetails get(@PathVariable String uuid){
        return new PaymentDetails(paymentService.get(uuid));
    }

    @PostMapping("/search")
    public List<PaymentDetails> listUsers(){
        return paymentService.listPayments().stream()
                .map(PaymentDetails::new)
                .toList();
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid){
        paymentService.delete(uuid);
    }
}
