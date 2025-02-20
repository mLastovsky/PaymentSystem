package com.mlastovsky.paymentmanagementservice.proxy;

import com.mlastovsky.paymentservice.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "payments",
        url = "${payment-service.url}")
public interface PaymentsProxy {

    @PostMapping("/payment")
    Payment createPayment(@RequestHeader String requestId,
                          @RequestBody Payment payment);
}
