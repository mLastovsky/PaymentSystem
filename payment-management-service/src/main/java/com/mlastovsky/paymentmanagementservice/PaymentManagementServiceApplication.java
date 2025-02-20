package com.mlastovsky.paymentmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PaymentManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentManagementServiceApplication.class, args);
    }

}
