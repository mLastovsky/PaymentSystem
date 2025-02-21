package com.mlastovsky.paymentmanagementserviceresttemplate.proxy;

import com.mlastovsky.paymentservice.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class PaymentsProxy {

    private final RestTemplate rest;

    @Value("${payment-service.url}")
    private String paymentServiceUrl;

    public PaymentsProxy(RestTemplate restTemplate) {
        this.rest = restTemplate;
    }

    public Payment createPayment(Payment payment) {
        var uri = paymentServiceUrl + "/payment";

        var headers = new HttpHeaders();
        headers.add("requestId", UUID.randomUUID().toString());

        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, headers);

        var response = rest.exchange(uri,
                HttpMethod.POST,
                httpEntity,
                Payment.class);

        return response.getBody();
    }
}
