package com.pms.models.payment;

import com.pms.models.BaseModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Payment extends BaseModel {

    private String transactionId;

    private Double amount;

    private LocalDateTime timeOfPayment;

    private PaymentStatus paymentStatus;

    private PaymentMode paymentMode;

    private Invoice invoice;
}
