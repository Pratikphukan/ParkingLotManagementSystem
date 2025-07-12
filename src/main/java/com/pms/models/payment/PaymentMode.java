package com.pms.models.payment;

import lombok.Getter;

@Getter
public enum PaymentMode {

    CASH("cash"), CREDIT_CARD("creditcard"), DEBIT_CARD("debitcard"), NETBANKING("netbanking");

    private final String paymentMode;

    PaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
}
