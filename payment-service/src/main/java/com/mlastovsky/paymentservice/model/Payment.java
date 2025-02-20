package com.mlastovsky.paymentservice.model;

import lombok.Data;

@Data
public class Payment {
    private String id;
    private double amount;
}
