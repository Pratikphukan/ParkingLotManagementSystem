package com.pms.models.payment;

import com.pms.models.BaseModel;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Payment extends BaseModel {

    private String transactionId;

    private Double amount;

    private LocalDateTime timeOfPayment;

    private PaymentStatus paymentStatus;

    private PaymentMode paymentMode;

    private Invoice invoice;

    public Payment(Long id) {
        super(id);
    }
}
