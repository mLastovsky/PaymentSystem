package com.mlastovsky.paymentservice.controller;

import com.mlastovsky.paymentservice.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {

    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(@RequestHeader String requestId,
                                                 @RequestBody Payment payment) {
        log.info("Received request with ID {}; Payment amount: {}",
                requestId, payment.getAmount());

        payment.setId(UUID.randomUUID().toString());

        return ResponseEntity.ok()
                .header("requestId", requestId)
                .body(payment);
    }
}
