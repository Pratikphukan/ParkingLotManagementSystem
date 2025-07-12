package com.pms.models.payment;

import lombok.Getter;

@Getter
public enum PaymentStatus {

    SUCCESS("success"), FAILURE("failure"), PENDING("pending");

    private final String paymentStatus;

    PaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
